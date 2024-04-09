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
import javax.swing.JOptionPane;
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
        this.personaDAO = new PersonaDAO();
    }

    public PlacaDTO realizarTramitePlaca(PlacaDTO placaDTO) throws PersistenciaException {
        Automovil vehiculo = null;
        Placa placa = new Placa();

        Persona persona = new Persona();
        persona.setRfc(placaDTO.getPersona().getRfc());
        try {
            persona = personaDAO.consultarRFC(persona);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona intente de nuevo");
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
        placa.setFechaRecepcion(Calendar.getInstance());

        placa = placasDAO.agregarPlaca(placa);
        placaDTO.setFechaEmision(placa.getFechaEmision());
        return placaDTO;
    }

    public ManejaPlacaDTO realizarTramitePlaca(ManejaPlacaDTO manejaPlacaDTO) {
        Automovil vehiculo = new Automovil(manejaPlacaDTO.getVehiculo().getNumSerie());
        vehiculo = vehiculoDAO.buscarVehiculo(vehiculo);

        Placa placa = new Placa();
        Persona persona = new Persona();
        persona.setRfc(manejaPlacaDTO.getPersona().getRfc());
        try {
            persona = personaDAO.consultarRFC(persona);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona intente de nuevo");
            Logger.getLogger(PlacasNegocio.class.getName()).log(Level.SEVERE, "No se pudo encontrar a la persona intente de nuevo");
            return null;
        }

        placa.setMonto(manejaPlacaDTO.getMonto());
        placa.setActivo(ValidaActivo.Activa);
        placa.setFechaEmision(Calendar.getInstance());
        placa.setPersona(persona);
        placa.setAutomovil(vehiculo);
        placa.setNumPlaca(manejaPlacaDTO.getNumero());
        placa.setFechaRecepcion(Calendar.getInstance());

        switch (manejaPlacaDTO.getTipoVehiculo()) {
            case "Automovil":
                placa.setTipoVehiculo(TipoVehiculo.Automovil);
                break;
        }

        placasDAO.desactivarPlacas(vehiculo);

        placa = placasDAO.agregarPlaca(placa);

        manejaPlacaDTO.setFechaEmision(placa.getFechaEmision());
        return manejaPlacaDTO;
    }

    private void iniciarVehiculo(Automovil automovil, AutomovilDTO automovilDTO) {
        automovil.setColor(automovilDTO.getColor());
        automovil.setMarca(automovilDTO.getMarca());
        automovil.setModelo(automovilDTO.getModelo());
        automovil.setNumeroSerie(automovilDTO.getNumSerie());
        automovil.setLinea(automovilDTO.getLinea());
        automovil.setTipo(automovilDTO.getTipo());
    }

    public void existeVehiculo(AutomovilDTO AutomovilDTO) throws PersistenciaException {
        Automovil vehiculo = new Automovil(AutomovilDTO.getNumSerie());
        if (vehiculoDAO.existeNumeroSerie(vehiculo)) {
            JOptionPane.showMessageDialog(null, "El número de serie ya existe en los registro, regrese y busque la placa");
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

    public ManejaPlacaDTO consultarPlacaPorNumero(ManejaPlacaDTO manejaPlacaDTO) throws PersistenciaException {
        Placa placa = new Placa();
        placa.setNumPlaca(manejaPlacaDTO.getNumero());
        try {
            placa = placasDAO.buscarPlaca(placa);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "No existe el numero de placa buscada");
            Logger.getLogger(PlacasNegocio.class.getName()).log(Level.SEVERE, "No existe el número de placa buscado");
            throw new PersistenciaException("Número de placa inesxistente");
        }

        if (!placa.getPersona().getRfc().equals(manejaPlacaDTO.getPersona().getRfc())) {
            JOptionPane.showMessageDialog(null, "Número de placa de otra persona");
            throw new PersistenciaException("Número de placa de otra persona");
        }

        Automovil vehiculo = placa.getAutomovil();

        manejaPlacaDTO.setVehiculo(new AutomovilDTO());
        manejaPlacaDTO.getVehiculo().setColor(vehiculo.getColor());
        manejaPlacaDTO.getVehiculo().setMarca(vehiculo.getMarca());
        manejaPlacaDTO.getVehiculo().setLinea(vehiculo.getLinea());
        manejaPlacaDTO.getVehiculo().setModelo(vehiculo.getModelo());
        manejaPlacaDTO.getVehiculo().setNumSerie(vehiculo.getNumeroSerie());
        manejaPlacaDTO.getVehiculo().setTipo(vehiculo.getTipo());
        manejaPlacaDTO.setTipoVehiculo(placa.getTipoVehiculo().toString());

        return manejaPlacaDTO;
    }
}
