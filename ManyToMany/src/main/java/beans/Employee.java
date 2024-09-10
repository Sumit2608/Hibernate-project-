package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="Employee_table")
public class Employee {
    @Id
    private int Emp_Id;
    private String Emp_Name;
    @ManyToMany
    List<Project> project;

    public int getEmp_Id() {
        return Emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        Emp_Id = emp_Id;
    }

    public String getEmp_Name() {
        return Emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        Emp_Name = emp_Name;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Emp_Id=" + Emp_Id +
                ", Emp_Name='" + Emp_Name + '\'' +
                ", project=" + project +
                '}';
    }
}
