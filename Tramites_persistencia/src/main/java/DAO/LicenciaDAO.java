package DAO;

import Entidades.Licencia;
import Entidades.Persona;
import Interfaces.ILicenciaDAO;
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

    public Licencia insertarLicencia(Licencia lic) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Calendar fechaMax = (Calendar) lic.getFechaExpedicion().clone();

        fechaMax.add(Calendar.MONTH, lic.getVigencia().getDuracionDias());

        lic.setFechaMax(fechaMax);

        Persona per = lic.getPersona();

        if (per != null) {

            em.getTransaction().begin();

            if (per.getLicencias() != null) {
                per.getLicencias().add(lic);
            } else {
                per.setLicencias(Arrays.asList(lic));
            }

            em.persist(lic);
            em.merge(per);
            em.getTransaction().commit();
            em.refresh(lic);
        } else {
            throw new PersistenceException("La licencia no cuenta con una persona asociada");
        }

        em.close();

        return lic;
    }

//    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
//    }
    @Override
    public void actualizarLicencia(Licencia licencia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
