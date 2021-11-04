/**
*Shaquan Robinson 
*Example of Schoool Management System
*
*/
import java.lang.Math;
import java.util.Random;




public class Student{

private final int idlength = 8;
private final String ID;
private int grade;
private final String name;
private int fees_paid = 0;
private int Tuition;
Random Rand;



public Student(String name, int grade){
this.name = name;
//System.out.println("Student Name: " + this.name);
this.ID = generateID(idlength); 
//System.out.println("ID#: " + this.ID);
this.grade = grade;
Tuition = 30000;
}

public int getGrade(int grade){
switch(grade){
case 1:
System.out.println("Elementary");
break;
case 2:
System.out.println("Elementary");
break;
case 3:
System.out.println("Elementary");
break;
case 4:
System.out.println("Elementary");
break;
case 5:
System.out.println("Elementary");
break;
case 6:
System.out.println("Middle School");
break;
case 7:
System.out.println("Middle School");
break;
case 8:
System.out.println("Middle School");
break;
case 9:
System.out.println("High School");
break;
case 10:
System.out.println("High School");
break;
case 11:
System.out.println("High School");
break;
case 12:
System.out.println("High School");
break;
case 0:
System.out.println("Pre-School");
break;
}
return grade;
}

public String getName(){
return this.name;
}

public String getID(){
//This method retrieves the students ID  
return this.ID;
}

public int getFees(){
//This method retrieves the current fees after bieng updated
return Tuition;
}

public int getGrade(){
return this.grade;
}

private String generateID(int length){
//This method generates a random password
//for the students

String id = "0123456789";
char[]ID = new char[length];
for(int i=0;i<length;i++){
int rand = (int)(Math.random()*id.length());
ID[i] = id.charAt(rand);
}
return new String(ID);
}

public void  setFees(int payment){
this.fees_paid = payment; 
int updated_fees = Tuition - this.fees_paid;
Tuition = updated_fees;
}


public static Student newStudent(String name,int grade){
//This method allows you to create a new student 
return new Student(name,grade);
} 

}