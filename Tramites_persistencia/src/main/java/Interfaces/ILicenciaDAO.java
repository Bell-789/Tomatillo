package Interfaces;

import Entidades.Licencia;
import excepciones.PersistenciaException;

/**
 *
 * @author Chris, bell y kat
 */
public interface ILicenciaDAO {

    public void insertarLicencia(Licencia licencia) throws PersistenciaException;

    public void actualizarLicencia(Licencia licencia) throws PersistenciaException;

}
