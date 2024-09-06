package beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="Employee_Data")
public class Employee {
    @Id
    @Column(name="emp_Id")
    private int emp_Id;
    private String Name;
    private String Address;
    private int Age;
    private boolean is_Working;
    private Date dateofjoining;

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean isIs_Working() {
        return is_Working;
    }

    public void setIs_Working(boolean is_Working) {
        this.is_Working = is_Working;
    }

    public Date getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(Date dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_Id=" + emp_Id +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Age=" + Age +
                ", is_Working=" + is_Working +
                ", dateofjoining=" + dateofjoining +
                '}';
    }
}
