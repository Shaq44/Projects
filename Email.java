import java.lang.Math;
import java.util.Scanner;
public class Email{

private String firstname;
private String lastname;
private String department;
private String emailaddress;
private String password;
private final int defaultpasswordlength = 15;
private int mailboxcapacity;
private String alternateemail;
private String Company = "Company.com";


public Email(){
Scanner in = new Scanner(System.in);
System.out.print("Enter Firstname:");
this.firstname = in.nextLine();
System.out.print("Enter Lastname:");
this.lastname = in.nextLine();
this.password = randomPassword(defaultpasswordlength);
setDepartment();
System.out.println("your password is: " + this.password);
this.emailaddress = firstname.toLowerCase() + "." +  lastname.toLowerCase()  + "@" + this.department + "." +  Company;
System.out.println("your email address is: " + this.emailaddress);
System.out.print("Enter Alternate Email:");
this.alternateemail = setAlternateEmail();
this.mailboxcapacity = setmailCapacity();
System.out.println("Mailbox Capacity: " + this.mailboxcapacity + "MB");
changePassword();
System.out.println("************************************");
printInfo();
}

private  String  setDepartment(){
int choice = 0;
boolean quit;
System.out.print("What department are you in:\n1:Sales\n2:Development\n3:Accounting\nEnter here: ");
Scanner input = new Scanner(System.in);
this.department = department;
choice = input.nextInt();
input.nextLine();


switch(choice){
case 1:
department = "Sales";
break;

case 2:
department = "Development";
break;

case 3:
department = "Accounting";
break;

case 0:
quit=true;
break;

}


if(choice == 0){
System.out.println("You did not choose a department");
}else if(choice > 0 && choice <= 3){
System.out.println("Welcome to your new department, your new password is being generated");
}
return this.department;
}

private String randomPassword(int length){
String PassWord = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvYyZz!@#$%^&*";
char [] password = new char[length];
for(int i=0;i<length;i++){
int Rand = (int) (Math.random() * PassWord.length());
password[i] = PassWord.charAt(Rand);
}
return new  String(password);
}
private String setAlternateEmail(){
Scanner input = new Scanner(System.in);
this.alternateemail = input.nextLine();
System.out.println("Alternate Email: " + this.alternateemail);
return this.alternateemail;
} 
private int  setmailCapacity(){
int capacity = 500;
this.mailboxcapacity = capacity;
return this.mailboxcapacity;
}
private void changePassword(){
System.out.print("Would you like to change your password(Y/N): ");
Scanner input = new Scanner(System.in);
String choice = input.nextLine();
if(choice.equals("N") || choice.equals("n")){
 System.out.println("Password not changed and will remain: " + this.password);
}else if(choice.equals("Y") || choice.equals("y")){ System.out.print("Enter new Password: ");
this.password = input.nextLine();
System.out.println("New Password: " + this.password);
}
}
private void printInfo(){
boolean print = false;
System.out.print("is all the information correct(Y/N)? ");
Scanner input = new Scanner(System.in);
String choice = input.nextLine();
if(choice.equals("Y") || choice.equals("y")){
System.out.println("Name: " + this.firstname + " "  + this.lastname + "\nDepartment: " + this.department +  "\nEmail: " + this.emailaddress + "\nAlternate Email: " + this.alternateemail + "\nPassword: "
 + this.password); 
}else if(choice.equals("N") || choice.equals("n")){
System.out.print("What would you like to Edit? \n1:Password \n2:Name\n3:Department\n4:Alternate Email\n0:Print Information\nPick Option: ");
int choose = input.nextInt();
while(!print){
switch(choose){
case 1:
System.out.print("Enter new password: ");
this.password = input.nextLine();
break;
case 2:
this.firstname = input.nextLine();
System.out.print("Enter First Name: ");
this.lastname = input.nextLine();
System.out.print("Enter Last Name: ");
break;
case 3:
this.department = input.nextLine();
System.out.print("Enter new Department: ");
break;
case 4:
System.out.print("Enter new Alternate Email: ");
this.alternateemail = input.nextLine();
break;
case 0:
print = true;
break;
}
}
if(choose == 0 || choose == 1|| choose == 2|| choose == 3 ||choose == 4 || choose ==5 ){
System.out.println("Name: " + this.firstname + " "  + this.lastname + "\nDepartment: " + this.department +  "\nEmail: " + this.emailaddress + "\nAlternate Email: " + this.alternateemail + "\nPassword: "
 + this.password); 
}
} 
}
}
