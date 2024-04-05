package negocio;

import DAO.AutomovilDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import Entidades.Automovil;
import Entidades.Persona;
import Entidades.Placa;
import dto.AutomovilDTO;
import dto.ManejaPlacaDTO;
import dto.PlacaDTO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.Random;
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
        this.vehiculoDAO = new AutomovilDAO();
        this.placasDAO = new PlacaDAO();
        this.personaDAO=new PersonaDAO();
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
        placa.setNumPlaca(placaDTO.getNumPlaca());

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

    public void existeVehiculo(AutomovilDTO AutomovilDTO) throws PersistenciaException {
        Automovil vehiculo = new Automovil(AutomovilDTO.getNumSerie());
        if (vehiculoDAO.existeNumeroSerie(vehiculo)) {
            Logger.getLogger(PlacasNegocio.class.getName()).log(Level.INFO, "   Ya existe dicho numero de serie");
            throw new PersistenciaException("El número de serie ya existe en los registro, regrese y busque la placa");
        }
    }

    public void calcularCostoVehiculoNuevo(PlacaDTO placaNuevaDTO) {
        switch (placaNuevaDTO.getTipoVehiculo()) {
            case "Automovil":
                placaNuevaDTO.setMonto(1500F);
                break;
        }

    }

    public void calcularCostoVehiculoUsado(ManejaPlacaDTO placaDTO) {
        switch (placaDTO.getTipoVehiculo()) {
            case "Automovil":
                placaDTO.setMonto(1000F);
                break;
        }
    }

    public String generaPlacaNueva() {
        String numero = generarNumeroPlaca();
        Placa placa = new Placa();
        placa.setNumPlaca(numero);
        while (placasDAO.existeNumero(placa)) {
            numero = generarNumeroPlaca();
            placa.setNumPlaca(numero);
        }

        Logger.getLogger(PlacasNegocio.class.getName()).log(Level.INFO, " Se genero perfecatamente el nuevo numero de placa");
        return numero;
    }

    private String generarNumeroPlaca() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        Random random = new Random();

        StringBuilder sbLetras = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(letras.length());
            sbLetras.append(letras.charAt(index));
        }
        StringBuilder sbNumeros = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(numeros.length());
            sbNumeros.append(numeros.charAt(index));
        }
        return sbLetras.toString() + "-" + sbNumeros.toString();
    }
}
