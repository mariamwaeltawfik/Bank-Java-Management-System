/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_management;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author NOTEBOOK
 */


public class A_LoanAccount extends Account {

   static long Principal_Amount;
   static long Loan_Duration;  //monthes
   static double Interest_rate=0.1;
   static double loan_total;
   static char flag=0;
   A_LoanAccount(String type,long Principal_Amount,long Loan_Duration,double Balance,String name,String password,String phone,String adress,String Email,String NationalID ,int age){
       super(type,Balance,name,password,phone,adress, Email, NationalID , age);
       if(Loan_Duration>0&&Principal_Amount>0){
           this.Loan_Duration=Loan_Duration;
       this.Principal_Amount=Principal_Amount; 
       }
      
   }
   // 0 or 1
   
public void set_flag(char flag){
    
    this.flag=flag;
}
public char get_flag(){
    
    return flag;
}
    A_LoanAccount() {
    }
   
      public double get_Loan(){
        
        loan_total= (Principal_Amount*Interest_rate*(Loan_Duration/12))+Principal_Amount;   
        
        

        return  loan_total;
    }
      public int get_LoanDuration(){
 

        return  (int) Loan_Duration;
    }
   
    public double PayInstallment(int Account_id,long paid_amount){
       if(get_Balance()>= paid_amount){
         if(Loan_Duration>0){
        
        loan_total-=paid_amount;    
        set_Balance(get_Balance()-paid_amount);
        --Loan_Duration;
       
        System.out.println("The loan left "+loan_total+ "\tfor:  "+Loan_Accounts.get(Account_id).customer.get_name());
     
        }
         else{
             System.out.println("THE LOAN IS PAID");
            Loan_Accounts.remove(Account_id);
         }  
       }
       else{
           System.out.println("Your balance is not enough");
       }
         
        

        return loan_total;
        
    }
    public  void warning_OfPayment(long Account_id, int loan_duration){
       Timer time =new Timer();        
       TimerTask task= new Timer_help();
     
       time.schedule(task, 10000,400000);

       
        
    }
     @Override
    public String toString(){
        return "Account_Id: "+DispAccountId_str()+"\tBalance: "+get_Balance()+"\tCustomer ID: "+customer.get_Customer_ID()+"\tCustomer name: "+customer.get_name()+"\tNatinal ID: "+customer.get_NationalId()+"\tAge:   "+customer.get_age()+"\tEmail:"+customer.get_Email()+"\nLoan amount: "+get_Loan()+"\nMonthes left: "+Loan_Duration+"\nDate of creation: "+Account_date;
    } 
    
    @Override
    public <T> void edit_account(int account_id, String the_edition,T edit) {
       the_edition= the_edition.toLowerCase();
               int index = 0;
               
        for (A_LoanAccount account : Loan_Accounts) {
           index++;
        if (account.get_AccountId() == account_id) {
            if(Loan_Accounts.contains(Loan_Accounts.get(index-1))) {
     //      System.out.println("\n"+"success"+"\n");
           if("name".equals(the_edition)){
               Loan_Accounts.get(index-1).customer.set_name((String)edit);
           }
           else if("age".equals(the_edition)){
                 Loan_Accounts.get(index-1).customer.set_age((int)edit);
           }
           else  if("balance".equals(the_edition)){
               Loan_Accounts.get(index-1).set_Balance((int)edit);
           }
            else  if("phone".equals(the_edition)){
               Loan_Accounts.get(index-1).customer.set_Phone((String)edit);
           }
            else  if("email".equals(the_edition)){
               Loan_Accounts.get(index-1).customer.set_email((String)edit);
           }
            else  if("nationalid".equals(the_edition)){
               Loan_Accounts.get(index-1).customer.set_NationalId((String)edit);
           }
           else  if("adress".equals(the_edition)){
               Loan_Accounts.get(index-1).customer.set_addres((String)edit);
           }
           else{
            System.out.println("The edition not exist");   
           }
       }
      
            break;
        }
        else{
            System.out.println("Account with ID "+account_id+ " not found.");   
        }
        }
               
             
      
          
    }   

   
    public void craet_account(String type, double Balance, long Principal_Amount,int Loan_Duration,String name,String password, String phone, String adress, String Email, String NationalID, int age) {
        type=type.toLowerCase();
        A_LoanAccount acc=new A_LoanAccount(type,Principal_Amount,Loan_Duration,Balance,name,password,phone,adress,Email,NationalID,age);
        if(Loan_Duration>=6&&Principal_Amount>=20000){
             if(age>=21&&type.equals("loan")){
            Loan_Accounts.add(acc);
            acc.warning_OfPayment(Account_Id,Loan_Duration);
          
        }
        else{
            System.out.println("Not valid creation");
        }
    }
        }
       
@Override
   public void delete_account(int account_id) {
        int index = 0;
        
        for (A_LoanAccount account : Loan_Accounts) {
           index++;
        if (account.get_AccountId() == account_id) {
            // Print the account details
            Saving_Accounts.remove(index-1);
            return; // Exit after finding the account
        }
    }
       
    // If no account is found with the given account_id
    System.out.println("Account with ID " + account_id + " not found.");
    }
 
    @Override
    public void display_account(int account_id) {
        
         for (A_LoanAccount account : Loan_Accounts) {
        if (account.get_AccountId() == account_id) {
            // Print the account details
            System.out.println(account.toString());
            return; // Exit after finding the account
        }
    }
        
    // If no account is found with the given account_id
    System.out.println("Account with ID " + account_id + " not found.");
    }

 @Override
    public void Deposit(long Acc_Id,double amount){
        LocalDateTime now = LocalDateTime.now();

        // Format the time and date using a custom pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
       set_Balance(get_Balance()+amount);
        LogFile("logfile","Acc id: " );
       LogFile("logfile",Long.toString(Acc_Id) );
            LogFile("logfile","     deposite: " );
            LogFile("logfile",Long.toString((long)amount));
            LogFile("logfile","     Date of Deposit: " );
            LogFile("logfile",formattedDateTime);
            LogFile("logfile","\n" );
        System.out.println("Successful Deposit process with amount " + amount +" EGP\n"+
                "your current balance is: " + get_Balance() +" EGP");
    }
    
    @Override
    public void Withdrawal(long Acc_Id,double amount){
        if(get_Balance() >= amount)
        {
             LocalDateTime now = LocalDateTime.now();

        // Format the time and date using a custom pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
            set_Balance(get_Balance()-amount);
       LogFile("logfile","Acc id: " );
            LogFile("logfile",Long.toString(Acc_Id) );
            LogFile("logfile","     Withdrawal: " );
            LogFile("logfile",Long.toString((long) amount));
            LogFile("logfile","     Date of Withdrawal: " );
            LogFile("logfile",formattedDateTime);
            LogFile("logfile","\n" );
            System.out.println("Successful Withdrawal process with amount" + amount +" EGP\n"+
                "your current balance is: " + get_Balance()+ "EGP");
        }
        else
          System.out.println("your balance is not enough\n" + "your current balance is: " + get_Balance()+ " EGP");  
    }

 
   
}
