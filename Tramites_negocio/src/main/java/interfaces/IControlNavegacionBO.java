package interfaces;

/**
 *
 * @author Katt
 */
public interface IControlNavegacionBO {

    /**
     * Maneja la navegacion hacia la pantalla Menu
     *
     */
    public void navegarMenu();

    /**
     * Maneja la navegacion hacia el Formulario de Licencia
     *
     */
    public void navegarLicenciaForm();
    
    /**
     * Maneja una ventana cuando se hace con exito
     */
    public void navegarValidaExito();
    
    /**
     * Maneja una ventana cuando ocurre un error
     */
    public void navegarValidaError();

}
