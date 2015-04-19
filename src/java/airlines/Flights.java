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
public class Flights {
     int flightNumber;
    String departure;
    String arrival;
    String fromDate;
    String toDate;
    int availableSeats;
    long airportId;
    int cost;
    String currency;
    
    public int getflightNumber(){
        return this.flightNumber;
    }
    
    public void setflightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    
    public String getdeparture(){
        return this.departure;
    }
    
    public void setdeparture(String departure){
        this.departure = departure;
    }
    
    public String getarrival(){
        return this.arrival;
    }
    
    public void setarrival(String arrival){
        this.arrival = arrival;
    }
    
    public String getfromDate(){
        return this.fromDate;
    }
    
    public void setfromDate(String fromDate){
        this.fromDate = fromDate;
    }
    public String gettoDate(){
        return this.toDate;
    }
    
    public void settoDate(String toDate){
        this.toDate = toDate;
    }
    public int getavailableSeats(){
        return this.availableSeats;
    }
    
    public void setavailalbeSeats(int availalbeSeats){
        this.availableSeats = availalbeSeats;
    }
    public long getairportId(){
        return this.airportId;
    }
    
    public void setairportId(long airportId){
        this.airportId = airportId;
    }
     public int getcost(){
        return this.cost;
    }
    
    public void setcost(int cost){
        this.cost = cost;
    }
     public String getcurrency(){
        return this.currency;
    }
    
    public void setcurrency(String currency){
        this.currency = currency;
    }
    
}

    

