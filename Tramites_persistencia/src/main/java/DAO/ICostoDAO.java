package DAO;

import Entidades.Costo;
import excepciones.PersistenciaException;

/**
 *
 * @author Katt, Bell y Cri
 */
public interface ICostoDAO {

    public void insertarCosto(Costo costo) throws PersistenciaException;

    public void actualizarCosto(Costo costo) throws PersistenciaException;

}
