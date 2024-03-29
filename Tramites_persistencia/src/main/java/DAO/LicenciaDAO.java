package DAO;

import Entidades.Licencia;
import Entidades.Persona;
import Interfaces.ILicenciaDAO;
import excepciones.PersistenciaException;
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

    public Licencia insertarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Calendar fechaMax = (Calendar) licencia.getFechaExpedicion().clone();

        fechaMax.add(Calendar.MONTH, licencia.getVigencia().getDuracionDias());

        licencia.setFechaMax(fechaMax);

        Persona per = licencia.getPersona();

        if (per != null) {

            em.getTransaction().begin();

            if (per.getTramites() != null) {
                per.getTramites().add(licencia);
            } else {
                per.setTramites(Arrays.asList(licencia));
            }

            em.persist(licencia);
            em.merge(per);
            em.getTransaction().commit();
            em.refresh(licencia);
        } else {
            throw new PersistenceException("La licencia no cuenta con una persona asociada");
        }

        em.close();

        return licencia;

//    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
//    }
    }

    @Override
    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
