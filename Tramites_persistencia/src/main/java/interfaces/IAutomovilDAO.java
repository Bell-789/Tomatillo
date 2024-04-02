package interfaces;

import Entidades.Automovil;
import excepciones.PersistenciaException;

/**
 *
 * @author Katt
 */
public interface IAutomovilDAO {
    
    public Automovil registrarAuto(Automovil automovil) throws PersistenciaException;
    
}
