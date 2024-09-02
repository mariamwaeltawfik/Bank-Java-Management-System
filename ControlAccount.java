/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bank_management;

import java.util.ArrayList;

/**
 *
 * @author NOTEBOOK
 */
  public  interface ControlAccount {
  public  void craet_account(String type,double Balance,String name,String password,String phone,String adress,String Email,String NationalID ,int age);
  public  <T>void edit_account(int account_id,String the_edition,T  edit);
  public  void delete_account(int account_id);
  public void  display_account(int account_id);
    
    ArrayList<Account> Accounts = new ArrayList<>();
    ArrayList<A_SavingAccount> Saving_Accounts = new ArrayList<>();
    ArrayList<A_CheckingAccount> Checking_Accounts = new ArrayList<>();
    ArrayList<A_LoanAccount> Loan_Accounts = new ArrayList<>();
    ArrayList<Employee> allAccounts = new ArrayList<>();
    ArrayList<Admin> Admins = new ArrayList<>();
     ArrayList<Manager> Managers = new ArrayList<>();
}
