/**
*Shaquan Robinson
*Example of Schoool Management System
*
*/


import java.util.ArrayList;

public class School{



private ArrayList <Teacher> teachers;
private ArrayList <Student> students;
private int SchoolFunds;
private int StudentTuition;
private int StudentPayment;
private int SchoolPaySalaries;
private String SchoolName;

public School(String name){
this.SchoolName = name;
this.teachers = new ArrayList<Teacher>();
this.students = new ArrayList<Student>();
this.StudentTuition = 30000;
}

public boolean newStudent(Student students){

//This method adds a new student if a student isn't alread on file


if(findStudent(students.getName())>=0){
System.out.println("This kid is already on file");
return false;
}else
this.students.add(students);
return true;
}

public void printStudentInfo(){

//This method loops through the list of students and pulls out the information

for(int i=0;i<this.students.size();i++){
System.out.println((i+1) + ".) " + this.students.get(i).getName() + "\nGRADE: " + this.students.get(i).getGrade()+
  "\nID#: " + this.students.get(i).getID() + "\nTuition: " + this.students.get(i).getFees());
}
}


public int findStudent(String studentInfo){
//This method loops through the list and pulls the information for the student you're looking for

for(int i=0;i<this.students.size();i++){
Student student = this.students.get(i);
if(student.getName().equals(studentInfo)){
return i;
}
}
return -1;
}




public int payFees(int payment){
//This method finds the student and updates the fees that they pay

for(int i=0;i<this.students.size();i++){
String student_name = this.students.get(i).getName();
if(findStudent(student_name) >= 0){
this.students.get(i).setFees(payment);
System.out.println("Tuition: $" + this.students.get(i).getFees());
}
return i;
}
return -1;

}



}




