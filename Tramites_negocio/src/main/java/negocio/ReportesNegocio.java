package negocio;

import DAO.TramiteDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Katt
 */
public class ReportesNegocio {

    private TramiteDAO d = new TramiteDAO();

    public JasperPrint reporteTramites() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportesNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        //return d.ImprimirReporte(cx);
        return null;
    }

}
