package interfaces;

import Entidades.Licencia;
import excepciones.PersistenciaException;

/**
 *
 * @author Chris, bell y kat
 */
public interface ILicenciaDAO {

    public Licencia insertarLicencia(Licencia licencia) throws PersistenciaException;
    
    public boolean buscarLicenciaVigente(Licencia licencia) throws PersistenciaException;

}
