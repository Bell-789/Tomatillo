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
                per.getTramite().add(licencia);
            } else {
                per.setTramite(Arrays.asList(licencia));
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
        
    }

    public void ActualizarLicencia(Licencia licencia) throws PersistenciaException {
    }

}
