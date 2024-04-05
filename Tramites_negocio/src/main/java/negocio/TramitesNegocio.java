package negocio;

import DAO.TramiteDAO;
import Entidades.Persona;
import Entidades.Tramite;
import dto.PersonaDTO;
import dto.TramiteDTO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chris
 */
public class TramitesNegocio {

    private TramiteDAO tramiDAO;

    public TramitesNegocio() {
    }

    public TramitesNegocio(TramiteDAO tramiDAO) {
        this.tramiDAO = tramiDAO;
    }

    public List<TramiteDTO> consultarTramites() {
        try {
            List<Tramite> tramitesEncontrados = tramiDAO.consultarTramites();
            List<TramiteDTO> tramitesDTOEncontrados = new LinkedList<>();

            for (Tramite tramitesEncontrado : tramitesEncontrados) {

                Calendar fechaEmisionCalendar = tramitesEncontrado.getFechaEmision();
                Date fechaEmisionDate = fechaEmisionCalendar.getTime(); // Convertir Calendar a Date

                TramiteDTO tramite = new TramiteDTO(
                        fechaEmisionDate,
                        tramitesEncontrado.getMonto(),
                        fromPersona(tramitesEncontrado.getPersona()));

                tramitesDTOEncontrados.add(tramite);
            }
            return tramitesDTOEncontrados;
        } catch (PersistenciaException ex) {
            Logger.getLogger(TramitesNegocio.class.getName()).log(Level.SEVERE, "No fue posible consultar la lista de tramites");
            return null;
        }
    }

    private PersonaDTO fromPersona(Persona persona) {
        return new PersonaDTO(
                persona.getNombre(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno()
        );
    }

    public void listarTramites(JTable table, String id) throws PersistenciaException {
        DefaultTableModel model;
        String[] titulo = {"Id", "Tipo de Tramite", "Estado", "Fecha de Emision", "Monto"};
        model = new DefaultTableModel(null, titulo);

        List<Tramite> t = tramiDAO.consultarTramitesTabla(id);

        String[] datos = new String[5];
        for (Tramite tramite : t) {
            datos[0] = tramite.getId().toString();
            datos[1] = tramite.getTipo_tramite();
            datos[2] = tramite.getActivo().toString();
            datos[3] = tramite.getFechaEmision().toInstant().toString();
            datos[4] = tramite.getMonto().toString();

            model.addRow(datos);
        }
        table.setModel(model);
    }

}
