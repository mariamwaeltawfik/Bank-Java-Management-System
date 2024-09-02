/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_management;

/**
 *
 * @author NOTEBOOK
 */
import static bank_management.ControlAccount.Admins;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author NOTEBOOK
 */
public class Admin {
    private String uaser_name;
    private String password;
    
    Admin(){
        
    }
    Admin(String uaser_name,String password){
        this.setName(uaser_name);
        this.password=hashPasword(password);
    }
    public boolean adminExists(String AdminUsername, String AdminPassword){
         boolean ret=false;
         try{
         for(int i=0;i<Admins.size();i++){
             if(AdminUsername.equals(Admins.get(i).getName())){
                 ret = Admins.get(i).chekPasword(AdminPassword);
             }
             
         }
         }
         catch(ArrayIndexOutOfBoundsException e){
             System.out.println(e);
         }
         return ret;
     }
     public void Creat_Admin(String name, String password){
         Admin admin=new Admin(name,password);
       Admins.add(admin);
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
     public String getName(){
        return uaser_name;
    }
    
    public void setName(String name){
        this.uaser_name=name;
    }
}
