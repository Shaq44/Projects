import java.text.DecimalFormat;

/*This class holds the data for the account user*/

public class AccountHolder{

int Account_number;
int Customer_pin;
double Customer_Balance_Checking = 0;
double Customer_Balance_Saving = 0;
DecimalFormat df = new DecimalFormat("'$'###,##0.00");


/*This Method sets the account number*/
public void setAccountNumber(int Account){
this.Account_number = Account;
}

/*This Mehtod retrieves the Account Number*/
public int getAccountNumber(){
return this.Account_number;
}

/*This Method Set the customer pin*/
public void setPin(int pin){
this.Customer_pin = pin;
}

/*This Method retrieves the Customer pin*/
public int getPin(){
return this.Customer_pin;
}

/*This Method retrives the chekcing balance */
public double getCheckings(){
System.out.println("Checkings Balance: " +  df.format(Customer_Balance_Checking ));
return Customer_Balance_Checking;
}

/*This Method retireves the savings balance*/
public double getSavings(){
System.out.println("Savings Balance: " +  df.format(Customer_Balance_Saving ));
return Customer_Balance_Saving;
}

/*This Method takes a deposited  amount entered,Calcualtes the amount , and returns the current balance*/
public double  depositChecking(double deposit){
Customer_Balance_Checking = Customer_Balance_Checking + deposit;
System.out.println("Chekcing Balance: " + df.format( Customer_Balance_Checking));
return Customer_Balance_Checking;
}

/*This method checks if there is a posotive balance in the account.
 The amount entered is calculated and the current balance is returned.*/

public double withdrawChecking(double withdraw){
if(Customer_Balance_Checking <= 0){
System.out.println("Insufficient Funds");
}else
Customer_Balance_Checking  = Customer_Balance_Checking - withdraw;
System.out.println("Chekcing Balance: " + df.format(Customer_Balance_Checking));
return Customer_Balance_Checking;
}


/*This Method takes a deposited  amount entered,Calcualtes the amount , and returns the current balance*/
public double depositSaving(double deposit){
Customer_Balance_Saving = Customer_Balance_Saving + deposit;
System.out.println("Saving Balance: " + df.format(Customer_Balance_Saving));
return Customer_Balance_Saving;
}

/*This method checks if there is a posotive balance in the account.
 The amount entered is calculated and the current balance is returned.*/

public double withdrawSaving(double withdraw){
if(Customer_Balance_Saving <= 0){
System.out.println("Insufficient Funds");
} else
Customer_Balance_Saving = Customer_Balance_Saving - withdraw;
System.out.println("Saving Balance: " + df.format(Customer_Balance_Saving));
return Customer_Balance_Saving;
}


}