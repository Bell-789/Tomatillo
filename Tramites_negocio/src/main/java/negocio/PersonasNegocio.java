package negocio;

import DAO.PersonaDAO;
import Entidades.Persona;
import dto.PersonaDTO;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import recursos.GeneraPersonas;

/**
 *
 * @author Chris
 */
public class PersonasNegocio {

    /**
     * Variable para indicar si se han insertado las personas.
     */
    private static boolean insertados = false;
    private PersonaDAO pers;
    Persona persona;

    public PersonasNegocio() {
        this.pers = new PersonaDAO();
        this.persona = new Persona();
    }

    public PersonasNegocio(PersonaDAO pers) {
        this.pers = new PersonaDAO();
        this.persona = new Persona();
    }

    /**
     * Método privado para insertar personas en la base de datos. Si ya se han
     * insertado personas previamente, muestra mensaje de error. Si no, inserta
     * personas en la base de datos y muestra mensaje de éxito.
     */
    public void insertarPersonas() {
        if (insertados) {
            JOptionPane.showMessageDialog(null, "Ya se han agregado las personas previamente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            insertados = true;
        }
        PersonaDAO pers = new PersonaDAO();
        GeneraPersonas person = new GeneraPersonas();
        try {
            pers.VeintePersonas(person.obtenerPersonas());
            JOptionPane.showMessageDialog(null, "Se agregaron las personas correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar las personas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public PersonaDTO consultarPersonaPorRfc(PersonaDTO personaDTO) throws PersistenciaException {
        try {
            Persona personaBuscar = new Persona();
            personaBuscar.setRfc(personaDTO.getRfc());
            persona = pers.consultarRFC(personaBuscar);
            PersonaDTO personaEncontrada = new PersonaDTO(
                    persona.getRfc(),
                    persona.getNombre(),
                    persona.getApellidoPaterno(),
                    persona.getApellidoMaterno(),
                    persona.getTelefono(),
                    persona.getFechaNacimiento()
            );

            JOptionPane.showMessageDialog(null, "Se encontro la persona!");
            
            return personaEncontrada;
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró una persona con el RFC especificado");
            throw new PersistenciaException("No se encontró una persona con el RFC especificado." + ex);
        }
    }

    public List<PersonaDTO> consultarPersonas() {
        List<PersonaDTO> personasConsultadas = new ArrayList<>();
        try {
            List<Persona> personasEncontradas = pers.consultarPersonas();
            for (Persona personasEncontrada : personasEncontradas) {
                PersonaDTO personaN = new PersonaDTO(
                        personasEncontrada.getRfc(),
                        personasEncontrada.getNombre(),
                        personasEncontrada.getApellidoMaterno(),
                        personasEncontrada.getApellidoPaterno(),
                        personasEncontrada.getTelefono(),
                        personasEncontrada.getFechaNacimiento()
                );
                personasConsultadas.add(personaN);
            }
        } catch (PersistenciaException e) {
            Logger.getLogger(PersonasNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return personasConsultadas;
    }

    public boolean hayRegistros() {
        return pers.hayRegistros();
    }

    public void listarNombres(JTable table, String nombre) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Id", "Nombres", "Apellido Materno", "Apellido Paterno", "RFC", "Fecha Nacimiento", "Telefono"};
        model = new DefaultTableModel(null, titulo);

        List<Persona> p = pers.consultarNombres(nombre);

        String[] datos = new String[7];
        for (Persona persona : p) {
            datos[0] = persona.getId().toString();
            datos[1] = persona.getNombre();
            datos[2] = persona.getApellidoMaterno();
            datos[3] = persona.getApellidoPaterno();
            datos[4] = persona.getRfc();
            datos[5] = persona.getFechaNacimiento().getCalendarType();
            datos[6] = persona.getTelefono();

            model.addRow(datos);
        }
        table.setModel(model);
    }

    public void listarRfc(JTable table, String rfc) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Id", "Nombres", "Apellido Materno", "Apellido Paterno", "RFC", "Fecha Nacimiento", "Telefono"};
        model = new DefaultTableModel(null, titulo);

        List<Persona> p = pers.consultarRFCTabla(rfc);

        String[] datos = new String[7];
        for (Persona persona : p) {
            datos[0] = persona.getId().toString();
            datos[1] = persona.getNombre();
            datos[2] = persona.getApellidoMaterno();
            datos[3] = persona.getApellidoPaterno();
            datos[4] = persona.getRfc();
            datos[5] = persona.getFechaNacimiento().getCalendarType();
            datos[6] = persona.getTelefono();

            model.addRow(datos);
        }
        table.setModel(model);
    }

    public void listarNacimiento(JTable table, String fechaNac) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Id", "Nombres", "Apellido Materno", "Apellido Paterno", "RFC", "Fecha Nacimiento", "Telefono"};
        model = new DefaultTableModel(null, titulo);

        List<Persona> p = pers.consultarFechaNacimiento(fechaNac);

        String[] datos = new String[7];
        for (Persona persona : p) {
            datos[0] = persona.getId().toString();
            datos[1] = persona.getNombre();
            datos[2] = persona.getApellidoMaterno();
            datos[3] = persona.getApellidoPaterno();
            datos[4] = persona.getRfc();
            datos[5] = persona.getFechaNacimiento().getCalendarType().toString();
            datos[6] = persona.getTelefono();

            model.addRow(datos);
        }
        table.setModel(model);
    }

}
