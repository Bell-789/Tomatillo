package negocio;

import DAO.TramiteDAO;
import Entidades.Automovil;
import Entidades.Placa;
import Entidades.Tramite;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Katt
 */
public class ReportesNegocio {

    private TramiteDAO d = new TramiteDAO();

    public ReportesNegocio() {
        this.d = new TramiteDAO();
    }

    public JasperPrint reporteTramites() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tramites";
            Connection cx = DriverManager.getConnection(url, "root", "1512");

            return d.ImprimirReporte(cx);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReportesNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void buscarFecha(JTable tabla, String fecha) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Monto", "Fecha de Emision", "Tipo Tramite", "Nombre"};
        model = new DefaultTableModel(null, titulo);

        List<Tramite> t = d.buscarFecha(fecha);

        String[] datos = new String[4];
        for (Tramite tramite : t) {
            datos[0] = tramite.getMonto().toString();
            datos[1] = tramite.getFechaEmision().toString();
            datos[2] = tramite.getTipo_tramite();
            datos[3] = null;

            model.addRow(datos);

        }
        tabla.setModel(model);
    }

    public void buscarTramite(JTable tabla, String trasm) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Monto", "Fecha de Emision", "Tipo Tramite", "Nombre"};
        model = new DefaultTableModel(null, titulo);

        List<Tramite> t = d.buscarTramite(trasm);

        String[] datos = new String[4];
        for (Tramite tramite : t) {
            datos[0] = tramite.getMonto().toString();
            datos[1] = tramite.getFechaEmision().toString();
            datos[2] = tramite.getTipo_tramite();
            datos[3] = null;

            model.addRow(datos);

        }
        tabla.setModel(model);
    }
    
    

}
