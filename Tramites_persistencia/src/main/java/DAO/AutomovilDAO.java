package DAO;

import Entidades.Automovil;
import excepciones.PersistenciaException;
import interfaces.IAutomovilDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Katt
 */
public class AutomovilDAO implements IAutomovilDAO {

    public Automovil registrarAuto(Automovil automovil) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(automovil);

        em.getTransaction().commit();

        em.close();

        return automovil;
    }

}
