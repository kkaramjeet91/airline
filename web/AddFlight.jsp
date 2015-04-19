<%-- 
    Document   : index
    Created on : 5 Apr, 2015, 2:44:15 PM
    Author     : sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@page import="airlines.DataBaseManager"%>
<%@page import="airlines.Airport"%>


<%
    DataBaseManager dbObj = new DataBaseManager();
    ArrayList<Airport> airportList = dbObj.getAirports();
%>
<html>
    <head>
        <title>s1 Application</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">  
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">s1App</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Flight <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="AddFlight.jsp">Add Flight</a></li>
                                <li><a href="ListFlights.jsp">List Flights</a></li>
                            </ul>
                        </li>
                    </ul>
                    
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Customer <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="AddCustomer.jsp">Add Customer</a></li>
                                <li><a href="ListCustomers.jsp">List Customers</a></li>
                            </ul>
                        </li>
                    </ul>
                     <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ticket Booking<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="NewBooking.jsp">New booking</a></li>
                                <li><a href="ListBooking.jsp">Booking List</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Airport<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="AddAirport.jsp">Add Airport</a></li>
                                <li><a href="ListAirport.jsp">Airport List</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
               
            </div><!-- /.container-fluid -->
        </nav>
        
         <form id="form" action="Controller" method="POST">
            <div class="form-group">
                <label for="depature">Departure</label>
                <input type="text" class="form-control" id="departure" name="departure" placeholder="Please enter Departure place"/>
            </div>
            <div class="form-group">
                <label for="arrival">Arrival</label>
                <input type="text" class="form-control" id="arrival" name="arrival" placeholder="Please enter Arrival place"/>
            </div>
            <div class="form-group">
                <label for="fromDate">From Date (Note: Date format(yy/mm/dd))</label>
                <input type="text" class="form-control" id="fromDate" name="fromDate" placeholder="Please enter from date"/>
            </div>
            <div class="form-group">
                <label for="toDate">To Date(Note: Date format(yy/mm/dd))</label>
                <input type="text" class="form-control" id="toDate" name="toDate" placeholder="Please enter to date"/>
            </div>
            <div class="form-group">
                <label for="availableSeats">Available Seats</label>
                <input type="text" class="form-control" id="availableSeats" name="availableSeats" placeholder=""/>
            </div>
            <div class="form-group">
                <label for="airportId">Airport Id</label>
                <select class="form-control" id="airportId" name="airportId">
                    <%
                        int len = airportList.size();
                        for(int i=0;i<len;i++){
                            Airport airport = airportList.get(i);
                    %>
                    <option value="<%=airport.getAirportId()%>"><%=airport.getAirportId()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="cost">Cost</label>
                <input type="text" class="form-control" id="cost" name="cost" placeholder="Please enter cost"/>
            </div>
            <input type="text" class="form-group" id="controllerLabel" name="controllerLabel" value="AddFlight" hidden/>
            <button type="submit" class="btn btn-danger">Add flights</button>
        </form>
    </body>
</html>
