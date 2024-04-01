/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAO.PersonaDAO;
import Entidades.Persona;
import Forms.JMenu;
import dto.PersonaDTO;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    }

    public PersonasNegocio(PersonaDAO pers) {
        this.pers = new PersonaDAO();
    }

    /**
     * Método privado para insertar personas en la base de datos. Si ya se han
     * insertado personas previamente, muestra mensaje de error. Si no, inserta
     * personas en la base de datos y muestra mensaje de éxito.
     */
    public void insertarPersonas(JMenu form) {
        if (insertados) {
            JOptionPane.showMessageDialog(form, "Ya se han agregado las personas previamente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            insertados = true;
        }
        PersonaDAO pers = new PersonaDAO();
        GeneraPersonas person = new GeneraPersonas();
        try {
            pers.VeintePersonas(person.obtenerPersonas());
            JOptionPane.showMessageDialog(form, "Se agregaron las personas correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(form, "Error al agregar las personas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
            );
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

            return personaEncontrada;
        } catch (PersistenciaException ex) {
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

}
