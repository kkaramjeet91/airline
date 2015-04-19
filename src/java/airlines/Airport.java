package airlines;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sony
 */
public class Airport {
    long airportId; 
    /*airport id is not bigint in db*/
    String name;
    String city;
    String country;
    
    public long getAirportId(){
        return this.airportId;
    }
    
    public void setAirportId(long id){
        this.airportId = id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getCity(){
        return this.city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getCountry(){
        return this.country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
}
