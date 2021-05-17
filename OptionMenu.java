import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.IOException;

public class OptionMenu{

AccountHolder account = new AccountHolder();
Scanner In = new Scanner(System.in);
DecimalFormat balanceFormat = new DecimalFormat("'$'###,##0.00");


HashMap<Integer,Integer> info = new HashMap<Integer,Integer>();

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
System.out.println("\n"+"Invalid Character(s). only numbers." + "\n");
close = true;
}for(Entry<Integer,Integer>entry: info.entrySet()){
if(entry.getKey() == account.getAccountNumber() && entry.getValue() == account.getPin()){
retrieveAccountInfo();
}
}


}while(!close);

}

public void retrieveAccountInfo(){
System.out.print("1.Access Checkings \n2.Access Savings \n3.Exit Account \nEnter Choice:");


int choice = In.nextInt();
switch(choice){
case 1:
accessCheckings();
break;
//case 2:
//accessSavings();
//break;
case 3:
System.out.println("Thank you have a nice day");
break;
}


}


public void accessCheckings(){
System.out.print("1.Deposit  \n2.Withdraw \n3.Show Current Balance \n4.Exit Account \nEnter choice:");

int choice = In.nextInt();
double balance = 0;


switch(choice){

case 1:
System.out.print("Enter Deposit Amount: ");
double amount = In.nextDouble();
balance = account.depositChecking(amount);
System.out.println("Checkings Balance: " + balanceFormat.format(balance));
break;

case 2:
if(balance > 0){
System.out.print("Enter Withdrawl Amount: ");
amount = In.nextDouble();
balance = account.withdrawChecking(amount);
System.out.println("Checking Balance: " + balanceFormat.format(balance));
} else System.out.println("You Do not  have enough funds");
break;

case 3:
System.out.println("Thank You have a nice day");

}

}










public static void main(String[]args) throws IOException{

OptionMenu menu = new OptionMenu();

menu.login();


}

}


