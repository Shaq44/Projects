
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.IOException;


/*this class presents the option menu for the atm user*/
public class OptionMenu{

AccountHolder account = new AccountHolder();
Scanner In = new Scanner(System.in);


HashMap<Integer,Integer> info = new HashMap<Integer,Integer>();

/*this method checks the login info from the account user and if th info
is correct then the user can acces their information*/
public void login() throws IOException{
boolean close = false;

do{

try{
info.put(4456332,7866);
info.put(2234113,3354);
System.out.println("Welcome to Liberation Bank");
System.out.print("Enter Account Number: ");
account.setAccountNumber(In.nextInt());
System.out.print("Enter Pin: ");
account.setPin(In.nextInt());
}catch(Exception e){
System.out.println("The pin or Account number entered is incorrect");
close = true;
}
for(Entry<Integer,Integer>entry: info.entrySet()){
if(entry.getKey() == account.getAccountNumber() && entry.getValue() == account.getPin()){
retrieveAccountInfo();
}
}




}while(!close);

}


/*This Method allows the user to choose the account they want*/
public void retrieveAccountInfo(){
System.out.print("1.Access Checkings \n2.Access Savings \n3.Exit Account \nEnter Choice:");


int choice = In.nextInt();
switch(choice){

case 1:
accessCheckings();
break;

case 2:
accessSavings();
break;

case 3:
System.out.println("Thank you have a nice day");
break;
}


}


/*this method shows the checking info and gives the option of withdrawing or depostiting*/
public void accessCheckings(){
System.out.print("1.Deposit  \n2.Withdraw \n3.Show Current Balance \n4.Exit Account \nEnter choice:");

int choice = In.nextInt();
double balance = 0;
double amount;

switch(choice){

case 1:
System.out.print("Enter Deposit Amount: ");
amount = In.nextDouble();
account.depositChecking(amount);
retrieveAccountInfo();
break;

case 2:
System.out.print("Enter Withdrawl Amount: ");
amount = In.nextDouble();
account.withdrawChecking(amount);
retrieveAccountInfo();
break;

case 3:
account.getCheckings();
retrieveAccountInfo();
break;

case 4:
System.out.println("Thank You have a nice day");
break;
}

}


/*this method shows the savings info and gives the option of withdrawing or depostiting*/
public void accessSavings(){
System.out.print("1.Deposit  \n2.Withdraw \n3.Show Current Balance \n4.Exit Account \nEnter choice:");

int choice = In.nextInt();

double amount; 


switch(choice){
case 1:
System.out.print("Enter Deposit Amount: ");
amount = In.nextDouble();
account.depositSaving(amount);
retrieveAccountInfo();
break;

case 2:
System.out.print("Enter Withdraw Amount: ");
amount = In.nextDouble();
account.withdrawSaving(amount);
retrieveAccountInfo();
break;

case 3:
account.getSavings();
retrieveAccountInfo();
break;

case 4:
System.out.println("Thank you have a nice day");
break;

}





}

}