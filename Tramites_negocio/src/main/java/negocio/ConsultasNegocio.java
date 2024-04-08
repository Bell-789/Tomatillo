package negocio;

import DAO.AutomovilDAO;
import DAO.PlacaDAO;
import DAO.TramiteDAO;
import Entidades.Automovil;
import Entidades.Placa;
import Entidades.Tramite;
import dto.AutomovilDTO;
import dto.PlacaDTO;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Katt
 */
public class ConsultasNegocio {

    private PlacaDAO placaDAO = new PlacaDAO();
    private TramiteDAO tt = new TramiteDAO();
    private AutomovilDAO au = new AutomovilDAO();

    public ConsultasNegocio() {
        this.placaDAO = new PlacaDAO();
        this.tt = new TramiteDAO();
        this.au = new AutomovilDAO();
    }

//    public void listarAuto(JTable table, AutomovilDTO auto) throws PersistenciaException {
//        DefaultTableModel model;
//        String[] titulo = {"Id", "Color", "Linea", "Marca", "Modelo", "Numero de Serie", "Tipo de Automovil"};
//        model = new DefaultTableModel(null, titulo);
//
//        List<Automovil> ap = au.consultarTablauto(auto.getNumSerie());
//
//        String[] datos = new String[7];
//        for (Automovil a : ap) {
//            datos[0] = a.getId().toString();
//            datos[1] = a.getColor();
//            datos[2] = a.getLinea();
//            datos[3] = a.getMarca();
//            datos[4] = a.getModelo();
//            datos[5] = a.getNumeroSerie();
//            datos[6] = a.getTipo().toString();
//
//            model.addRow(datos);
//
//        }
//
//        table.setModel(model);
//    }
    public void listarPlaca(JTable table, PlacaDTO pepe) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Id", "Fecha de Recepcion", "Numero de Placa", "Tipo de Vehiculo", "Estado", "Monto"};
        model = new DefaultTableModel(null, titulo);

        List<Placa> p = placaDAO.buscarPlacaTabla(pepe.getNumPlaca());

        String[] datos = new String[6];
        for (Placa plac : p) {
            datos[0] = plac.getId().toString();
            datos[1] = plac.getFechaRecepcion().getCalendarType();
            datos[2] = plac.getNumPlaca();
            datos[3] = plac.getTipoVehiculo().toString();

        }

        String h = placaDAO.consultarID(pepe.getNumPlaca());

        List<Tramite> t = tt.consultarTramitesTabla(h);

        for (Tramite tramite : t) {
            datos[4] = tramite.getActivo().toString();
            datos[5] = tramite.getMonto().toString();

            model.addRow(datos);
        }
        table.setModel(model);
    }

    public void listarTramites(JTable tabla, String idPersona) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Id", "Tipo Tramite", "Estado", "Fecha de Emision", "Monto"};
        model = new DefaultTableModel(null, titulo);

        List<Tramite> t = tt.consultarTramitesTabla(idPersona);

        String[] datos = new String[5];
        for (Tramite tramite : t) {
            datos[0] = tramite.getId().toString();
            datos[1] = tramite.getTipo_tramite();
            datos[2] = tramite.getActivo().toString();
            datos[3] = tramite.getFechaEmision().toString();
            datos[4] = tramite.getMonto().toString();

            model.addRow(datos);

        }
        tabla.setModel(model);
    }
    
    public List<Automovil> consultarTablaAutoPlaca(String numeroPlacaAnterior) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
            Root<Automovil> root = criteria.from(Automovil.class);
            Join<Automovil, Placa> placasJoin = root.join("placas");
            criteria.select(root).distinct(true).where(builder.equal(placasJoin.get("numero"), numeroPlacaAnterior));
            TypedQuery<Automovil> query = em.createQuery(criteria);

            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar la tabla de automóviles por número de placa anterior");
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

}
