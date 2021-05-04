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
System.out.println("This Student is already on file");
return false;
}else
this.students.add(students);
return true;
}


public boolean newFaculty(Teacher teacher){
if(findFaculty(teacher.getName()) < 0){
this.teachers.add(teacher);
return true;
}
else System.out.print("Faculty member is already on file");
return false;
}





public void printStudentInfo(){

//This method loops through the list of students and pulls out the information

for(int i=0;i<this.students.size();i++){
System.out.println((i+1) + ".) " + this.students.get(i).getName() + "\nGRADE: " + this.students.get(i).getGrade()+
  "\nID#: " + this.students.get(i).getID() + "\nTuition: $" + this.students.get(i).getFees());
}
}

public Student showStudentInfo(Student student){
if(student != null){
System.out.println("Name: " + student.getName() + "\nID#: " + student.getID() + "\nTuition: " + student.getFees() + "\nGrade: " + student.getGrade());
} else System.out.println("Student not on file.");
return null;
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

public Student searchStudent(String student){
int index = findStudent(student);
if(index>=0){
return this.students.get(index);
}
return null;
}

public int search_Students(Student student){
return this.students.indexOf(student);
}

public Teacher searchTeacher(String teacher){
int index = findFaculty(teacher);
if(index >= 0){
return this.teachers.get(index);
}
return null;
}

public Teacher showTeacherInfo(Teacher teacher){
if(teacher != null){
System.out.println("Name: " + teacher.getName() + "\nSalary: "  + teacher.getSalary() + "\nID#: " + teacher.getID());
} else System.out.println("Faculty member not on file.");
return null;
}


public int payFees(int payment){
//This method finds the student and updates the fees that they pay

for(int i=0;i<this.students.size();i++){
Student name = this.students.get(i);
if(search_Students(name) >= 0){
name.setFees(payment);
System.out.println("Tuition: $" + name.getFees());
}
}
return -1;
}


public int findFaculty(String teacher){
for(int i=0;i<this.teachers.size();i++){
Teacher faculty = this.teachers.get(i);
if(faculty.getName().equals(teacher)){
return i;
}
}
return -1;
}


public void printFaculty(){
for(int i=0;i<this.teachers.size();i++){
System.out.println((i+1) +   ".)" + this.teachers.get(i).getName() + "\nSalary: $" + this.teachers.get(i).getSalary() + "\nID#: " + this.teachers.get(i).getID());
}
}


}





