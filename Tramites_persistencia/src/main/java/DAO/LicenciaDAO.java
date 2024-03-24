package DAO;

import Entidades.Licencia;
import Interfaces.ILicenciaDAO;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase encargada de brindar los metodos de licencia.
 *
 * @author Chris, bell y kat
 */
public class LicenciaDAO implements ILicenciaDAO {

    public void insertarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        
    }

    public void ActualizarLicencia(Licencia licencia) throws PersistenciaException {
    }

}
