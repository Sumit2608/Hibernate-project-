package beans;

public class Student {
   private int Id;
   private int Roll_no;
   private String Name;
   private String Gender;
   private String Email;
   private String City;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public int getRoll_no() {
	return Roll_no;
}
public void setRoll_no(int roll_no) {
	Roll_no = roll_no;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
@Override
public String toString() {
	return "Student [Id=" + Id + ", Roll_no=" + Roll_no + ", Name=" + Name + ", Gender=" + Gender + ", Email=" + Email
			+ ", City=" + City + "]";
}
   
}
