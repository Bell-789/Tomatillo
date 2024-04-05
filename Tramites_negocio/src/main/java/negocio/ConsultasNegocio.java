package negocio;

import DAO.PlacaDAO;
import Entidades.Placa;
import dto.PlacaDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katt
 */
public class ConsultasNegocio {

    private PlacaDAO placaDAO = new PlacaDAO();
    private Placa placa = new Placa();

    public ConsultasNegocio() {
        this.placa = new Placa();
        this.placaDAO = new PlacaDAO();
    }

    public void consultaPlaca(PlacaDTO dto) throws PersistenciaException {
        try {
            placa.setNumPlaca(dto.getNumPlaca());
            placaDAO.buscarPlaca(placa);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultasNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
