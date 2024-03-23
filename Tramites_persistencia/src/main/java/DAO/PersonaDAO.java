package DAO;

import Entidades.Persona;
import excepciones.PersistenciaException;
import Interfaces.IPersonaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * * Clase encargada de brindar los metodos de persona.
 *
 * @author Chris, bell y kat
 */
public class PersonaDAO implements IPersonaDAO {

    public PersonaDAO() {
    }

    public void insertar20Personas() throws PersistenciaException {
//       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//
//            
//            
//            
//            
//            em.persist(per);
//
//            em.getTransaction().commit();
//
//            em.refresh(per);
//        } catch (EntityExistsException e) {
//            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
//            throw new PersistenciaException("La persona a insertar ya existe");
//        } finally {
//            em.close();
//            emf.close();
//        }
//        return per;
//    }

    }
}
