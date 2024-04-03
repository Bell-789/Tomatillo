/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAO.AutomovilDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import Entidades.Automovil;
import Entidades.Persona;
import Entidades.Placa;
import dto.AutomovilDTO;
import dto.PlacaDTO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import recursos.TipoVehiculo;
import recursos.ValidaActivo;

/**
 *
 * @author Chris
 */
public class PlacasNegocio {

    private PlacaDAO placasDAO;
    private AutomovilDAO vehiculoDAO;
    private PersonaDAO personaDAO;

    public PlacasNegocio() {
    }

    public PlacaDTO realizarTramitePlaca(PlacaDTO placaDTO) throws PersistenciaException {
        Automovil vehiculo = null;
        Placa placa = new Placa();

        Persona persona = new Persona();
        persona.setRfc(placaDTO.getPersona().getRfc());
        try {
            persona = personaDAO.consultarRFC(persona);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacasNegocio.class.getName()).log(Level.SEVERE, "No se pudo encontrar a la persona intente de nuevo");
            return null;
        }

        AutomovilDTO AutomovilDTO = placaDTO.getVehiculo();

        switch (placaDTO.getTipoVehiculo()) {
            case "Automovil":
                vehiculo = new Automovil();
                placa.setTipoVehiculo(TipoVehiculo.Automovil);
                break;
        }

        vehiculo.setPersona(persona);
        iniciarVehiculo(vehiculo, AutomovilDTO);

        vehiculo = vehiculoDAO.registrarAuto(vehiculo);

        placa.setPersona(persona);
        placa.setAutomovil(vehiculo);
        placa.setMonto(placaDTO.getMonto());
        placa.setFechaEmision(Calendar.getInstance());
        placa.setActivo(ValidaActivo.Activa);
        placa.setNumPlaca(placaDTO.getNumero());

        placa = placasDAO.agregarPlaca(placa);
        placaDTO.setFechaEmision(placa.getFechaEmision());
        return placaDTO;
    }

    private void iniciarVehiculo(Automovil automovil, AutomovilDTO automovilDTO) {
        automovil.setColor(automovilDTO.getColor());
        automovil.setMarca(automovilDTO.getMarca());
        automovil.setModelo(automovilDTO.getModelo());
        automovil.setNumeroSerie(automovilDTO.getNumSerie());
        automovil.setLinea(automovilDTO.getLinea());

    }
}
