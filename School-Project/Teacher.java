import java.lang.Math;


public class Teacher{
private final int ID_length = 12;
private final String ID;
private String name;
private int salary;

public Teacher(String name, int salary){
this.name = name;
//System.out.println("Name: " + this.name);
this.salary = salary;
//System.out.println("Salary: " + this.salary);
this.ID = newID(ID_length);
//System.out.println("ID#: " + this.ID);
}

public int getSalary(){
return this.salary;
}

public void setSalary(int salary){
this.salary = salary;
}

public String getName(){
return this.name;
}

public String getID(){
return this.ID;
}

public String newID(int length){
String id = "012345689";
char []ID = new char[length];
for(int i=0;i<length;i++){
int rand = (int)(Math.random() * id.length());
ID[i] = id.charAt(rand);
}
return new String(ID);
}

public static Teacher addTeacher(String name,int salary){
return new Teacher ( name, salary);
}

}