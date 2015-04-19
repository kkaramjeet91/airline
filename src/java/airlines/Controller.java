/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sony
 */
public class Controller extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);      
        String requestFrom=request.getParameter("controllerLabel");
        DataBaseManager dbObj = new DataBaseManager();
        if(requestFrom.equalsIgnoreCase("DeleteAirport"))
        {
            long id = Long.parseLong(request.getParameter("airportId"));
            boolean status = dbObj.deleteAirport(id);
            if(status){
                response.sendRedirect("ListAirport.jsp");
            }
        }
        else  if(requestFrom.equalsIgnoreCase("DeleteFlights"))
        {
            int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));
            boolean status = dbObj.deleteFlights(flightNumber);
            if(status){
                response.sendRedirect("ListFlights.jsp");
            }
        }
        else  if(requestFrom.equalsIgnoreCase("DeleteBooking"))
        {
            long bookingId = Long.parseLong(request.getParameter("bookingId"));
            boolean status = dbObj.deleteBooking(bookingId);
            if(status){
                response.sendRedirect("ListBooking.jsp");
            }
        }
         else  if(requestFrom.equalsIgnoreCase("DeleteCustomer"))
        {
            long CustomerId = Long.parseLong(request.getParameter("CustomerId"));
            boolean status = dbObj.deleteCustomer(CustomerId);
            if(status){
                response.sendRedirect("ListCustomers.jsp");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String requestFrom=request.getParameter("controllerLabel");
        DataBaseManager dbObj = new DataBaseManager();
        if(requestFrom.equalsIgnoreCase("AddAirport"))
        {
            String name = request.getParameter("airportName");
            String city = request.getParameter("airportCity");
            String country = request.getParameter("airportCountry");
            Airport airport = new Airport();
            airport.setName(name);
            airport.setCity(city);
            airport.setCountry(country);
            boolean status = dbObj.insertAirport(airport);
            if(status){
                response.sendRedirect("ListAirport.jsp");
            }
        }
        else if (requestFrom.equalsIgnoreCase("AddFlight"))
        {
            String departure = request.getParameter("departure");
            String arrival = request.getParameter("arrival");
            String fromDate = request.getParameter("fromDate");
            String toDate = request.getParameter("toDate");
            int availableSeats = Integer.parseInt(request.getParameter("availableSeats"));
            long airportId = Long.parseLong(request.getParameter("airportId"));
            int cost = Integer.parseInt(request.getParameter("cost"));
            String currency = "USD";
            
            Flights flights = new Flights();
            flights.setdeparture(departure);
            flights.setarrival(arrival);
            flights.setfromDate(fromDate);
            flights.settoDate(toDate);
            flights.setavailalbeSeats(availableSeats);
            flights.setairportId(airportId);
            flights.setcost(cost);
            flights.setcurrency(currency);
            boolean status = dbObj.insertFlights(flights);
            if(status){
                response.sendRedirect("ListFlights.jsp");
            }
        }
        else if (requestFrom.equalsIgnoreCase("NewBooking"))
        {
           // String bookingId = request.getParameter("bookingId");
            int flightNumber = Integer.parseInt (request.getParameter("flightNumber"));
           // int seatNumber = Integer.parseInt(request.getParameter("seatNumber"));
            long customerId = Long.parseLong(request.getParameter("customerId"));
            String paymentType = request.getParameter("paymentType");
            int amount = Integer.parseInt(request.getParameter("amount"));
           
            
            Booking booking = new Booking();
            booking.setFlightNumber(flightNumber);
            //booking.setSeatNumber(seatNumber);
            booking.setCustomerId(customerId);
            booking.setPaymentType(paymentType);
            booking.setAmount(amount);
            
            boolean status = dbObj.insertBooking(booking);
            if(status){
                response.sendRedirect("ListBooking.jsp");
            }
        }
        else  if(requestFrom.equalsIgnoreCase("AddCustomer"))
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String country = request.getParameter("country");
            String address = request.getParameter("address");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
           
            
            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setCountry(country);
            customer.setAddress(address);
            customer.setMobile(mobile);
            customer.setEmail(email);
            customer.setGender(gender);
        
            boolean status = dbObj.insertCustomer(customer);
            if(status){
                response.sendRedirect("ListCustomers.jsp");
            }
        } 
    }
}