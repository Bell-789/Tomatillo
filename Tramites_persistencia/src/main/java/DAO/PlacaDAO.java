package DAO;

import Entidades.Placa;
import excepciones.PersistenciaException;
import interfaces.IPlacaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author Chris
 */
public class PlacaDAO implements IPlacaDAO {

    public Placa agregarPlaca(Placa placa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(placa);

        em.getTransaction().commit();

        em.close();
        return placa;
    }

    public Placa buscarPlaca(Placa placa) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Placa> criteria = cb.createQuery(Placa.class);
        Root<Placa> root = criteria.from(Placa.class);
        criteria.select(root).where(cb.equal(root.get("numPlaca"), placa.getNumPlaca()));
        TypedQuery<Placa> query = em.createQuery(criteria);
        Placa placas;
        try {
            placas = (Placa) query.getSingleResult();

        } catch (NoResultException nre) {
            throw new PersistenciaException("Número de placa inexistente");
        } finally {
            em.close();
        }
        return placas;
    }

    public boolean existePlaca(Placa placa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root<Placa> rootCount = criteria.from(Placa.class);
        criteria.select(cb.count(rootCount)).where(cb.equal(rootCount.get("numero"), placa.getNumPlaca()));
        Long countResult = em.createQuery(criteria).getSingleResult();

        return countResult > 0;
    }

    public boolean existeNumero(Placa placa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);

        Metamodel metamodel = em.getMetamodel();
        EntityType<Placa> Placa_ = metamodel.entity(Placa.class);

        Root<Placa> rootCount = criteria.from(Placa.class);

        criteria.select(cb.count(rootCount)).where(cb.equal(rootCount.get(Placa_.getSingularAttribute("numero")), placa.getNumPlaca()));

        Long countResult = em.createQuery(criteria).getSingleResult();
        return countResult > 0;
    }
}
