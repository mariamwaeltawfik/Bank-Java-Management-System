/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_management;

import static bank_management.A_LoanAccount.Loan_Duration;
import static bank_management.ControlAccount.Accounts;
import static bank_management.ControlAccount.Loan_Accounts;
import java.util.TimerTask;

/**
 *
 * @author NOTEBOOK
 */
public class Timer_help extends TimerTask {

    @Override
    public void run() {
        try{
        for(int i=0;i<Loan_Accounts.size();i++){
           
               if(Loan_Accounts.get(i).Account_Type=="loan"){
                 long pay=(long) Loan_Accounts.get(i).get_Loan();
                 try{
                     pay=pay/Loan_Accounts.get(i).get_LoanDuration();
                 }
                 catch(Exception e){
                       System.out.println("ArithmeticException");
                 }
     
                  
                 //   System.out.println("---------------------------------------------------------------------------------");
                 //  System.out.println(Loan_Accounts.get(i).customer.get_name()+"\tShould pay the installment ");
                    Loan_Accounts.get(i).set_flag((char)1);
                    //Loan_Accounts.get(i).PayInstallment(i, (long) pay);
                  // System.out.println("---------------------------------------------------------------------------------");
                   
               }
        }
        }
        catch (Exception e){
                
                 System.out.println("IndexOutOfBoundsException");
                }
           
        
       
    }
    
}
    

