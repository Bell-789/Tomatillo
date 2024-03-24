package negocio;

import interfaces.IControlNavegacionBO;
import javax.swing.*;

/**
 *
 * @author Katt
 */
public class ControlNavegacion implements IControlNavegacionBO {

    /**
     * Permite la navegacion hacia el Menu
     */
    public void navegarMenu() {
        JMenu jMenu = new JMenu();

        jMenu.setVisible(true);
    }

    /**
     * Permite la navegacion hacia el formulario de Licencia
     */
    public void navegarLicenciaForm() {
//        JLicenciaForm jLicenciaForm = new JLicenciaForm();
//
//        jLicenciaForm.setVisible(true);
    }

}
