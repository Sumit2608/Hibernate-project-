package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="Project_table")
public class Project {
    @Id
    private int P_Id;
    private String P_Name;
    @ManyToMany
    List<Employee> employee;

    public int getP_Id() {
        return P_Id;
    }

    public void setP_Id(int p_Id) {
        P_Id = p_Id;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Project{" +
                "P_Id=" + P_Id +
                ", P_Name='" + P_Name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
