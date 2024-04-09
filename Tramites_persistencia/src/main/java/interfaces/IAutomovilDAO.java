package interfaces;

import Entidades.Automovil;
import excepciones.PersistenciaException;

/**
 *
 * @author Katt
 */
public interface IAutomovilDAO {

    /**
     * Metodo que registra el automovil
     *
     * @param automovil Nuevo automovil generado
     * @return Automovil en la base de datos
     * @throws PersistenciaException tira una persistencia de tipo
     * PersistenciaException
     */
    public Automovil registrarAuto(Automovil automovil) throws PersistenciaException;

}
