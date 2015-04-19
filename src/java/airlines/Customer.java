/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

/**
 *
 * @author sony
 */
public class Customer {
    long customerId;
    String firstName;
    String lastName;
    String email;
    String mobile;
    String country;
    String address;
    String gender;
    
    public long getCustomerId(){
        return this.customerId;
    }
    
    public void setCustomerId(long customerId){
        this.customerId = customerId;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getCountry(){
        return this.country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getMobile(){
        return this.mobile;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
     public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
     public String getGender(){
        return this.gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
}

    

