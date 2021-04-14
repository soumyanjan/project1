package project1;

public class User {
 int regId;
 String studentName ;
 String subject;
public User(int regId, String Name, String subject) {
	this.regId = regId;
     this.studentName = Name;
	this.subject = subject;
}
public User( String name, String subject) {
	this.studentName = name;
	this.subject = subject;
	
}
public int getRegId() {
	return regId;
}
public void setRegId(int regId) {
	this.regId = regId;
}
public String getStudentName() {
	return studentName;
}
public void setName(String name) {
	studentName = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
 

}
