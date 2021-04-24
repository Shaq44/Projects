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



public Student(String name){
this.name = name;
this.ID = generateID(idlength); 
System.out.println("ID#: " + this.ID);
}

public int setGrade(int grade){
switch(grade){
case 1:
System.out.println("Elementary");
case 2:
System.out.println("Elementary");
case 3:
System.out.println("Elementary");
case 4:
System.out.println("Elementary");
case 5:
System.out.println("Elementary");
break;
case 6:
System.out.println("Middle School");
case 7:
System.out.println("Middle School");
case 8:
System.out.println("Middle School");
break;
case 0:
System.out.println("Pre-School");
break;
}
return grade;
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


}
 
