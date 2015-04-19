<%-- 
    Document   : index
    Created on : 5 Apr, 2015, 2:44:15 PM
    Author     : sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                        <li class="dropdown active">
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
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Please enter First Name"/>
            </div>
            <div class="form-group">
                <label for="lastName">Last  Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Please enter Last  Name"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Please enter Email"/>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile</label>
                <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Please enter Mobile"/>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="Please enter address"/>
            </div>
             <div class="form-group">
                <label for="country">Country</label>
                <input type="text" class="form-control" id="country" name="country" placeholder="Please enter country"/>
            </div>
            <div class="form-group">
                <label for="gender">Gender</label>
                 <select class="form-control" id="gender" name="gender" placeholder="Please enter gender"/>
                    <option value="F">Female</option>                    
                    <option value="M">Male</option>
                </select>
            </div>
            <input type="text" class="form-group" id="controllerLabel" name="controllerLabel" value="AddCustomer" hidden/>
            <button type="submit" class="btn btn-danger">Add Customer</button>
        </form>
    </body>
</html>
