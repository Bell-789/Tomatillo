package negocio;

import DAO.AutomovilDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import DAO.TramiteDAO;
import Entidades.Placa;
import Entidades.Tramite;
import dto.AutomovilDTO;
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
    private AutomovilDAO au = new AutomovilDAO();

    public ConsultasNegocio() {
        this.placaDAO = new PlacaDAO();
        this.tt = new TramiteDAO();
        this.tramitDTO = new TramiteDTO();
        this.au = new AutomovilDAO();
    }

    public void listarPlaca(JTable table, AutomovilDTO pepe) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Id", "Fecha de Recepcion", "Numero de Placa", "Tipo de Vehiculo", "Estado", "Monto"};
        model = new DefaultTableModel(null, titulo);

        String to = au.consultarIDAutomovil(pepe.getNumSerie());
        List<Placa> p = placaDAO.buscarPlacaTabla(to);

        String[] datos = new String[6];
        for (Placa plac : p) {
            datos[0] = plac.getId().toString();
            datos[1] = plac.getFechaRecepcion().getCalendarType();
            datos[2] = plac.getNumPlaca();
            datos[3] = plac.getTipoVehiculo().toString();

        }

        String h = au.consultarIDPersona(to);
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

}
