/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_management;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Visa {
   
    private long id;
    private double balance;
    private String password;

 
    public Visa(long id, double balance, String password) {
        this.id = id;
        this.balance = balance;
        this.password = hashPasword(password);
    }

    private String hashPasword(String paswrd) {
        try {
            MessageDigest mesageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hasedBytes = mesageDigest.digest(paswrd.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hasedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException excepion) {
            throw new RuntimeException(excepion);
        }
    }

    public boolean chekPasword(String entredPasword) {
        String entredHash = hashPasword(entredPasword);
        return password.equals(entredHash);
    }
    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }



  
    public void setId(long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   
    @Override
    public String toString() {
        return "Visa{" +
                "id=" + id +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}

