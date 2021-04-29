import java.lang.Math;
import java.util.Random;

public class Student{

private final int idlength = 8;
private final String ID;
private int grade;
private final String name;
private int fees_paid = 0;
private int fees_total = 30000;
Random Rand;



public Student(String name, int grade){
this.name = name;
//System.out.println("Student Name: " + this.name);
this.ID = generateID(idlength); 
//System.out.println("ID#: " + this.ID);
this.grade = grade;
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
return this.ID;
}

public int getFees(){
return this.fees_total;
}

public int getGrade(){
return this.grade;
}

private String generateID(int length){
String id = "0123456789";
char[]ID = new char[length];
for(int i=0;i<length;i++){
int rand = (int)(Math.random()*id.length());
ID[i] = id.charAt(rand);
}
return new String(ID);
}

public int  payFees(int payment){
int pay = payment+=fees_paid;
int fees = fees_total-=pay;
return fees;
}


public static Student newStudent(String name,int grade){
return new Student(name,grade);
} 

}
 
