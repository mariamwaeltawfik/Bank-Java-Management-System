/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_management;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author NOTEBOOK
 */
public final class A_CheckingAccount extends Account  {

    static int utilization_ratio=5;
   static double credit_limit;
    A_CheckingAccount(){
        
    }
   A_CheckingAccount(String type,double Balance,String name,String password,String phone,String adress,String Email,String NationalID ,int age){
       super(type,Balance,name,password,phone,adress, Email, NationalID , age); 
       credit_limit= get_craditLimit();
   }
   
   public double get_craditLimit(){
       credit_limit= (get_Balance()/utilization_ratio);
       return credit_limit;
   }
   
   @Override
    public String toString(){
        return "Account_Id: "+DispAccountId_str()+"\tCustomer ID: "+customer.get_Customer_ID()+"\tCustomer name: "+customer.get_name()+"\tNatinal ID: "+customer.get_NationalId()+"\tAge:   "+customer.get_age()+"\tEmail:"+customer.get_Email()+"\ncredit limit: "+get_craditLimit()+"\nBalance: "+get_Balance()+"\nDate of creation: "+Account_date;
    }            
    
   @Override
    public <T> void edit_account(int account_id, String the_edition,T edit) {
       the_edition= the_edition.toLowerCase();
        int index = 0;
        
        for (A_CheckingAccount account : Checking_Accounts) {
           index++;
        if (account.get_AccountId() == account_id) {
            if(Checking_Accounts.contains(Checking_Accounts.get(index-1))) {
         //  System.out.println("\n"+"success"+"\n");
           if("name".equals(the_edition)){
               Checking_Accounts.get( index-1).customer.set_name((String)edit);
           }
           else if("age".equals(the_edition)){
                 Checking_Accounts.get(index-1).customer.set_age((int)edit);
           }
           else  if("balance".equals(the_edition)){
               Checking_Accounts.get(index-1).set_Balance((int)edit);
           }
            else  if("phone".equals(the_edition)){
               Checking_Accounts.get(index-1).customer.set_Phone((String)edit);
           }
            else  if("email".equals(the_edition)){
               Checking_Accounts.get(index-1).customer.set_email((String)edit);
           }
            else  if("nationalid".equals(the_edition)){
               Checking_Accounts.get(index-1).customer.set_NationalId((String)edit);
           }
           else  if("adress".equals(the_edition)){
               Checking_Accounts.get(index-1).customer.set_addres((String)edit);
           }
           else{
                 System.out.println("The edition not exist");   
           }
       }
      
            break;
        }
        else{
               System.out.println("Account Id  "+account_id+" Not exist");
        }
        }
        
      
        
    }


   
   
    public void craet_account(String type, long Balance, String name,String password, String phone, String adress, String Email, String NationalID, int age) {
        type=type.toLowerCase();
        A_CheckingAccount acc=new A_CheckingAccount(type,Balance,name,password,phone,adress,Email,NationalID,age);
        if(age>=21&&type.equals("checking")){
            Checking_Accounts.add(acc);
        }
        else{
            System.out.println("Not valid creation");
        }
    }
@Override
   public void delete_account(int account_id) {
        int index = 0;
        for (A_CheckingAccount account : Checking_Accounts) {
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
         for (A_CheckingAccount account : Checking_Accounts) {
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
            LogFile("logfile","     Date of Deposite: " );
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
