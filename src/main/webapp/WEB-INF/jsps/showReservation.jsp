    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Reservation flight Details</h2>
Flight Number: ${flight.flightNumbers}</br>
Operating Airlines: ${flight.operatingAirlines}</br>
Departure : ${flight.departureCity}</br>
Destination: ${flight.arrivalCity}</br>
Departure Date: ${flight.dateOfDeparture}</br></br>
<h2>Enter Passenger Details</h2>
<form action="confirmReservation" method = "post">
<pre>
First Name: <input type= "text" name= "firstName"/>
Middle Name: <input type= "text" name= "middleName"/>
Last Name: <input type= "text" name= "lastName"/>
Email: <input type= "text" name= "email"/>
phone: <input type= "text" name= "phone"/>
<input type= "hidden" name= "flightId" value = "${flightId}"/>

<h2>Enter Card Details</h2>
Name of card user: <input type = "text" name ="cardHolderName"/>
Card Number: <input type = "text" name ="cardNumber"/>
CVV: <input type = "text" name ="cvv"/>
Expiry date: <input type = "text" name ="expirationDate"/>
<input type= "submit" value= "Complete Reservation"/>
</pre>
</form>
</body>
</html>