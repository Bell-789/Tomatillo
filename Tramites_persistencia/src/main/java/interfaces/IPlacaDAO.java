package interfaces;

import Entidades.Placa;
import excepciones.PersistenciaException;

/**
 *
 * @author Katt
 */
public interface IPlacaDAO {
    
    public Placa agregarPlaca(Placa placa);
    
    public Placa buscarPlaca(Placa placa) throws PersistenciaException;
    
    public boolean existePlaca(Placa placa);
    
}
