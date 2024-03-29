package DAO;
import Model.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class EmployeDAO {
    private EntityManagerFactory emf;

    public EmployeDAO() {
        emf = Persistence.createEntityManagerFactory("studentGi");
    }


    public void addEmploye(Employe employe) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employe);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    public Employe getEmployeById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.find(Employe.class, id);
        } finally {
            entityManager.close();
        }
    }


    public List<Employe> getAllEmployes() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Employe e", Employe.class).getResultList();
        } finally {
            entityManager.close();
        }
    }


    public void updateEmploye(Employe employe) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(employe);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    public void deleteEmploye(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Employe employe = entityManager.find(Employe.class, id);
            if (employe != null) {
                entityManager.remove(employe);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
