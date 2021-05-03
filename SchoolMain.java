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
//This method adds a new student that isn't on file



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
//This method finds the student you're looking for that is on file

System.out.print("Enter student first and last name: ");
String name = AdminInput.nextLine();
int studentInfo = school.findStudent(name);
if(name!=null){
school.printStudentInfo();
}else System.out.println("Student not on file");

}
public static void pay_Fees(){
//This is a update fees method, The Method does update the fees but only on the first element in the array 
//The method checks for the student name and if they're on file then the fees are updated but for some reason 
//the method only affects the first element 




System.out.print("Enter first and last name: ");
String name = AdminInput.nextLine();
if(school.findStudent(name)>=0){
System.out.print("Enter Amount: $");
int payment = AdminInput.nextInt();
school.payFees(payment);
System.out.println("Student Account updated, print list again to see students updated information");
} else System.out.println("Student not in the system.");
}

}
