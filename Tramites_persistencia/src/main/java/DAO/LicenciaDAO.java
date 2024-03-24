package DAO;

import Entidades.Licencia;
import Interfaces.ILicenciaDAO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase encargada de brindar los metodos de licencia.
 *
 * @author Chris, bell y kat
 */
public class LicenciaDAO implements ILicenciaDAO {

    public void insertarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(licencia);

            em.getTransaction().commit();

            em.refresh(licencia);
        } catch (EntityExistsException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("La licencia ya ha sido insertada");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
    }

}
