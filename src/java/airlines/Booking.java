package airlines;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonyFlight number</th>
                        <th>Booking Date</th>
                        <th>Seat number</th>
                        <th>Customer Id</th>
                        <th>Payment Type</th>
                        <th>Amount</th>
 */
public class Booking {
    long bookingId;
    int flightNumber;
    int seatNumber;
    long customerId;
    String bookingDate;
    String paymentType;
    int amount;
    
     public long getBookingId(){
        return this.bookingId;
    }
    
    public void setBookingId(long bookingId){
        this.bookingId = bookingId;
    }
    
    public int getSeatNumber(){
        return this.seatNumber;
    }
    
    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }
    public int getflightNumber(){
        return this.flightNumber;
    }
    
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    
    public long getCustomerId(){
        return this.customerId;
    }
    
    public void setCustomerId(long customerId){
        this.customerId = customerId;
    }
    
    public String getBookingDate(){
        return this.bookingDate;
    }
    public void setBookingDate(String bookingDate){
        this.bookingDate = bookingDate;
    }
    
    public String getPaymentType(){
        return this.paymentType;
    }
    
    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
}
