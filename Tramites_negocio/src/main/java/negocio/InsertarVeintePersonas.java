/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAO.PersonaDAO;
import Entidades.Persona;
import Forms.JMenu;
import excepciones.PersistenciaException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import recursos.GeneraPersonas;

/**
 *
 * @author Chris
 */
public class InsertarVeintePersonas {

    public InsertarVeintePersonas() {
    }

    /**
     * Variable para indicar si se han insertado las personas.
     */
    private static boolean insertados = false;

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

}
