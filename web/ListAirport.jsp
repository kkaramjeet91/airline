<%-- 
    Document   : index
    Created on : 5 Apr, 2015, 2:44:15 PM
    Author     : sony
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="airlines.DataBaseManager"%>
<%@page import="airlines.Airport"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    DataBaseManager dbObj=new DataBaseManager();
    ArrayList<Airport> list = dbObj.getAirports();
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
                        <li class="dropdown">
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
                                <li><a href="ListBooking.jsp">List Bookings</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Airport<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="AddAirport.jsp">Add Airport</a></li>
                                <li><a href="ListAirport.jsp"> List Airports</a></li>
                            </ul>
                        </li>
                    </ul> 
                </div><!-- /.navbar-collapse -->
               
            </div><!-- /.container-fluid -->
        </nav>
        
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">List of Airports</div>

            <!-- Table -->
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Airport Id</th>
                        <th>Airport Name</th>
                        <th>City</th>
                        <th>Country</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int len = list.size();
                        for(int i=0;i<len;i++){
                            Airport airport = list.get(i);
                    %>
                    <tr>
                        <td><%=i+1%></td>
                        <td><%=airport.getAirportId()%></td>
                        <td><%=airport.getName()%></td>
                        <td><%=airport.getCity()%></td>
                        <td><%=airport.getCountry()%></td>
                        <td><a href="Controller?airportId=<%=airport.getAirportId()%>&controllerLabel=DeleteAirport">Delete</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
