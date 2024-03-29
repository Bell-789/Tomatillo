package DAO;

import Entidades.Persona;
import excepciones.PersistenciaException;
import Interfaces.IPersonaDAO;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

    @Override
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

    public void actualizarAutomoviles() throws PersistenciaException {
    }

    public void actualizarTramites() throws PersistenciaException {
    }

    /**
     * Regresa la lista de personas dentro de la base de datos para su uso
     * dentro de la licencia
     *
     * @return Lista de Personas dentro de la Base de datos
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<String> consultarPersonas() throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        List<Persona> personas = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();

        List<String> list = null;

        for (Persona p1 : personas) {
            list.add(p1.getNombre());
        }

        em.getTransaction().commit();

        em.close();
        em.close();
        return list;
    }

    public void actualizarAutomoviles(Persona persona) throws PersistenciaException {
    }

    public void actualizarTramites(Persona persona) throws PersistenciaException {
    }

    public List<Persona> consultarNombres() throws PersistenciaException {
        return null;
    }

    public List<Persona> consultarFechaNacimiento() throws PersistenciaException {
        return null;
    }

    @Override
    public Persona consultarRFC(String RFC) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);

        criteria = criteria.select(root).where(
                builder.like(root.get("rfc"), RFC));

        TypedQuery<Persona> query = em.createQuery(criteria);

        List<Persona> personas = query.getResultList();
        if (!personas.isEmpty()) {
            return personas.get(0);
        } else {
            return null;
        }
    }
}
