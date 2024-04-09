package interfaces;

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
     * Realiza una consulta de personas en general.
     *
     * @return regresa una lista de personas registradas en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Persona> consultarPersonas() throws PersistenciaException;

    /**
     * Verifica si existen registros de personas.
     *
     * @return true si hay registros de personas, false si la tabla está vacía.
     */
    public boolean hayRegistros();

    /**
     * Consulta por medio de un nombre dado en especifico
     *
     * @return Lista del nombre consultado
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarNombres(String nombre) throws PersistenciaException;

    /**
     * Consulta por medio de una Fecha de Nacimiento en especifíco
     *
     * @return Lista de las Fechas de nacimiento consultadas
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarFechaNacimiento(String fechaNac) throws PersistenciaException;

    /**
     * Metodo que consulta por el rfc para hacer una tabla
     * 
     * @param rfc a buscar
     * @return Lista de Personas
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<Persona> consultarRFCTabla(String rfc) throws PersistenciaException;

    /**
     * Consulta por un RFC en especifico
     *
     * @return Lista de los RFC consultados
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public Persona consultarRFC(Persona persona) throws PersistenciaException;

}
