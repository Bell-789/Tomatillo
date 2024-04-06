package negocio;

import DAO.PersonaDAO;
import DAO.PlacaDAO;
import DAO.TramiteDAO;
import Entidades.Placa;
import Entidades.Tramite;
import dto.PlacaDTO;
import dto.TramiteDTO;
import excepciones.PersistenciaException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Katt
 */
public class ConsultasNegocio {

    private PlacaDAO placaDAO = new PlacaDAO();
    private TramiteDAO tt = new TramiteDAO();
    private TramiteDTO tramitDTO = new TramiteDTO();

    public ConsultasNegocio() {
        this.placaDAO = new PlacaDAO();
        this.tt = new TramiteDAO();
        this.tramitDTO = new TramiteDTO();
    }

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

}
