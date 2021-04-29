import java.util.ArrayList;
import java.util.Scanner;
public class SchoolMain{

public static School school = new School("Welmington School For the Gifted");
public static Scanner AdminInput = new Scanner(System.in);


public static void main(String[] args){
//Teacher teacher = new Teacher("Matt Reeves",38000);
//System.out.println("NAME: " + teacher.getName());
//System.out.println("ID#: " + teacher.getID());
//System.out.println("Salary: " + teacher.getSalary());
//System.out.println("******************************");
//Student student = new Student("Tim Riddle",5);
//System.out.println(student.generateID(4));
//System.out.println("Total Fees: " + student.payFees(5000));
//student.setGrade(6);
//System.out.println("ID#: " + student.getID());
//System.out.println("FEES: " + student.getFees());
//System.out.println("***************************************");
boolean exit = false;
int choice = 0;
printMenu();
while(!exit){
System.out.print("Enter your choice:");
choice = AdminInput.nextInt();
AdminInput.nextLine();
switch(choice){
case 1:
printMenu();
break;
case 2:
addStudent();
break;
case 3:
school.printStudentInfo();
break;
case 4:
findStudent();
break;
case 5:
pay_Fees();
break;
case 6:
exit = true;
System.out.println("You have succesfully closed the system");
break;
}
}

}

public static void printMenu(){
System.out.println("1:Print Menu\n2:Add Student\n3:Print Student Info\n4:Find Student \n5:Pay Fees\n6:Exit System");
}


public static void addStudent(){
System.out.print("Enter new student first and last name: ");
String name = AdminInput.nextLine();
System.out.print("Enter student grade: ");
int grade = AdminInput.nextInt();
Student newStudent = Student.newStudent(name,grade);
if(school.newStudent(newStudent)){
System.out.println("Student Name: " + name + "\nGrade: " + newStudent.getGrade() + "\nID#: " + 
newStudent.getID());
}
}

public static void findStudent(){
System.out.print("Enter student first and last name: ");
String name = AdminInput.nextLine();
int studentInfo = school.findStudent(name);
if(name!=null){
school.printStudentInfo();
}else System.out.println("Student not on file");

}
public static void pay_Fees(){
System.out.print("Enter first and last name: ");
String name = AdminInput.nextLine();
int studentPayment = school.findStudent(name);
if(name != null){
System.out.print("Enter Amount: ");
int pay = AdminInput.nextInt();
school.payFees(pay);
System.out.println("Student Account updated, print list again to see students updated information");
}else System.out.println("Student not on file");
}

}
