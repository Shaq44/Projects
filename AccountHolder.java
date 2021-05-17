public class AccountHolder{

int Account_number;
int Customer_pin;
double Customer_Balance_Checking = 0;
double Customer_Balance_Saving = 0;



public void setAccountNumber(int Account){
this.Account_number = Account;
}

public int getAccountNumber(){
return this.Account_number;
}

public void setPin(int pin){
this.Customer_pin = pin;
}

public int getPin(){
return this.Customer_pin;
}

public double  depositChecking(double deposit){
Customer_Balance_Checking = Customer_Balance_Checking + deposit;
return Customer_Balance_Checking;
}

public double withdrawChecking(double withdraw){
Customer_Balance_Checking  = Customer_Balance_Checking - withdraw;
return Customer_Balance_Checking ;
}

public double depositSaving(double deposit){
Customer_Balance_Saving = Customer_Balance_Saving + deposit;
return Customer_Balance_Saving;
}

public double withdrawSaving(double withdraw){
Customer_Balance_Saving = Customer_Balance_Saving - withdraw;
return Customer_Balance_Saving;
}


}







