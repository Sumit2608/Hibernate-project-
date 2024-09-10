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
    private LocalDate DateOfBirth;
    private String Email;
    private String FirstName;
    private String Gender;
    private String LastName;
    private long Phone_no;

    public int getStd_Id() {
        return Std_Id;
    }

    public void setStd_Id(int std_Id) {
        Std_Id = std_Id;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public long getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(long phone_no) {
        Phone_no = phone_no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Std_Id=" + Std_Id +
                ", DateOfBirth=" + DateOfBirth +
                ", Email='" + Email + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Phone_no=" + Phone_no +
                '}';
    }


}
