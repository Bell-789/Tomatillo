package negocio;

import DAO.PersonaDAO;
import excepciones.PersistenciaException;

/**
 *
 * @author Bell
 */
public class GenerarPersona {

    PersonaDAO personaDAO = new PersonaDAO();

    public void insertarBoton() throws PersistenciaException {
        personaDAO.insertar20Personas();
    }

}
