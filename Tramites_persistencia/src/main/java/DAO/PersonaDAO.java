/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Persona;
import Excepciones.PersistenciaException;
import Interfaces.IPersonaDAO;
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

    public PersonaDAO() {
    }

    /**
     * Inserta la persona dada en el parametro en la base de datos
     *
     * @param per Persona a insertar
     * @return Persona que se inserto
     * @PersistenciaException Si la entidad ya existe
     */
    @Override
    public Persona insertar(Persona per) throws PersistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.persist(per);

            em.getTransaction().commit();

            em.refresh(per);
        } catch (EntityExistsException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("La persona a insertar ya existe");
        } finally {
            em.close();
            emf.close();

        }
        return per;
    }

    /**
     * Inserta en la base de datos a 20 personas dadas en el parametro
     *
     * @param personas Lista de personas a insertar
     * @throws PersistenciaException En caso de que exista algun error al
     * insertar a las personas
     */
    @Override
    public void insertar20Personas(List<Persona> personas) throws PersistenciaException {
        for (Persona per : personas) {
            try {
                this.insertar(per);
            } catch (PersistenciaException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new PersistenciaException("Error al insertar las personas");
            } catch (EntityExistsException e) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
                throw new PersistenciaException("Personas repetidas");
            }
        }
    }

}
