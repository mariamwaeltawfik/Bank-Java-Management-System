/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_management;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author NOTEBOOK
 */
public  class Customer {
    static int max_id=0;
public String name;
public String phone;
public String adress;
public String Email;
public int Customer_Id;
public int age;
public String NationalID;
 

//age | id| cusomer id|Email|
Customer(String name,String phone,String adress,String Email,String NationalID ,int age){
    this.name=(name);
    this.phone=(phone);
    this.NationalID=(NationalID);
    this.adress=adress;
    this.age=age;
    this.Customer_Id=Customer_ID();
    this.Email=Email;
}


static int Customer_ID(){
        return ++max_id;
    }
public  int get_Customer_ID(){
        return Customer_Id;
    }
public  String get_name(){
    return name;
} 
public  String get_Phone(){
    return phone;
} 
public  String get_addres(){
    return adress;
} 
public  int get_age(){
    return age;
} 

public  String get_Email(){
    return Email;
} 
public  String  get_NationalId(){
    return NationalID;
} 
 
  public void set_email(String Email){
        if(Email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")){
            
         this.Email = Email;
        }
        else{
              System.out.println("invalid Email"); 
        }
       
  }   
public  void set_name(String name){
      if(name.length()>=2){
  this.name=name;
      }
      else{
          System.out.println("\nInvalid name");
      }
} 
public  void set_Phone(String phone){
      if(phone.length()==11){
   this.phone=phone;
      }
      else {
          System.out.println("\nInvalid phone number");
      }
} 
public  void set_addres(String adress){
    this.adress=adress;
} 
public  void set_age(int age){
    if(age>=21){
     this.age=age;
    
    }
    else{
        System.out.println("\nInvalid age");
    }
   } 
public  void  set_NationalId(String NationalID){
    if(NationalID.length()>=14){
            this.NationalID=NationalID;
    }
    else {
        System.out.println("\nInvalid National Id");
    }
} 

   
@Override
public String toString(){
        return "Customer name: "+name+"\tCustomer phone: "+phone+"\tAdress: "+adress;
    }   
}

