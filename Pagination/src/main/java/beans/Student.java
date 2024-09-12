package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name="Student")
public class Student {
    @Id
    private int Std_Id;
    private String Name;
    private int Age;

    public int getStd_Id() {
        return Std_Id;
    }

    public void setStd_Id(int std_Id) {
        Std_Id = std_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Std_Id=" + Std_Id +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}



