package bank_management;

import static bank_management.ControlAccount.Checking_Accounts;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static bank_management.ControlAccount.allAccounts;


public class Employee {
    
    public String name;
    private String phone;
    private String email;
    private String password;
    private String department;
    private double salary;
    


    Employee() {
    }

    Employee(String name, String phone, String email, String password, String department, double salary) {
        this.name =name;
        this.password = hashPasword(password);
        this.phone = phone;
        this.email = email;
        this.department = department;
        this.salary = salary;
    
    }
    public void Creat_Employee(String name, String phone, String email, String password, String department, double salary){
         Employee employe=new Employee(name,phone,email,password,department,salary);
       allAccounts.add(employe);
    }
     public boolean employeeExists(String employeeUsername, String employeePassword){
         boolean ret=false;
         for(int i=0;i<allAccounts.size();i++){
             if(employeeUsername.equals(allAccounts.get(i).getName())){
                 ret = allAccounts.get(i).chekPasword(employeePassword);
             }
             
         }
         return ret;
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

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static ArrayList<Employee> getAllAccounts() {
        return allAccounts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName()+ '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
               // ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

