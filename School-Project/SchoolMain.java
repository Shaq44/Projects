/**
*Shaquan Robinson
*Example of Schoool Management System
*
*/


import java.util.ArrayList;
import java.util.Scanner;
public class SchoolMain{

public static School school = new School("Welmington School For the Gifted");
public static Scanner AdminInput = new Scanner(System.in);


public static void main(String[] args){
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
findInfo();
break;
case 4:
pay_Fees();
break;
case 5:
printList();
break;
case 6:
System.out.println("Total School Funding: $" + school.getSchoolFunds());
break;
case 7:
exit = true;
System.out.println("You have succesfully closed the system");
break;
}
}

}

public static void printMenu(){
System.out.println("1:Print Menu\n2:Add Student or Faculty Info\n3:Find Student \n4:Pay Fees\n5:Print Personnel Info \n6:Show Funds\n7:Exit System");
}




public static void printList(){
System.out.print("Press(T/t) to print teacher list or press(S/s) to print student list: ");
String choice = AdminInput.nextLine();
if(choice.equals("T") || choice.equals("t")){
school.printFaculty();
} else if(choice.equals("S")||choice.equals("s")){
school.printStudentInfo();
}
}







public static void addStudent(){
//This method adds  new students or teachers that isn't on file


System.out.print("Would you like to add a new Student or Teacher to the system, Press(T/t) or (S/s) to add either teacher or student: ");
String choice = AdminInput.nextLine();
if(choice.equals("T")||choice.equals("t")){
System.out.print("Enter faculty first and last name: ");
String Name = AdminInput.nextLine();
System.out.print("Enter faculty members salary: ");
int salary = AdminInput.nextInt();
Teacher teacher = Teacher.addTeacher(Name,salary);
if(school.newFaculty(teacher)){
System.out.println("Name: " + Name + "\nSalary: " + salary + "\nID#: " + teacher.getID());
}
}else if(choice.equals("S")||choice.equals("s")){
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
//}
}

public static void findInfo(){
//This method finds the student you're looking for that is on file
System.out.print("Press(T/t) to look for teachers or press(S/s) to look for student: ");
String choice = AdminInput.nextLine();
if(choice.equals("T")||choice.equals("t")){
System.out.print("Enter teacher first and last name: ");
String name = AdminInput.nextLine();
Teacher teacherInfo = school.searchTeacher(name);
if(name != null){
school.showTeacherInfo(teacherInfo);
}
} else if(choice.equals("S")||choice.equals("s")){
System.out.print("Enter student first and last name: ");
String name = AdminInput.nextLine();
Student studentInfo = school.searchStudent(name);
if(name!=null){
school.showStudentInfo(studentInfo);
}else System.out.println("Person not on file");
}
}


public static void pay_Fees(){
//This is a update fees method, The Method does update the fees but only on the first element in the array 
//The method checks for the student name and if they're on file then the fees are updated but for some reason 
//the method only affects the first element 




System.out.print("Enter first and last name: ");
String name = AdminInput.nextLine();
Student studentInfo = school.searchStudent(name);
if(studentInfo!=null){
System.out.print("Enter Amount: $");
int pay = AdminInput.nextInt();
school.payFees(studentInfo,pay);
System.out.print("Enter amount student paid for school records: $");
int payment = AdminInput.nextInt();
school.setSchoolFunds(payment);
System.out.println("Student Account updated, print list again to see students updated information");
} else System.out.println("Student not in the system.");
}

}