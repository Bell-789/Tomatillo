package negocio;

import Forms.JLicenciaForm;
import Forms.JMenu;
import Forms.ValidacionExitosa;
import Forms.ValidacionFracaso;
import interfaces.IControlNavegacionBO;

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
        JLicenciaForm jLicenciaForm = new JLicenciaForm();

        jLicenciaForm.setVisible(true);
    }

    public void navegarValidaExito() {
        ValidacionExitosa validacionExitosa = new ValidacionExitosa();

        validacionExitosa.setVisible(true);
    }

    public void navegarValidaError() {
        ValidacionFracaso validacionFracaso = new ValidacionFracaso();

        validacionFracaso.setVisible(true);
    }

}
