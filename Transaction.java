/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bank_management;

/**
 *
 * @author NOTEBOOK
 */
public interface Transaction {
   public void Deposit(long Acc_Id,double amount);
   public void Withdrawal(long Acc_Id,double amount);
   public  void createFile(String fileName);
    public  void LogFile(String fileName, String data);
}
