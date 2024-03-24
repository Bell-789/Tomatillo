package DAO;

import Entidades.Licencia;
import Entidades.Persona;
import Interfaces.ILicenciaDAO;
import excepciones.PersistenciaException;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.Calendar;
=======
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
>>>>>>> 4846d1b9c62f0fde358498e3b15adf3f14508a91
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
<<<<<<< HEAD
        
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
        
=======

        try {
            em.getTransaction().begin();

            em.persist(licencia);

            em.getTransaction().commit();

            em.refresh(licencia);
        } catch (EntityExistsException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("La licencia ya ha sido insertada");
        } finally {
            em.close();
            emf.close();
        }
>>>>>>> 4846d1b9c62f0fde358498e3b15adf3f14508a91
    }

    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
    }

}
