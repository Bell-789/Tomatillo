package interfaces;

import Entidades.Placa;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Katt
 */
public interface IPlacaDAO {
    
    public Placa agregarPlaca(Placa placa);
    
    public Placa buscarPlaca(Placa placa) throws PersistenciaException;
    
    public List<Placa> buscarPlacaTabla(String placa) throws PersistenciaException;
    
    public boolean existePlaca(Placa placa);
    
}
