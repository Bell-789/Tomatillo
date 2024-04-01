package DAO;

import Entidades.Costo;
import excepciones.PersistenciaException;
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
public class CostoDAO implements ICostoDAO {

    public void insertarCosto(Costo costo) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(costo);

            em.getTransaction().commit();

            em.refresh(costo);
        } catch (EntityExistsException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("La licencia ya ha sido insertada");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void actualizarCosto(Costo costo) throws PersistenciaException {
    }

}
