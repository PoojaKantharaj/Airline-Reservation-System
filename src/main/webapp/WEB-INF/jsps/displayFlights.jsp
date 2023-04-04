<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display Flights</title>
</head>
<body>
<h2>Flight Search List</h2>
<table>
<tr>
<th>Airline</th>
<th>Departure city</th>
<th>Arrival city</th>
<th>Departure time</th>
</tr>
<c:forEach items = "${findFlights}" var = "findFlights">
<tr>
<td>${findFlights.operatingAirlines}</td>
<td>${findFlights.departureCity}</td> 
<td>${findFlights.arrivalCity}</td>
<td>${findFlights.estimatedDepartureTime}</td>
<td><a href= "showReservation?flightId=${findFlights.id}">select</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>