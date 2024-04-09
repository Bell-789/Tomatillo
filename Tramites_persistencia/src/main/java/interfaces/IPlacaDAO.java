package interfaces;

import Entidades.Placa;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Katt
 */
public interface IPlacaDAO {
    
    /**
     * Metodo para agregar una placa a la base de datos
     * 
     * @param placa nueva a crear
     * @return Placa creada
     */
    public Placa agregarPlaca(Placa placa);
    
    
    /**
     * Metodo que conuslta la placa enviada en parametro
     * 
     * @param placa a consultar
     * @return Placa consultada 
     * @throws PersistenciaException  tira una persistencia de tipo PersistenciaException
     */
    public Placa buscarPlaca(Placa placa) throws PersistenciaException;
    
    /**
     * Metodo para buscar una Lista tipo Placa y convertirla a tabla
     * 
     * @param placa Id de placa que entra
     * @return Lista de toda la tabla de placas
     * @throws PersistenciaException  tira una persistencia de tipo PersistenciaException
     */
    public List<Placa> buscarPlacaTabla(String placa) throws PersistenciaException;
    
    /**
     * Metodo que consulta si la placa ya existe en la base de datos
     * 
     * @param placa a consultar
     * @return True or False
     */
    public boolean existePlaca(Placa placa);
    
}
