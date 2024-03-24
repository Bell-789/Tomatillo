package DAO;

import Entidades.Persona;
import excepciones.PersistenciaException;
import Interfaces.IPersonaDAO;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * * Clase encargada de brindar los metodos de persona.
 *
 * @author Chris, bell y kat
 */
public class PersonaDAO implements IPersonaDAO {

    /**
     * Construvtor por ausencia
     */
    public PersonaDAO() {
    }

    /**
     *
     * Metodo que hace 20 inserciones de personas
     *
     * @throws PersistenciaException Arroja una excepcion
     */
    public void insertar20Personas() throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Calendar f = Calendar.getInstance();
            f.set(2004, Calendar.JANUARY, 1);
            Persona p1 = new Persona("LOMJ900101ABC", "Melanie", "Cortez", "Huerta", "6441351615", f);

            Calendar f2 = Calendar.getInstance();
            f2.set(1999, Calendar.FEBRUARY, 10);
            Persona p2 = new Persona("KIFD670512DEF", "Saul", "Ortega", "Hernandez", "6442561915", f2);

            Calendar f3 = Calendar.getInstance();
            f3.set(2000, Calendar.MARCH, 1);
            Persona p3 = new Persona("RENP800224GHI", "Hugo", "Garcia", "Hernandez", "6441756582", f3);

            Calendar f4 = Calendar.getInstance();
            f4.set(2009, Calendar.APRIL, 18);
            Persona p4 = new Persona("QAZW730308JKL", "Martin", "Lopez", "Martinez", "64416583165", f4);

            Calendar f5 = Calendar.getInstance();
            f5.set(1998, Calendar.MAY, 24);
            Persona p5 = new Persona("PLKH880701MNO", "Leo", "Perez", "Gonzalez", "6441561683", f5);

            Calendar f6 = Calendar.getInstance();
            f6.set(1990, Calendar.JUNE, 28);
            Persona p6 = new Persona("NYHB690415PQR", "Adrian", "Alvarez", "Rodrigez", "6442351978", f6);

            Calendar f7 = Calendar.getInstance();
            f7.set(1979, Calendar.JULY, 5);
            Persona p7 = new Persona("XCDR550527STU", "Mario", "Cruz", "Ramirez", "5551234567", f7);

            Calendar f8 = Calendar.getInstance();
            f8.set(1990, Calendar.AUGUST, 3);
            Persona p8 = new Persona("ZXYV820903VWX", "Enzo", "Gomez", "Flores", "9876543210", f8);

            Calendar f9 = Calendar.getInstance();
            f9.set(2002, Calendar.OCTOBER, 31);
            Persona p9 = new Persona("BNMQ761117YZA", "Javier", "Vasquez", "Jimenez", "2345678901", f9);

            Calendar f10 = Calendar.getInstance();
            f10.set(2001, Calendar.SEPTEMBER, 14);
            Persona p10 = new Persona("FDSA640220BCD", "Marcos", "Torres", "Morales", "7778889990", f10);

            Calendar f11 = Calendar.getInstance();
            f11.set(1977, Calendar.NOVEMBER, 2);
            Persona p11 = new Persona("UTRE750912EFG", "Graciela", "Reyes", "Diaz", "3216549870", f11);

            Calendar f12 = Calendar.getInstance();
            f12.set(1996, Calendar.DECEMBER, 16);
            Persona p12 = new Persona("WQPO910602HIJ", "Manuel", "Perez", "Dominguez", "64642351617", f12);

            Calendar f13 = Calendar.getInstance();
            f13.set(2005, Calendar.JULY, 28);
            Persona p13 = new Persona("VCXZ870303KLM", "Emma", "Gutierrez", "Mendoza", "9990001112", f13);

            Calendar f14 = Calendar.getInstance();
            f14.set(1993, Calendar.APRIL, 24);
            Persona p14 = new Persona("JHGF800101NOP", "Margarita", "Soto", "Sanchez", "4445556663", f14);

            Calendar f15 = Calendar.getInstance();
            f15.set(1988, Calendar.SEPTEMBER, 15);
            Persona p15 = new Persona("LKJH920705QRS", "Olivia", "Ruiz", "Aguilar", "8889990004", f15);

            Calendar f16 = Calendar.getInstance();
            f16.set(1997, Calendar.DECEMBER, 15);
            Persona p16 = new Persona("POIU600418TUV", "Paco", "Mendez", "Hernandez", "6442151613", f16);

            Calendar f17 = Calendar.getInstance();
            f17.set(1970, Calendar.OCTOBER, 30);
            Persona p17 = new Persona("MNBV730807WXY", "Abigail", "Castillo", "Martinez", "6667778885", f17);

            Calendar f18 = Calendar.getInstance();
            f18.set(1977, Calendar.JULY, 27);
            Persona p18 = new Persona("ASDF541212ZAB", "Karen", "Ortiz", "Portillo", "4567890123", f18);

            Calendar f19 = Calendar.getInstance();
            f19.set(1966, Calendar.FEBRUARY, 14);
            Persona p19 = new Persona("ERDF800815BCD", "Maddison", "Rivera", "Chavez", "8901234567", f19);

            Calendar f20 = Calendar.getInstance();
            f20.set(2004, Calendar.JANUARY, 6);
            Persona p20 = new Persona("ZXCV770626EFG", "Michelle", "Ramos", "Guszman", "3334445553", f20);

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);
            em.persist(p6);
            em.persist(p7);
            em.persist(p8);
            em.persist(p9);
            em.persist(p10);
            em.persist(p11);
            em.persist(p12);
            em.persist(p13);
            em.persist(p14);
            em.persist(p15);
            em.persist(p16);
            em.persist(p17);
            em.persist(p18);
            em.persist(p19);
            em.persist(p20);

            em.getTransaction().commit();

            em.refresh(p1);
            em.refresh(p2);
            em.refresh(p3);
            em.refresh(p4);
            em.refresh(p5);
            em.refresh(p6);
            em.refresh(p7);
            em.refresh(p8);
            em.refresh(p9);
            em.refresh(p10);
            em.refresh(p11);
            em.refresh(p12);
            em.refresh(p13);
            em.refresh(p14);
            em.refresh(p15);
            em.refresh(p16);
            em.refresh(p17);
            em.refresh(p18);
            em.refresh(p19);
            em.refresh(p20);

        } catch (EntityExistsException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Error en la insertacion");
        } finally {
            em.close();
            emf.close();
        }

    }

    public void actualizarAutomoviles() throws PersistenciaException {
    }

    public void actualizarTramites() throws PersistenciaException {
    }

    /**
     * Regresa la lista de personas dentro de la base de datos para su uso
     * dentro de la licencia
     *
     * @return Lista de Personas dentro de la Base de datos
     * @throws PersistenciaException Arroja una excepcion de tipo
     * PersistenciaException
     */
    public List<String> consultarPersonas() throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        List<Persona> personas = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();

        List<String> list = null;

        for (Persona p1 : personas) {
            list.add(p1.getNombre());
        }

        em.getTransaction().commit();

        em.close();
        em.close();
        return list;
    }

    public void actualizarAutomoviles(Persona persona) throws PersistenciaException {
    }

    public void actualizarTramites(Persona persona) throws PersistenciaException {
    }

    public List<Persona> consultarNombres() throws PersistenciaException {
        return null;
    }

    public List<Persona> consultarFechaNacimiento() throws PersistenciaException {
        return null;
    }

    public List<Persona> consultarRFC() throws PersistenciaException {
        return null;
    }
}
