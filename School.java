import java.util.ArrayList;

public class School{



private ArrayList <Teacher> teachers;
private ArrayList <Student> students;
private int SchoolFunds;
private int StudentTuition = 30000;
private int StudentPayment;
private int SchoolPaySalaries;
private String SchoolName;

public School(String name){
this.SchoolName = name;
this.teachers = new ArrayList<Teacher>();
this.students = new ArrayList<Student>();
}

public boolean newStudent(Student students){
if(findStudent(students.getName())>=0){
System.out.println("This kid is already on file");
return false;
}else
this.students.add(students);
return true;
}

public void printStudentInfo(){
for(int i=0;i<this.students.size();i++){
System.out.println("NAME: " + this.students.get(i).getName() + "\nGRADE: " + this.students.get(i).getGrade()+
"\nFEES: " + this.StudentTuition + "\nID#: " + this.students.get(i).getID());
}
}
public int findStudent(String studentInfo){
for(int i=0;i<this.students.size();i++){
Student student = this.students.get(i);
if(student.getName().equals(studentInfo)){
return i;
}
}
return -1;
}




public int payFees(int payment){
int pay = payment+=this.StudentPayment;
int updatedfees = this.StudentTuition-=pay;
return updatedfees;
}


}








