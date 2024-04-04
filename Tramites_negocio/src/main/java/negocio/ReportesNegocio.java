package negocio;

import DAO.TramiteDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

}
