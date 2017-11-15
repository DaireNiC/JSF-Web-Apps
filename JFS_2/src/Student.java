import javax.faces.bean.ManagedBean;
@ManagedBean
public class Student {
	private String firstName;
	private String surname;
	private String address;
	private String phone;
	private String course;
	private int age;
	private int yearOfBirth;
	private int yearOfGrad;
	private String sex;
	private int yearBorn;
	private int currentYear = 2017;

	
public Student() {
  }

public int getYearOfBirth() {
	return this.currentYear - this.getAge();
}
public int getYearOfGrad() {
	if(this.getCourse() == "BSCHONS"){
		yearOfGrad = 4;
	}else{
		yearOfGrad = 3;
	}
	return this.currentYear + yearOfGrad ;
}

public void setYearOfGrad(int yearOfGrad) {
	this.yearOfGrad = yearOfGrad;
}

public void setYearOfBirth(int yearOfBirth) {
	this.yearOfBirth = yearOfBirth;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}
public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public int getYearBorn() {
	return yearBorn;
}

public void setYearBorn(int yearBorn) {
	this.yearBorn = yearBorn;
}

  
}


