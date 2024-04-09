package DAO;

import Entidades.Automovil;
import excepciones.PersistenciaException;
import interfaces.IAutomovilDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Katt
 */
public class AutomovilDAO implements IAutomovilDAO {

    /**
     * Metodo que registra el automovil
     *
     * @param automovil Nuevo automovil generado
     * @return Automovil en la base de datos
     * @throws PersistenciaException tira una persistencia de tipo
     * PersistenciaException
     */
    public Automovil registrarAuto(Automovil automovil) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(automovil);
        em.getTransaction().commit();

        em.close();

        return automovil;
    }

    /**
     * Metodo que regresa si el numero de serie ya existe para que no se repita
     * 
     * @param Automovil a consultar
     * @return True or False
     */
    public boolean existeNumeroSerie(Automovil Automovil) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Automovil> root = criteria.from(Automovil.class);
        criteria.select(builder.count(root));
        criteria.where(builder.equal(root.get("numeroSerie"), Automovil.getNumeroSerie()));
        TypedQuery<Long> query = em.createQuery(criteria);
        Long count = query.getSingleResult();

        em.close();
        return count > 0;
    }

    /**
     * Metodo que busca el vehiculo solicitado
     * 
     * @param vehiculo a cosnultar
     * @return Automovil del que se busco
     * @throws PersistenceException tira una persistencia de tipo
     * PersistenciaException
     */
    public Automovil buscarVehiculo(Automovil vehiculo) throws PersistenceException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);

        Root<Automovil> root = criteria.from(Automovil.class);
        criteria.select(root).
                where(builder.equal(root.get("numeroSerie"), vehiculo.getNumeroSerie()));

        TypedQuery<Automovil> query = em.createQuery(criteria);

        Automovil vehiculoBuscar = query.getSingleResult();
        em.close();
        return vehiculoBuscar;
    }

    /**
     * Consulta la tabla de Automovil por medio del numero de serie
     * 
     * @param numeroSerie a comparar
     * @return Lista de Automovil
     */
    public List<Automovil> consultarTablauto(String numeroSerie) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
        Root<Automovil> root = criteria.from(Automovil.class);
        criteria = criteria.select(root).where(builder.equal(root.get("numeroSerie"), numeroSerie));
        TypedQuery<Automovil> query = em.createQuery(criteria);

        List<Automovil> a = query.getResultList();
        return a;
    }

}
