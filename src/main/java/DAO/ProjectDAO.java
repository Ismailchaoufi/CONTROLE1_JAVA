package DAO;

import Model.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ProjectDAO {
    private EntityManagerFactory emf;

    public ProjectDAO() {
        emf = Persistence.createEntityManagerFactory("studentGi");
    }


    public void addProject(Project project) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(project);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    public Project getProjectById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.find(Project.class, id);
        } finally {
            entityManager.close();
        }
    }


    public List<Project> getAllProjects() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Project p", Project.class).getResultList();
        } finally {
            entityManager.close();
        }
    }


    public void updateProject(Project project) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(project);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    public void deleteProject(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Project project = entityManager.find(Project.class, id);
            if (project != null) {
                entityManager.remove(project);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
