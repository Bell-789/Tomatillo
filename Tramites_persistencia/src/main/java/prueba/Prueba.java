package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Katt
 */
public class Prueba {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }

}
