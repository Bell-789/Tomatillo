package DAO;

import Entidades.Persona;
import Entidades.Tramite;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Katt, Bell y Cri
 */
public interface ITramiteDAO {

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
     * @param persona Persona a la cual se le consultaran sus tramites.
     * @return lista de tramites consultados.
     * @throws PersistenciaException Si ocurre algún error durante la consulta
     * en la persistencia de datos.
     */
    public List<Tramite> consultatTramitesPersona(Persona persona) throws PersistenciaException;

}
