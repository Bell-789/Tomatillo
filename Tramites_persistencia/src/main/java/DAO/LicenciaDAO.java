package DAO;

import Entidades.Licencia;
import Entidades.Persona;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de brindar los metodos de licencia.
 *
 * @author Chris, bell y kat
 */
public class LicenciaDAO implements ILicenciaDAO {

    public Licencia insertarLicencia(Licencia licencia){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(licencia);

        em.getTransaction().commit();

        em.close();

        return licencia;
    }

//    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
//    }
    @Override
    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
