package Interfaces;

import Entidades.Persona;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Chris, bell y kat
 */
public interface IPersonaDAO {

    /**
     * Ingresa 20 personas en la base de datos para su uso
     *
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public Persona insertarPersonas(Persona persona) throws PersistenciaException;

    /**
     * Inserta en la base de datos a 20 personas dadas en el parametro
     *
     * @param personas Lista de personas a insertar
     * @throws PersistenciaException En caso de que exista algun error al
     * insertar a las personas
     */
    public void VeintePersonas(List<Persona> personas) throws PersistenciaException;

    /**
     * Regresa la lista de personas dentro de la base de datos para su uso
     * dentro de la licencia
     *
     * @return Lista de Personas dentro de la Base de datos
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<String> consultarPersonas() throws PersistenciaException;

    /**
     * Consulta por medio de un nombre dado en especifico
     *
     * @return Lista del nombre consultado
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarNombres() throws PersistenciaException;

    /**
     * Consulta por medio de una Fecha de Nacimiento en especifíco
     *
     * @return Lista de las Fechas de nacimiento consultadas
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarFechaNacimiento() throws PersistenciaException;

    /**
     * Consulta por un RFC en especifico
     *
     * @return Lista de los RFC consultados
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public Persona consultarRFC(String RFC) throws PersistenciaException;

    /**
     * Actualiza la lista de Automoviles
     *
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public void actualizarAutomoviles(Persona persona) throws PersistenciaException;

    /**
     * Actualiza la lista de Tramites
     *
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public void actualizarTramites(Persona persona) throws PersistenciaException;

}
