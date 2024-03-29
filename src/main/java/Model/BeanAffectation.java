package Model;

import DAO.EmployeDAO;
import DAO.ProjectDAO;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class BeanAffectation {

    @ManagedProperty("#{employeDAO}")
    private EmployeDAO employeDAO;

    @ManagedProperty("#{projectDAO}")
    private ProjectDAO projectDAO;

    private Long selectedEmployeId;
    private Long selectedProjectId;


    public void setEmployeDAO(EmployeDAO employeDAO) {
        this.employeDAO = employeDAO;
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }


    public List<Employe> getEmployeList() {
        return employeDAO.getAllEmployes();
    }


    public List<Project> getProjectList() {
        return projectDAO.getAllProjects();
    }

    public void affecterEmployeAuProjet() {
        Employe employe = employeDAO.getEmployeById(selectedEmployeId);
        Project project = projectDAO.getProjectById(selectedProjectId);



    }


    public Long getSelectedEmployeId() {
        return selectedEmployeId;
    }

    public void setSelectedEmployeId(Long selectedEmployeId) {
        this.selectedEmployeId = selectedEmployeId;
    }

    public Long getSelectedProjectId() {
        return selectedProjectId;
    }

    public void setSelectedProjectId(Long selectedProjectId) {
        this.selectedProjectId = selectedProjectId;
    }
}
