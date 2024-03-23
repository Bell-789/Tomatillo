package negocio;

import DAO.PersonaDAO;
import Interfaces.IPersonaDAO;
import excepciones.PersistenciaException;
import interfaces.IGenerarPersonasBO;

/**
 *
 * @author Bell
 */
public class GenerarPersona implements IGenerarPersonasBO {

    public void insertarBoton() throws PersistenciaException {
        PersonaDAO iPersonaDAO = new PersonaDAO();

        iPersonaDAO.insertar20Personas();
    }

}
