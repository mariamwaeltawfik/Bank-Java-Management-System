
package bank_management;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
/**
 *
 * @author NOTEBOOK
 */
public  class Account implements ControlAccount,Transaction {
    public long Account_Id;
    static long max_id=12500000;
    private double Balance;
    public  String Account_Type;
    public   Customer customer;
    public LocalDate Account_date;
    Visa visa;
  
Account(){
    
    
    
}
     Account(String Account_Type, double Balance,String name,String password,String phone,String adress,String Email,String NationalID ,int age){ // override constructors
         visa=new Visa(Account_Id,Balance,password);
        customer=new Customer(name,phone,adress,Email,NationalID,age);
        this.Account_Type=Account_Type;
        Account_date=LocalDate.now();
       Account_Id=Account_ID();
        
          set_Balance(Balance);
      
        
    }
    //----------------------------------
    
     static long Account_ID(){
        return ++max_id;
    }
    
    //----------------------------------

    /**
     *
     * @return
     */
    public double get_Balance(){
         return Balance;
     } 

    /**
     *
     * @param Balance
     */
    public  void set_Balance(double Balance){
          if(Balance>0){
        this.Balance =Balance;
        }
        else{
            System.out.println("Invalid Balance");
        }
     
     } 
      public long get_AccountId(){
         return Account_Id;
     } 
      public String DispAccountId_str(){
     String str =Long.toString(get_AccountId());
     String replacedString =null;
    
     for(int i=0;i<str.length();i++){
         if(i>str.length()-5 ){
             
         }
         else{
            
            replacedString = str.substring(0, str.length() - 4).replaceAll(".", "*") + str.substring(str.length() - 4);
         }
     }
        
        return replacedString;
     }
     public String get_AccountType(){
         return Account_Type;
     } 
      public void set_AccountType(String Account_Type ){
          
          if("normal".equals(Account_Type)||"saving".equals(Account_Type)||"loan".equals(Account_Type)||"checking".equals(Account_Type)){
             this.Account_Type =Account_Type;  
          }
          else{
               System.out.println("Invalid Account Type");
          }
     }    

    //----------------------------------
    @Override
    public String toString(){
        
        
        return "Account_Id: "+DispAccountId_str()+"\tCustomer ID: "+customer.get_Customer_ID()+"\tCustomer name: "+customer.get_name()+"\tNatinal ID: "+customer.get_NationalId()+"\tAge:  "+customer.get_age()+"\tAdress: "+customer.get_addres()+"\nBalance: "+get_Balance()+"\nEmail: "+customer.get_Email()+"\nDate of creation: "+Account_date;
    }            

 


 
    public  <T> void edit_account(int account_id,String the_edition,T  edit) {
       the_edition= the_edition.toLowerCase();
      
        int index = 0;
       
        for (Account account : Accounts) {
           index++;
        if (account.get_AccountId() == account_id) {
            if(Accounts.contains(Accounts.get(index-1))) {
         //  System.out.println("\n"+"success"+"\n");
            if("name".equals(the_edition)){
                // Cast the generic edit value to a String
                Accounts.get(index-1).customer.set_name((String) edit);
            }
           else if("age".equals(the_edition)){
                 Accounts.get( index-1).customer.set_age((int)edit);
           }
           else  if("balance".equals(the_edition)){
               Accounts.get(index-1).set_Balance((int)edit);
           }
            else  if("phone".equals(the_edition)){
               Accounts.get(index-1).customer.set_Phone((String)edit);
           }
            else  if("email".equals(the_edition)){
               Accounts.get(index-1).customer.set_email((String)edit);
           }
            else  if("nationalid".equals(the_edition)){
               Accounts.get(index-1).customer.set_NationalId((String)edit);
           }
           else  if("adress".equals(the_edition)){
               Accounts.get(index-1).customer.set_addres((String)edit);
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

    @Override
    public   void delete_account(int account_id) {
        int index = 0;
        
        for (Account account : Accounts) {
           index++;
        if (account.get_AccountId() == account_id) {
            // Print the account details
            Accounts.remove(index-1);
            return; // Exit after finding the account
        }
    
        }
    // If no account is found with the given account_id
    System.out.println("Account with ID " + account_id + " not found.");
        
     
    }


    public void craet_account(String type, double Balance, String name,String password, String phone, String adress, String Email, String NationalID, int age) {
        type=type.toLowerCase();
        Account acc=new Account(type,Balance,name,password,phone,adress,Email,NationalID,age);
         if(Email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")&& (phone.length()==11) && name != null && adress != null
             && age>=21&&type.equals("normal")){
            Accounts.add(acc);
        }
        else{
            System.out.println("Not valid creation");
        }
    }

     @Override
    public void display_account(int account_id) {
            for (Account account : Accounts) {
        if (account.get_AccountId() == account_id) {
            // Print the account details
            System.out.println(account.toString());
            return; // Exit after finding the account
        }
    }
    // If no account is found with the given account_id
    System.out.println("Account with ID " + account_id + " not found.");
    }
  


   public  void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File Created "+ file.getName()); 

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LogFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // Append mode
            writer.write(data);
            writer.close();
           // System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 @Override
    public void Deposit(long Acc_Id,double amount){
        LocalDateTime now = LocalDateTime.now();

        // Format the time and date using a custom pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        this.Balance += amount;
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
        this.Balance -= amount;
            LogFile("logfile","Acc id: " );
            LogFile("logfile",Long.toString(Acc_Id) );
            LogFile("logfile","     Withdrawal: " );
            LogFile("logfile",Long.toString((long)amount));
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
    