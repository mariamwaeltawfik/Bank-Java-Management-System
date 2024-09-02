/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank_management;

import static bank_management.A_LoanAccount.Loan_Duration;
import static bank_management.ControlAccount.Accounts;
import static bank_management.ControlAccount.Admins;
import static bank_management.ControlAccount.Checking_Accounts;
import static bank_management.ControlAccount.Loan_Accounts;
import static bank_management.ControlAccount.Managers;
import static bank_management.ControlAccount.Saving_Accounts;
import static bank_management.ControlAccount.allAccounts;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Properties;
/**
 *
 * @author NOTEBOOK
 */
 //
public class Bank_Management   {

    /**
     * @param args the command line arguments
     */
   static  LogFile file;
     static Manager manager =new Manager();
     static boolean validInput = false;
     static Admin admin =new Admin();
     static Employee employee=new Employee();
     static  Account noraml=new Account();
     static  A_LoanAccount Loan=new A_LoanAccount();
     static   A_SavingAccount saving=new A_SavingAccount();
     static   A_CheckingAccount checking=new A_CheckingAccount();
    
public static void display_All(){
           for(int i=0;i<Accounts.size();i++){
               System.out.println("|"+"Account Id: "+"|"+Accounts.get(i).DispAccountId_str()+" | "+"Name: "+"|"+Accounts.get(i).customer.get_name()+"  "+"| "+"Account Type: "+Accounts.get(i).get_AccountType());
           }
            for(int i=0;i<Saving_Accounts.size();i++){
               System.out.println("|"+"Account Id: "+"|"+Saving_Accounts.get(i).DispAccountId_str()+" | "+"Name: "+"|"+Saving_Accounts.get(i).customer.get_name()+"  "+"| "+"Account Type: "+Saving_Accounts.get(i).get_AccountType());
           }
             for(int i=0;i<Checking_Accounts.size();i++){
               System.out.println("|"+"Account Id: "+"|"+Checking_Accounts.get(i).DispAccountId_str()+" | "+"Name: "+"|"+Checking_Accounts.get(i).customer.get_name()+"  "+"| "+"Account Type: "+Checking_Accounts.get(i).get_AccountType());
           }
              for(int i=0;i<Loan_Accounts.size();i++){
               System.out.println("|"+"Account Id: "+"|"+Loan_Accounts.get(i).DispAccountId_str()+" | "+"Name: "+"|"+Loan_Accounts.get(i).customer.get_name()+"  "+"| "+"Account Type: "+Loan_Accounts.get(i).get_AccountType());
           }
}
public static void managerMode(){

       Scanner scanner_ = new Scanner(System.in);
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        // Admin login
        System.out.print("Enter Manager username: ");
        String managerUsername = scanner_.nextLine();
        System.out.print("Enter Manager password: ");
        String managerPassword = scanner_.nextLine();
        int choice = 0;
        if (manager.managerExists(managerUsername, managerPassword)){
            // Admin menu
            
            while (choice!=2) {
                System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
                System.out.println("Manager Menu:");
                System.out.println("1. Create Admin");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
        validInput = false;
        while (!validInput) {
        try {
        choice = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
                        System.out.println("1. Create Admin");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
}
 String adminUsername;
                switch (choice) {
                    case 1:
                        // Create Admin
                        System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
                        System.out.print("Enter Admin username: ");
                        adminUsername = scanner_.nextLine();
                        adminUsername= scanner_.nextLine();
                        System.out.print("Enter admin password: ");
                        String adminPassword = scanner_.nextLine();
                       
               admin.Creat_Admin(adminUsername, adminPassword);
             
               System.out.println(Admins);
                      System.out.println("Admin created successfully.");
                        break;

                    case 2:
                        System.out.println("Exiting Manger mode.");
                       // System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } 
    
 else  {
            System.out.println("Invalid Mnager credentials.");
        }
        
}
public static void adminMode(){
   
        Scanner scanner_ = new Scanner(System.in);
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        // Admin login
        System.out.print("Enter admin username: ");
        String adminUsername = scanner_.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner_.nextLine();
        int choice = 0;
        if (admin.adminExists(adminUsername, adminPassword)){
            // Admin menu
            
            while (choice!=2) {
                System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
                System.out.println("Admin Menu:");
                System.out.println("1. Create employee");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
        validInput = false;
        while (!validInput) {
        try {
        choice = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
                        System.out.println("1. Create employee");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
}
 String employeeUsername;
                switch (choice) {
                    case 1:
                        // Create employee
                        System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
                        System.out.print("Enter employee username: ");
                        employeeUsername = scanner_.nextLine();
                        employeeUsername= scanner_.nextLine();
                        System.out.print("Enter employee password: ");
                        String employeePassword = scanner_.nextLine();
                        System.out.print("Enter employee phone: ");
                        String employeePhone = scanner_.nextLine();
                        System.out.print("Enter employee email: ");
                        String employeeEmail = scanner_.nextLine();
                        System.out.print("Enter employee department: ");
                        String employeeDepartment = scanner_.nextLine();
                        System.out.print("Enter employee salary: ");
                       double employeesalary = scanner_.nextDouble();
                       
               employee.Creat_Employee(employeeUsername , employeePhone, employeeEmail, employeePassword, employeeDepartment, employeesalary);
             
               System.out.println(allAccounts);
                      System.out.println("Employee created successfully.");
                        break;

                    case 2:
                        System.out.println("Exiting admin mode.");
                       // System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } 
    
 else  {
            System.out.println("Invalid admin credentials.");
        }
        
    }
  public static void employeeMode(){
                        String customerUsername;
                        int customerAge;
                        String customerPhone ;
                        String customerAdress; 
                        String customerEmail ;
                        double customerBalance ;
                        String customerNationalId ;
                        String customerPassword ;
                        int accountTime;
                        long princibleAmount;
                        int LoanDuration;
                           String edition;
        int acc_id;
        int edit = 0;
        String editt = null;
       
       Scanner scanner_ = new Scanner(System.in);
        System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
          System.out.print("Enter employee username: ");
String employeeUsername = scanner_.nextLine();
System.out.print("Enter employee password: ");
String employeePassword = scanner_.nextLine();
int choice=0;
// Verify employee credentials (e.g., against a database)
if (employee.employeeExists(employeeUsername, employeePassword)) {
    // Employee menu
    while (choice!=6) {
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        System.out.println("Employee Menu:");
        System.out.println("1. Create account");
        System.out.println("2. Edit account");
        System.out.println("3. Remove account");
        System.out.println("4. Display account");
        System.out.println("5. Display All accounts");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        validInput = false;
        while (!validInput) {
        try {
        choice = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        System.out.println("1. Create account");
        System.out.println("2. Edit account");
        System.out.println("3. Remove account");
        System.out.println("4. Display account");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
switch(choice){
    case 1:
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Create normal account");
         System.out.println("2. Create saving account");
         System.out.println("3. Create loan account");
         System.out.println("4. Create checking account");
         System.out.print("Enter your choice: ");
        int choise2 = 0;
        validInput = false;
        while (!validInput) {
        try {
        choise2 = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Create normal account");
         System.out.println("2. Create saving account");
         System.out.println("3. Create loan account");
         System.out.println("4. Create checking account");
         System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
         switch(choise2){
             case 1:
                  System.out.println();
                  System.out.println("-------------------------------------------------------------------------");
                  System.out.println();
                        System.out.print("Enter customer username: ");
                        customerUsername = scanner_.nextLine();
                        customerUsername= scanner_.nextLine();
                        System.out.print("Enter customer age: ");
                         customerAge= scanner_.nextInt();
                        System.out.print("Enter customer phone: ");
                         customerPhone = scanner_.nextLine();
                         customerPhone = scanner_.nextLine();
                        System.out.print("Enter customer adress: ");
                         customerAdress = scanner_.nextLine(); 
                        System.out.print("Enter customer email: ");
                         customerEmail = scanner_.nextLine();
                        System.out.print("Enter customer balance: ");
                         customerBalance = scanner_.nextDouble();
                        System.out.print("Enter customer nationalId: ");
                         customerNationalId = scanner_.nextLine();
                          customerNationalId = scanner_.nextLine();
                        System.out.print("Enter customer password: ");
                         customerPassword = scanner_.nextLine();
                     noraml.craet_account("normal", customerBalance, customerUsername, customerPassword,customerPhone , customerAdress,customerEmail, customerNationalId, customerAge);
                     System.out.println(Accounts);
                     break;
             case 2:
                  System.out.println();
                  System.out.println("-------------------------------------------------------------------------");
                  System.out.println();
                       System.out.print("Enter customer username: ");
                        customerUsername = scanner_.nextLine();
                        customerUsername= scanner_.nextLine();
                        System.out.print("Enter customer age: ");
                         customerAge= scanner_.nextInt();
                         System.out.print("Enter Account time: ");
                         accountTime= scanner_.nextInt();
                        System.out.print("Enter customer phone: ");
                        customerPhone = scanner_.nextLine();
                        customerPhone = scanner_.nextLine();
                        System.out.print("Enter customer adress: ");
                         customerAdress = scanner_.nextLine(); 
                        System.out.print("Enter customer email: ");
                         customerEmail = scanner_.nextLine();
                        System.out.print("Enter customer balance: ");
                        customerBalance = scanner_.nextDouble();
                        System.out.print("Enter cusomer nationalId: ");
                         customerNationalId = scanner_.nextLine();
                         customerNationalId = scanner_.nextLine();
                        System.out.print("Enter customer password: ");
                        customerPassword = scanner_.nextLine();
                       saving.craet_account("saving", customerBalance, accountTime,customerUsername,  customerPassword,customerPhone, customerAdress, customerEmail, customerNationalId, customerAge);
                                           System.out.println(Saving_Accounts);

                       break;
             case 3:
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println();
                        System.out.print("Enter customer username: ");
                        customerUsername = scanner_.nextLine();
                        customerUsername= scanner_.nextLine();
                        System.out.print("Enter customer age: ");
                         customerAge= scanner_.nextInt();
                         System.out.print("Enter Princible Amount: ");
                          princibleAmount= scanner_.nextLong();
                        System.out.print("Enter Loan duration: ");
                         LoanDuration= scanner_.nextInt();
                        System.out.print("Enter customer phone: ");
                        customerPhone = scanner_.nextLine();
                        customerPhone = scanner_.nextLine();
                        System.out.print("Enter customer adress: ");
                         customerAdress = scanner_.nextLine(); 
                        System.out.print("Enter customer email: ");
                         customerEmail = scanner_.nextLine();
                        System.out.print("Enter customer balance: ");
                        customerBalance = scanner_.nextDouble();
                        System.out.print("Enter customer nationalId: ");
                         customerNationalId = scanner_.nextLine();
                         customerNationalId = scanner_.nextLine();
                        System.out.print("Enter customer password: ");
                        customerPassword = scanner_.nextLine();
                         Loan.craet_account("loan", customerBalance, princibleAmount, LoanDuration, customerUsername , employeePassword,customerPhone,customerAdress,customerEmail,   customerNationalId, customerAge);
                              System.out.println(Loan_Accounts);

                         break;
             case 4:
                         System.out.println();
                         System.out.println("-------------------------------------------------------------------------");
                         System.out.println();
                         System.out.print("Enter customer username: ");
                        customerUsername = scanner_.nextLine();
                        customerUsername= scanner_.nextLine();
                        System.out.print("Enter customer age: ");
                         customerAge= scanner_.nextInt();
                        System.out.print("Enter customer phone: ");
                        customerPhone = scanner_.nextLine();
                        System.out.print("Enter customer adress: ");
                         customerAdress = scanner_.nextLine(); 
                        System.out.print("Enter customer email: ");
                         customerEmail = scanner_.nextLine();
                        System.out.print("Enter customer balance: ");
                        customerBalance = scanner_.nextDouble();
                        System.out.print("Enter customer nationalId: ");
                         customerNationalId = scanner_.nextLine();
                              customerNationalId = scanner_.nextLine();
                        System.out.print("Enter customer password: ");
                        customerPassword = scanner_.nextLine();
                        checking.craet_account("checking", customerBalance, customerUsername, employeePassword, customerPhone, customerAdress, customerEmail, customerNationalId, customerAge);
                             System.out.println(Checking_Accounts);

                        break;
                        
         }
         break;
    case 2:
      
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1.  Edit normal account");
         System.out.println("2. Edit saving account");
         System.out.println("3. Edit loan account");
         System.out.println("4. Edit checking account");
         System.out.print("Enter your choice: ");
       
         int choise3 = 0;
        validInput = false;
        while (!validInput) {
        try {
        choise3 = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Edit normal account");
         System.out.println("2. Edit saving account");
         System.out.println("3. Edit loan account");
         System.out.println("4. Edit checking account");
         System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
         switch(choise3){
               case 1:
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println();
               System.out.println("Enter your edition: "); 
               edition=scanner_.nextLine();
               edition=scanner_.nextLine();
               System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();
             
               if(edition.equals("age")||edition.equals("balance")){
                    
                   System.out.println("Enter your edit: "); 
                    edit=scanner_.nextInt();
                   noraml.edit_account(acc_id, edition, edit);
               }
               else{
                 System.out.println("Enter your edit: "); 
                      editt=scanner_.nextLine();
                      editt=scanner_.nextLine();
                   noraml.edit_account(acc_id, edition, editt);
               }
               
        
        break;
        
               case 2:
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println();
                System.out.println("Enter your edition: "); 
               edition=scanner_.nextLine();
                 edition=scanner_.nextLine();
               System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();
                
               if(edition.equals("age")||edition.equals("balance")){
                    
                   System.out.println("Enter your edit: "); 
                    edit=scanner_.nextInt();
                   saving.edit_account(acc_id, edition, edit);
               }
               else{
                 System.out.println("Enter your edit: "); 
                      editt=scanner_.nextLine();
                      editt=scanner_.nextLine();
                   saving.edit_account(acc_id, edition, editt);
               }
                   
                   break;
                   
               case 3:
                    System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
               System.out.println("Enter your edition: "); 
               edition=scanner_.nextLine();
                 edition=scanner_.nextLine();
               System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();
               
               if(edition.equals("age")||edition.equals("balance")){
                    
                   System.out.println("Enter your edit: "); 
                    edit=scanner_.nextInt();
                   Loan.edit_account(acc_id, edition, edit);
               }
               else{
                 System.out.println("Enter your edit: "); 
                      editt=scanner_.nextLine();
                      editt=scanner_.nextLine();
                  Loan.edit_account(acc_id, edition, editt);
               }
                   
                   break;
                   
               case 4:
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println();
               System.out.println("Enter your edition: "); 
               edition=scanner_.nextLine();
                 edition=scanner_.nextLine();
               System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();
             
                if(edition.equals("age")||edition.equals("balance")){
                    
                   System.out.println("Enter your edit: "); 
                    edit=scanner_.nextInt();
                    
                  checking.edit_account(acc_id, edition, edit);
               }
               else{
                 System.out.println("Enter your edit: "); 
                      editt=scanner_.nextLine();
                      editt=scanner_.nextLine();
                   checking.edit_account(acc_id, edition, editt);
               }
                   
                   break;
         }
         break;


    case 3:
      System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Remove normal account");
         System.out.println("2. Remove saving account");
         System.out.println("3. Remove loan account");
         System.out.println("4. Remove checking account");
         System.out.print("Enter your choice: ");
                  int choise4 = 0;
        validInput = false;
        while (!validInput) {
        try {
        choise4 = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Remove normal account");
         System.out.println("2. Remove saving account");
         System.out.println("3. Remove loan account");
         System.out.println("4. Remove checking account");
         System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
         switch(choise4){
               case 1:
               System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();     
               noraml.delete_account(acc_id);
        break;
        
               case 2:
                  System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();     
               saving.delete_account(acc_id); 
                   
                   break;
                   
               case 3:
                   
                   System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();     
               Loan.delete_account(acc_id);
                   
                   break;
                   
               case 4:
                   
                   System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt();     
               checking.delete_account(acc_id);
                   break;
         }
        
  break;
    case 4:
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Diplay normal account");
         System.out.println("2. Diplay saving account");
         System.out.println("3. Diplay loan account");
         System.out.println("4. Diplay checking account");
         System.out.println("5. Diplay All");
         System.out.print("Enter your choice: ");
        int choise5 = 0;
        validInput = false;
        while (!validInput) {
        try {
        choise5 = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Diplay normal account");
         System.out.println("2. Diplay saving account");
         System.out.println("3. Diplay loan account");
         System.out.println("4. Diplay checking account");
         System.out.println("5. Diplay All");
         System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
        switch(choise5){
            case 1:
                 System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt(); 
                noraml.display_account(acc_id);
                break;
                case 2:
                 System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt(); 
                saving.display_account(acc_id);
                break;
                case 3:
                 System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt(); 
                Loan.display_account(acc_id);
                break;
                case 4:
                 System.out.println("Enter Account Id: "); 
               acc_id=scanner_.nextInt(); 
                checking.display_account(acc_id);
                break;
                case 5:
                    display_All();
            break;
        }
        break;
       case 5:   
           display_All();
           break;
}
        // Implement account creation, editing, and removal logic
    }
} else {
    System.out.println("Invalid employee credentials.");
}
        
    }
static public  String typee;
static int indx;
   public static   void customerMode(){
         Scanner scanner_ = new Scanner(System.in);
          System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.print("Enter User Name: ");
         String customerName = scanner_.nextLine();
         System.out.print("Enter  password: ");
String customerPassword = scanner_.nextLine();

// Verify customer credentials (e.g., against a database)
if (AccountExists(customerName, customerPassword)) {
    // Customer menu
    int choice=0;
    while (choice!=3) {
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        System.out.println("Customer Menu:");
        System.out.println("1. Check balance");
        System.out.println("2. Make transaction");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        validInput = false;
        while (!validInput) {
        try {
        choice = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        System.out.println("1. Check balance");
        System.out.println("2. Make transaction");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
switch(choice){
    case 1:
       switch(typee){
            case "normal":
                System.out.println("YOUR BALANCE: "+Accounts.get(indx).get_Balance()); 
               break;
               case "saving":
                System.out.println("YOUR BALANCE: "+Saving_Accounts.get(indx).get_Balance());                break;
               case "loan":
                    long pay=(long) Loan_Accounts.get(indx).get_Loan();
                    try{
                     pay=pay/Loan_Accounts.get(indx).get_LoanDuration();
                 }
                 catch(Exception e){
                       System.out.println("ArithmeticException");
                 }
                   if(Loan_Accounts.get(indx).get_flag()==1){
                       System.out.println(Loan_Accounts.get(indx).customer.get_name()+"\t You Should pay the installment ");
                       System.out.println("1. Pay installment");
                       System.out.println("2. Exit");
                       System.out.print("Enter your choice: ");
                   
                       int choise = scanner_.nextInt();
                     
                           switch(choise){
                            case 1:
                                Loan_Accounts.get(indx).set_flag((char)0);
                                Loan_Accounts.get(indx).PayInstallment(indx, (long) pay);
                                break;
                            case 2:
                               while (!validInput) {
        try {
        choice = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        System.out.println("1. Check balance");
        System.out.println("2. Make transaction");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
                                break;
                       
                        
                        }
                  
                   }
                System.out.println("YOUR BALANCE: "+Loan_Accounts.get(indx).get_Balance());                break;

               case "checking":
                System.out.println("YOUR BALANCE:  "+Checking_Accounts.get(indx).get_Balance()+"Cridit Limit: "+Checking_Accounts.get(indx).get_craditLimit());                break;
            
        } 
       break;
    case 2:
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
        System.out.println("1. Add Deposit");
        System.out.println("2. Make Withdrawal Transaction");
         System.out.print("Enter your choice: ");
           validInput = false;
        while (!validInput) {
        try {
        choice = scanner_.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
             System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
         System.out.println("1. Add Deposit");
        System.out.println("2. Make Withdrawal Transaction");
         System.out.print("Enter your choice: ");
        scanner_.next(); 
        }
        }
        switch(choice){
             case 1:
        System.out.print("Enter the deposit: ");
        double deposit= scanner_.nextDouble();
        switch(typee){
            case "normal":
                               Accounts.get(indx).Deposit(Accounts.get(indx).get_AccountId(),deposit);
              
               break;
               case "saving":
                               Saving_Accounts.get(indx).Deposit(  Saving_Accounts.get(indx).get_AccountId(),deposit);
             break;
               case "loan":
                               Loan_Accounts.get(indx).Deposit( Loan_Accounts.get(indx).get_AccountId(),deposit);
              break;
               case "checking":
                              Checking_Accounts.get(indx).Deposit( Checking_Accounts.get(indx).get_AccountId(),deposit);
              break;
            
        } 
        break;
        case 2:
       System.out.print("Enter the Withdrawal : ");
        double Withdrawal= scanner_.nextDouble();
        switch(typee){
               case "normal":
                           Accounts.get(indx).Withdrawal(Accounts.get(indx).get_AccountId(),Withdrawal); break;
               case "saving":
                           Saving_Accounts.get(indx).Withdrawal(Saving_Accounts.get(indx).get_AccountId(),Withdrawal);               break;
               case "loan":
                          Loan_Accounts.get(indx).Withdrawal(Loan_Accounts.get(indx).get_AccountId(),Withdrawal);             break;
               case "checking":
                          Checking_Accounts.get(indx).Withdrawal(Checking_Accounts.get(indx).get_AccountId(),Withdrawal);             break;
           
            
        } 
        break;
        
        }
        break;
   
        
}
      
    }
} else {
    System.out.println("Invalid customer credentials.");
}
        
    }

private static boolean AccountExists(String customerName, String customerPassword) {
       String type = null ;
       int index = 0;
       boolean ret = false;
      
        for (int i=0;i<Accounts.size();i++) {
          
        if (Accounts.get(i).customer.get_name().equals(customerName) ) {
            type="normal";
            index=i;
            break;
        }
        }
        for (int i=0;i<Loan_Accounts.size();i++) {
          
        if (Loan_Accounts.get(i).customer.get_name().equals(customerName)) {
             index=i;
            type="loan";
            break;
        }
        }
        for (int i=0;i<Saving_Accounts.size();i++) {
           
        if (Saving_Accounts.get(i).customer.get_name().equals(customerName)) {
            index=i;
            type="saving";
            break;
        }
        }
        for (int i=0;i<Checking_Accounts.size();i++) {
         
        if (Checking_Accounts.get(i).customer.get_name().equals(customerName)) {
            index=i;
            type="checking";
            break;
        }
        }
        System.out.println(type +"   " +index);
        indx=index;
        typee=type;
        switch(type){
            case "normal":
               ret = Accounts.get(index).visa.chekPasword(customerPassword);
               break;
               case "saving":
               ret = Saving_Accounts.get(index).visa.chekPasword(customerPassword);
               break;
               case "loan":
               ret = Loan_Accounts.get(index).visa.chekPasword(customerPassword);
               break;
               case "checking":
               ret = Checking_Accounts.get(index).visa.chekPasword(customerPassword);
               break;
            
        }
    return ret;
    }
    @SuppressWarnings("empty-statement")
   
   public static void main(String[] args) {
        // TODO code application logic here
          noraml.createFile("logfile");
          Managers.add(new Manager("ahmed","12345"));
          allAccounts.add(new Employee("mariam", "01023635193", "moraelshikh","12345", "sales", 15000));
          noraml.craet_account("normal",260000,"mola wael","12345","01023635193","minya","moraelshikh@gmail.com","3021240200663",25);
          Loan.craet_account("loan",250000,1000000, 24,"mariam wael","12345","01023635193","minya","moraelshikh@gmail.com","3021240200663",26);
          saving.craet_account("saving",300000,24,"karim","12345","01023635193","minya","moraelshikh@gmail.com","3021240200663",27);
          checking.craet_account("checking",40000,"weaam","12345","01023635193","minya","moraelshikh@gmail.com","3021240200663",28);
      
           System.out.println(Accounts);
           System.out.println(Checking_Accounts);
           System.out.println(Loan_Accounts);
           System.out.println(Saving_Accounts);
           Scanner scanner= new Scanner(System.in);



        // Main menu
        while (true) {
            System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
            System.out.println("Choose your mode:");
            System.out.println("1. Manager");
            System.out.println("2. Admin");
            System.out.println("3. Employee");
            System.out.println("4. Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = 0;
                    boolean validInput = false;
        while (!validInput) {
        try {
        choice = scanner.nextInt();
        validInput = true; 
        }
        catch (Exception e) {
        System.out.println("Try again. Please, enter an integer number:");
         System.out.println();
          System.out.println("-------------------------------------------------------------------------");
          System.out.println();
            System.out.println("1. Manager");
            System.out.println("2. Admin");
            System.out.println("3. Employee");
            System.out.println("4. Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
        scanner.next(); 
        }
        }
            switch (choice) {
                case 1:
                    // Call the admin mode function
                    managerMode();
                    break;
                case 2:
                    // Call the admin mode function
                    adminMode();
                    break;
                case 3:
                    // Call the employee mode function
                    employeeMode();
                    break;
                case 4:
                    // Call the customer mode function
                    customerMode();
                    break;
                case 5:
                    System.out.println("Exiting.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }

        }
    }

    
}