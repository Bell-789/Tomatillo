package negocio;

import DAO.PersonaDAO;
import DAO.TramiteDAO;
import Entidades.Persona;
import Entidades.Tramite;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Katt
 */
public class ReportesNegocio {

    private TramiteDAO d = new TramiteDAO();
    private PersonaDAO ma = new PersonaDAO();

    public ReportesNegocio() {
        this.d = new TramiteDAO();
        this.ma = new PersonaDAO();
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

    public void buscarNombre(JTable tabla, String nombre) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Monto", "Fecha de Emision", "Tipo Tramite", "Nombre"};
        model = new DefaultTableModel(null, titulo);

        List<Persona> t = ma.consultarNombres(nombre);

        String[] datos = new String[4];
        for (Persona ona : t) {
            datos[3] = ona.getNombre();

        }

        List<Tramite> p = d.buscarTramites();

        for (Tramite rar : p) {
            datos[0] = rar.getMonto().toString();
            datos[1] = rar.getFechaEmision().toString();
            datos[2] = rar.getTipo_tramite();

            model.addRow(datos);
        }
        tabla.setModel(model);
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

        }

        List<Persona> p = ma.consultarPersonas();

        for (Persona per : p) {
            datos[3] = per.getNombre();

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

        }

        List<Persona> p = ma.consultarPersonas();

        for (Persona per : p) {
            datos[3] = per.getNombre();

            model.addRow(datos);
        }
        tabla.setModel(model);
    }
    
    

}
