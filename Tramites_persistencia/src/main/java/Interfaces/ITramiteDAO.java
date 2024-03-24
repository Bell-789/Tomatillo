package Interfaces;

import Entidades.Tramite;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Katt, Bell y Cri
 */
public interface ITramiteDAO {

    public void insertarTramite(Tramite tramite) throws PersistenciaException;

    public void actualizarTramite(Tramite tramite) throws PersistenciaException;

    public List<Tramite> consultaTipo() throws PersistenciaException;

}
