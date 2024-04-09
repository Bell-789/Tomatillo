package DAO;

import interfaces.IPersonaDAO;
import Entidades.Persona;
import Entidades.Tramite;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * * Clase encargada de brindar los metodos de persona.
 *
 * @author Chris, bell y kat
 */
public class PersonaDAO implements IPersonaDAO {

    /**
     * Construvtor por ausencia
     */
    public PersonaDAO() {
    }

    /**
     *
     * Metodo que hace 20 inserciones de personas
     *
     * @throws PersistenciaException Arroja una excepcion
     */
    public Persona insertarPersonas(Persona persona) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.persist(persona);

            em.getTransaction().commit();

            em.refresh(persona);
        } catch (EntityExistsException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("La persona a insertar ya existe");
        } finally {
            em.close();
        }
        return persona;
    }

    /**
     * Inserta en la base de datos a 20 personas dadas en el parametro
     *
     * @param personas Lista de personas a insertar
     * @throws PersistenciaException En caso de que exista algun error al
     * insertar a las personas
     */
    public void VeintePersonas(List<Persona> personas) throws PersistenciaException {
        for (Persona per : personas) {
            try {
                this.insertarPersonas(per);
            } catch (PersistenciaException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new PersistenciaException("Error al insertar las personas");
            } catch (EntityExistsException e) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
                throw new PersistenciaException("Personas repetidas");
            }
        }
    }

    /**
     * Realiza una consulta de personas en general.
     *
     * @return regresa una lista de personas registradas en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Persona> consultarPersonas() throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        List<Persona> personas = null;

        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
            Root<Persona> root = query.from(Persona.class);
            query.select(root);
            personas = em.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar personas: " + e);
        } finally {
            em.close();
        }
        return personas;
    }

    /**
     * Verifica si existen registros de personas.
     *
     * @return true si hay registros de personas, false si la tabla está vacía.
     */
    @Override
    public boolean hayRegistros() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Persona> root = criteria.from(Persona.class);
        criteria.select(builder.count(root));
        TypedQuery<Long> query = em.createQuery(criteria);
        Long count = query.getSingleResult();

        em.close();
        return count != 0;
    }

    /**
     * Consulta por un RFC para devolver una persona
     *
     * @return Persona solicitada
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public Persona consultarRFC(Persona persona) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
            Root<Persona> root = cq.from(Persona.class);

            cq.select(root)
                    .where(cb.equal(root.get("rfc"), persona.getRfc()));

            Persona personaConsultada = em.createQuery(cq).getSingleResult();
            return personaConsultada;
        } catch (NoResultException nre) {
            throw new PersistenciaException("RFC inválido, persona inexistente");
        } finally {
            em.close();
        }
    }

    /**
     * Consulta por un RFC en especifico
     *
     * @return Lista de los RFC consultados
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public Persona consultarRFC(String rfc) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);

        criteria = criteria.select(root).where(
                builder.like(root.get("rfc"), rfc)
        );

        TypedQuery<Persona> query = em.createQuery(criteria);

        List<Persona> personas = query.getResultList();
        if (!personas.isEmpty()) {
            return personas.get(0);
        } else {
            return null;
        }
    }

    /**
     * Consulta por medio de un nombre dado en especifico
     *
     * @return Lista del nombre consultado
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarNombres(String nombre) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);
        criteria = criteria.select(root).where(builder.like(root.get("nombre"), nombre));
        TypedQuery<Persona> query = em.createQuery(criteria);

        List<Persona> lista = query.getResultList();
        return lista;
    }

    /**
     * Consulta por medio de una Fecha de Nacimiento en especifíco
     *
     * @return Lista de las Fechas de nacimiento consultadas
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarFechaNacimiento(String fechaNac) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);
        criteria = criteria.select(root).where(builder.equal(root.get("fechaNacimiento"), fechaNac));
        TypedQuery<Persona> query = em.createQuery(criteria);

        List<Persona> lista = query.getResultList();
        return lista;
    }

    /**
     * Metodo que consulta por el rfc para hacer una tabla
     *
     * @param rfc a buscar
     * @return Lista de Personas
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarRFCTabla(String rfc) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);
        criteria = criteria.select(root).where(builder.equal(root.get("rfc"), rfc));
        TypedQuery<Persona> query = em.createQuery(criteria);

        List<Persona> lista = query.getResultList();
        return lista;
    }

    /**
     * Busca la lista de Personas por medio de 3 parametros
     *
     * @param nombre
     * @param tipo
     * @param fecha
     * @return Lista de Personas
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> buscarTrioTramites(String nombre, String tipo, String fecha) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);
        Join<Persona, Tramite> tramiteJoin = root.join("tramites", JoinType.LEFT);

        Predicate predicate1 = builder.equal(root.get("nombre"), nombre);
        Predicate predicate2 = builder.equal(tramiteJoin.get("fechaEmision"), fecha);
        Predicate predicate3 = builder.equal(tramiteJoin.get("tipo_tramite"), tipo);

        criteria.where(predicate1, predicate2, predicate3);

        //personaJoin.on(builder.equal(personaJoin.get("nombre"), nombre));
        criteria.select(root);

        List<Persona> results = em.createQuery(criteria).getResultList();

        em.close();
        emf.close();

        return results;

    }

}
