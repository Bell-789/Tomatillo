package DAO;

import interfaces.ITramiteDAO;
import Entidades.Persona;
import Entidades.Tramite;
import excepciones.PersistenciaException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Katt, Bell y Cri
 */
public class TramiteDAO implements ITramiteDAO {

    /**
     * Consulta los trámites según los criterios especificados.
     *
     * @return Una lista de trámites que coinciden con los criterios de
     * consulta.
     * @throws PersistenciaException Si ocurre un error durante la consulta en
     * la base de datos.
     */
    @Override
    public List<Tramite> consultarTramites() throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        List<Object[]> resultados = null;
        List<Tramite> historialTramites = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT t.tipo, t.costo, t.fechaEmision, t.persona FROM Tramite t");
            resultados = query.getResultList();
            for (Object[] resultado : resultados) {
                String tipo = (String) resultado[0];
                Float monto = (Float) resultado[1];
                Calendar fechaEmision = (Calendar) resultado[2];
                Persona persona = (Persona) resultado[3];
                Tramite tramite = new Tramite();
                tramite.setTipo_tramite(tipo);
                tramite.setMonto(monto);
                tramite.setFechaEmision(fechaEmision);
                tramite.setPersona(persona);

                historialTramites.add(tramite);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los trámites: " + e.getMessage());
        } finally {
            em.close();
        }

        return historialTramites;
    }

    /**
     * Realiza una consulta en base una persona, para asi obtener el historial
     * de sus tramites.
     *
     * @param persona Persona a la cual se le consultaran sus tramites.
     * @return lista de tramites consultados.
     * @throws PersistenciaException Si ocurre algún error durante la consulta
     * en la persistencia de datos.
     */
    @Override
    public List<Tramite> consultatTramitesPersona(Persona persona) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        List<Tramite> tramites = null;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = cb.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            criteria.select(root).where(cb.equal(root.get("persona").get("rfc"), persona.getRfc()));
            TypedQuery<Tramite> query = em.createQuery(criteria);
            tramites = query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los trámites de la persona: " + e.getMessage());
        } finally {
            em.close();
        }
        return tramites;
    }

    public void actualizarTramite() throws PersistenciaException {
    }

    public JasperPrint ImprimirReporte(Connection cx) {
        InputStream is = getClass().getResourceAsStream("/reportes/Tramite.jasper");
        if (is == null) {
            return null;
        }
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(is);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cx);
            return jp;
        } catch (JRException ex) {
            Logger.getLogger(TramiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Tramite> consultarTramitesTabla(String idPersona) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        Long id = Long.parseLong(idPersona);

        Persona persona = em.find(Persona.class, id);

        CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
        Root<Tramite> root = criteria.from(Tramite.class);
        criteria = criteria.select(root).where(builder.equal(root.get("persona"), persona));
        TypedQuery<Tramite> query = em.createQuery(criteria);

        List<Tramite> lista = query.getResultList();
        return lista;
    }

    public List<Tramite> buscarFecha(String fechaEmision) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
        Root<Tramite> root = criteria.from(Tramite.class);
        criteria = criteria.select(root).where(builder.equal(root.get("fechaEmision"), fechaEmision));
        TypedQuery<Tramite> query = em.createQuery(criteria);

        List<Tramite> lista = query.getResultList();
        return lista;
    }

    public List<Tramite> buscarTramite(String tipo_tramite) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
        Root<Tramite> root = criteria.from(Tramite.class);
        criteria = criteria.select(root).where(builder.equal(root.get("tipo_tramite"), tipo_tramite));
        TypedQuery<Tramite> query = em.createQuery(criteria);

        List<Tramite> lista = query.getResultList();
        return lista;
    }

}
