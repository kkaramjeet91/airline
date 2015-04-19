/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import airlines.Airport;
import airlines.Flights;
import airlines.Booking;
import airlines.Customer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DataBaseManager {
    Connection connection = null;
    String userName = "user";
    String password = "password";
    String port = "3306";

    public Connection createDataBaseConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/sdb1", userName, password);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {

        }
    }

    public ArrayList<Airport> getAirports() {
        ResultSet rs = null;
        Connection conn = null;
        ArrayList<Airport> list = new ArrayList();
        try {
            conn = createDataBaseConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM airport";

            rs = stmt.executeQuery(sql);
            if (rs != null) {
                //System.out.println(rs);
                while (rs.next()) {
                    Airport obj = new Airport();
                    obj.setAirportId(Long.parseLong(rs.getString("airport_id")));
                    obj.setName(rs.getString("name"));
                    obj.setCity(rs.getString("city"));
                    obj.setCountry(rs.getString("country"));
                    list.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeConnection(conn);
        return list;
    }
    
    public boolean insertAirport(Airport Obj)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        String insertSQL = "INSERT INTO `airport`(`name`, `city`, `country`) VALUES (?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
        preparedStatement.setString(1, Obj.getName());
        preparedStatement.setString(2, Obj.getCity());
        preparedStatement.setString(3, Obj.getCountry());
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("Updated successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            
        }
        closeConnection(conn);
        return isSuccess;
    }
    
    public boolean deleteAirport(long id)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        String sql = "DELETE from `airport` where airport_id in (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("Delete successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            
        }
        closeConnection(conn);
        return isSuccess;
    }
    boolean deleteAirport(int airpotId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList<Flights> getFlights() {
        ResultSet rs = null;
        Connection conn = null;
        ArrayList<Flights> list = new ArrayList();
        try {
            conn = createDataBaseConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM flights";

            rs = stmt.executeQuery(sql);
            if (rs != null) {
                //System.out.println(rs);
                while (rs.next()) {
                    Flights obj = new Flights();
                    obj.setflightNumber(rs.getInt("flight_num"));
                    obj.setdeparture(rs.getString("departure"));
                    obj.setarrival(rs.getString("arrival"));
                    obj.setfromDate(rs.getString("from_date"));
                    obj.settoDate(rs.getString("to_date"));
                    obj.setavailalbeSeats(Integer.parseInt(rs.getString("avail_seats")));
                    obj.setairportId(Long.parseLong(rs.getString("airport_id")));
                    obj.setcost(Integer.parseInt(rs.getString("cost")));
                    obj.setcurrency(rs.getString("currency"));
                    
                    list.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeConnection(conn);
        return list;
    }

    public boolean insertFlights(Flights Obj)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        String insertSQL = "INSERT INTO `flights`(`departure`, `arrival`, `from_date`,`to_date`, `avail_seats`, `airport_id`,`cost`, `currency`) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
        preparedStatement.setString(1, Obj.getdeparture());
        preparedStatement.setString(2, Obj.getarrival());
        preparedStatement.setString(3, Obj.getfromDate());
        preparedStatement.setString(4, Obj.gettoDate());
        preparedStatement.setInt(5, Obj.getavailableSeats());
        preparedStatement.setLong(6, Obj.getairportId());
        preparedStatement.setInt(7, Obj.getcost());
        preparedStatement.setString(8, Obj.getcurrency());        
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("Updated successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            
        }
        closeConnection(conn);
        return isSuccess;
    }
    
    public boolean deleteFlights(int flightNumber)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        String sql = "DELETE from `flights` where flight_num in (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, flightNumber);
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("Delete successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            
        }
        closeConnection(conn);
        return isSuccess;
    }
    public ArrayList<Booking> getBooking() {
        ResultSet rs = null;
        Connection conn = null;
        ArrayList<Booking> list = new ArrayList();
        try {
            conn = createDataBaseConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM ticketbooking";

            rs = stmt.executeQuery(sql);
            if (rs != null) {
                //System.out.println(rs);
                while (rs.next()) {
                   Booking obj = new Booking();
                    obj.setBookingId(Long.parseLong(rs.getString("booking_id")));
                    obj.setFlightNumber(Integer.parseInt(rs.getString("flight_num")));
                    obj.setBookingDate(rs.getString("booking_date"));
                    obj.setSeatNumber(Integer.parseInt(rs.getString("seat_num")));
                    obj.setCustomerId(Long.parseLong(rs.getString("cust_id")));
                    obj.setPaymentType(rs.getString("payment_type"));
                    obj.setAmount(Integer.parseInt(rs.getString("amount")));
                    list.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeConnection(conn);
        return list;
    }
    public boolean insertBooking(Booking Obj)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        
        int max_seat = -1;
        Statement stmt = conn.createStatement();
        String sql="SELECT MAX(seat_num) as max FROM ticketbooking where flight_num="+Obj.getflightNumber();
        ResultSet rs = stmt.executeQuery(sql);
        rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                max_seat = Integer.parseInt(rs.getString("max"));
            }
        }
        
        String insertSQL = "INSERT INTO `ticketbooking`(`flight_num`, `booking_date`, `seat_num`,`cust_id`,`payment_type`,`amount`) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
        preparedStatement.setInt(1, Obj.getflightNumber());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        preparedStatement.setString(2, format.format(date));      
        preparedStatement.setInt(3, max_seat+1);
        preparedStatement.setLong(4,Obj.getCustomerId());
        preparedStatement.setString(5, Obj.getPaymentType());
        preparedStatement.setInt(6, Obj.getAmount());
        
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("inserted successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        closeConnection(conn);
        return isSuccess;
    }
    
    public boolean deleteBooking(long bookingId)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        String sql = "DELETE from `ticketbooking` where booking_id in (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, bookingId);
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("Delete successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            
        }
        closeConnection(conn);
        return isSuccess;
    }
    boolean deleteBooking(Long bookingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Customer> getCustomer() {
        ResultSet rs = null;
        Connection conn = null;
        ArrayList<Customer> list = new ArrayList();
        try {
            conn = createDataBaseConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM customer";

            rs = stmt.executeQuery(sql);
            if (rs != null) {
                //System.out.println(rs);
                while (rs.next()) {
                    Customer obj = new Customer();
                    obj.setCustomerId(Long.parseLong(rs.getString("cust_id")));
                    obj.setFirstName(rs.getString("first_name"));
                    obj.setLastName(rs.getString("last_name"));
                  
                    obj.setMobile(rs.getString("mobile"));
                    obj.setEmail(rs.getString("email"));
                    obj.setAddress(rs.getString("address"));
                    obj.setCountry(rs.getString("country"));
                    obj.setGender(rs.getString("gender"));
                    
                    list.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeConnection(conn);
        return list;
    }
    
     public boolean insertCustomer(Customer Obj)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        String insertSQL = "INSERT INTO `customer`(`cust_id`, `first_name`, `last_name`,`mobile`,`email`,`address`,`country`,`gender`) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
        preparedStatement.setLong(1, Obj.getCustomerId());
        preparedStatement.setString(2, Obj.getFirstName());
        preparedStatement.setString(3, Obj.getLastName());
        preparedStatement.setString(4, Obj.getCountry());
        preparedStatement.setString(5, Obj.getMobile());
        preparedStatement.setString(6, Obj.getEmail());
        preparedStatement.setString(7, Obj.getAddress());
        preparedStatement.setString(8, Obj.getGender());
        
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("inserted successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            
        }
        closeConnection(conn);
        return isSuccess;
    }
    
    public boolean deleteCustomer(long CustomerId)
    {
        boolean isSuccess=false;
        Connection conn=null;
        try
        {
        conn=createDataBaseConnection();
        String sql = "DELETE from `customer` where cust_id in (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, CustomerId);
        
        int result= preparedStatement.executeUpdate();
        if(result==1)
        {
           System.out.println("Delete successfully");
           isSuccess=true;
        }
        }
        catch(Exception e)
        {
            
        }
        closeConnection(conn);
        return isSuccess;
    }
    boolean deleteCustomer(Long CustomerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


