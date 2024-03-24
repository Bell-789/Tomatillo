package DAO;

import Entidades.Tramite;
import Interfaces.ITramiteDAO;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Katt, Bell y Cri
 */
public class TramiteDAO implements ITramiteDAO {

    public void insertarTramite(Tramite tramite) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(tramite);

            em.getTransaction().commit();

            em.refresh(tramite);
        } catch (EntityExistsException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("El tramite ya ha sido insertado");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void ActualizarTramite(Tramite tramite) throws PersistenciaException {
    }

    public List<Tramite> consultaTipo() throws PersistenciaException {
        return null;
    }

}
