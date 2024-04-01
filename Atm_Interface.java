import java.util.InputMismatchException;
import java.util.Scanner;

 class Atm_Interface{
 public static void main(String args[]){
    //intial deposite for minimum balance
  final Scanner scanner =new Scanner(System.in);
  
    User_Account user=new User_Account(500);
    System.out.println("WELCOME....");
    //continue the process with same user
    int continueProcess=0;
    do{
   
     if(user.defaultPassword()){
       System.out.println("New user Please Generate Password :");
       int password=scanner.nextInt();
       //generating new password
       user.generatingPassword(password);
        
     }
     System.out.println("enter the password");
     int passwordVerification=scanner.nextInt();
     if(user.passwordVerify(passwordVerification)){
        System.out.println("Successfull login..");
       Atm atm=new Atm(user);
       atm.process();
     }
     else System.out.println("Invalid password");
     System.out.println("Again relogin the process Please enter the '1' other wise any key");
     try{
     continueProcess =scanner.nextInt();
     }
     catch(InputMismatchException e){
       continueProcess=0;
     }
    }while(continueProcess==1);
    System.out.println("Thank you for visited");
    scanner.close();
 }
}

class Atm{
    User_Account user;
   private Scanner scanner;
   Atm(User_Account user){
     this.user=user;
     this.scanner=new Scanner(System.in);

   }
   void process(){
    while(true){
    System.out.println("select given options");
   
    System.out.println("1  DEPOSITE");
    System.out.println("2  WITHDRAW");
    System.out.println("3  BALANCE ENQUERY");
    System.out.println("4  GENERATE NEW PASSWORD");
    System.out.println("5  EXIT");
    int option=scanner.nextInt();
    
        switch(option){
                      // deposite method
            case 1: System.out.println("enter the amount");
                    double amountDeposite=scanner.nextDouble();
                    user.deposite(amountDeposite);
                     break;
                    // withdraw method
            case 2: System.out.println("enter the withdraw amount");
                    double amountWithDraw=scanner.nextDouble();
                    user.withdraw(amountWithDraw);
                     break;
                   //balance check method
            case 3: user.balanceCheck();
                     break;
                   //generate password
            case 4: System.out.println("enter the new password");
                   int newPassword=scanner.nextInt();
                    user.generatingPassword(newPassword);
                     break;
                     // return back atm Interface
            case 5: return;
            default :System.out.println("choose the given numbers");
        
        }
      }
     
    }
   
   }

 class InsuffientBalance extends RuntimeException{
    String message="";
  
    InsuffientBalance(){
     this.message="Oops..! insuffient Balance";
    
     printInsuffient();
    }
  String  printInsuffient(){
    return message;
  }
}

class User_Account {
private double balance;
// default password generate when user created Account
private int password =(int)((Math.random()*(9999-1000))+1000);
private int defaultPassword=password;
 User_Account( double balance){
    this.balance=balance;
    
 }
 boolean defaultPassword(){
    //Checking default password or not
    return password== defaultPassword;
 }
 public void generatingPassword(int password){
   this.password=password;
   System.out.println("Successfull..! new password created");
 }
 public boolean passwordVerify(int password){
    
    return this.password==password;
 }
 public void withdraw(double withdraw_Amount){
    if(balance >= withdraw_Amount){
        balance-=withdraw_Amount;
        System.out.println("debited Amount :"+withdraw_Amount);
        System.out.println("Your Balance :"+balance);
    }
    else{
       try{
        throw new InsuffientBalance();
       }
       catch(InsuffientBalance e){
         System.out.println(e.message);
       }
    }
   // return withdraw_Amount;
  }
  public void deposite(double amount){
    balance+=amount;
    System.out.println("Credited Amount :"+amount);
    System.out.println("Your Current Balance :"+balance);
  }
  public void balanceCheck(){
    System.out.println("Your Balance :"+balance);
   
  }
}