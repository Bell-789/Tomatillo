package interfaces;

import Entidades.Licencia;
import excepciones.PersistenciaException;

/**
 *
 * @author Chris, bell y kat
 */
public interface ILicenciaDAO {

    /**
     * Metodo que inserta la Licencia en la base de datos
     *
     * @param licencia Licencia nueva
     * @return Licencia creada
     * @throws PersistenciaException tira una persistencia de tipo
     * PersistenciaException
     */
    public Licencia insertarLicencia(Licencia licencia) throws PersistenciaException;

}
