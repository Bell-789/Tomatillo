package interfaces;

import Entidades.Persona;
import Entidades.Tramite;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Katt, Bell y Cri
 */
public interface ITramiteDAO {

    public void actualizarTramite() throws PersistenciaException;
    
    public List<Tramite> consultarTramitesTabla(String idPersona) throws PersistenciaException;

    public JasperPrint ImprimirReporte(Connection cx);

    /**
     * Realiza una consulta de los tramites según el criterio especificado.
     *
     * @return Una lista de objetos Tramite que cumplen con los criterios de
     * búsqueda especificados.
     * @throws PersistenciaException Si ocurre algún error durante la consulta
     * en la persistencia de datos.
     */
    public List<Tramite> consultarTramites() throws PersistenciaException;

    /**
     * Realiza una consulta en base una persona, para asi obtener el historial
     * de sus tramites.
     *
     * @param persona Persona a la cual se le consultaran sus tramites.
     * @return lista de tramites consultados.
     * @throws PersistenciaException Si ocurre algún error durante la consulta
     * en la persistencia de datos.
     */
    public List<Tramite> consultatTramitesPersona(Persona persona) throws PersistenciaException;

}
