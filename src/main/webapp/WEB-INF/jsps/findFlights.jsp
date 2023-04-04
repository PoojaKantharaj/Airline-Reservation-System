<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<body>
<h2>Flight list</h2> 
<form action = "findFlights" method = "post">
<pre>
Departure: <input type = "text" name = "from" />
Destination: <input type = "text" name = "to" />
Departure date: <input type = "text" name = "departureDate" /> 
<input type = "submit" value = "Search Flights" /> 
</pre>
</form>
</body>
</html>