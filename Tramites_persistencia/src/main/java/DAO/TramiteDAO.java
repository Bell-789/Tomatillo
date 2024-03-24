package DAO;

import Entidades.Tramite;
import Interfaces.ITramiteDAO;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Katt, Bell y Cri
 */
public class TramiteDAO implements ITramiteDAO {

    public void insertarTramite(Tramite tramite) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        
    }

    public void ActualizarTramite(Tramite tramite) throws PersistenciaException {
    }

    public List<Tramite> consultaTipo() throws PersistenciaException {
        return null;
    }

}
