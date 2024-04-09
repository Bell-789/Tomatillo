package DAO;

import interfaces.ILicenciaDAO;
import Entidades.Licencia;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase encargada de brindar los metodos de licencia.
 *
 * @author Chris, bell y kat
 */
public class LicenciaDAO implements ILicenciaDAO {

    /**
     * Metodo que inserta la Licencia en la base de datos
     *
     * @param licencia Licencia nueva
     * @return Licencia creada
     */
    public Licencia insertarLicencia(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(licencia);

        em.getTransaction().commit();

        em.close();

        return licencia;
    }
}
