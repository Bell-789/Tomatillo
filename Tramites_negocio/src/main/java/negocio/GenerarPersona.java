package negocio;

import DAO.PersonaDAO;
import Interfaces.IPersonaDAO;
import excepciones.PersistenciaException;
import interfaces.IGenerarPersonasBO;

/**
 *
 * @author Chris, bell y katt
 */
public class GenerarPersona implements IGenerarPersonasBO {

    /**
     *Abstrae el metodo de Insertar 20 personas
     * 
     * @throws PersistenciaException Arroja una excepcion
     */ 
    
    
    public void insertarBoton() throws PersistenciaException {
        PersonaDAO iPersonaDAO = new PersonaDAO();

        iPersonaDAO.insertar20Personas();
    }

}
