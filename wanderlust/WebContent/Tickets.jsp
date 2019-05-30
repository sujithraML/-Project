<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.aspire.travelexploration.entity.Ticket"
    import="java.util.ArrayList"
	import="java.util.List"
	import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tickets</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<% if(session.getAttribute("userid")!=null){%>		
 <form id="view" action="ViewTickets" method="post">
 <span><button class="btn btn-dark" type=submit>Booking History</button></span>
 </form>
<%if(request.getAttribute("tickets")!=null){ %>
	 <form id="history" action="TicketCancellation" method="post">
	 	<table class="table">
	 	<tr>
 		<th>Passenger name</th>
 		<th>Departure Time</th>
 		<th>TicketId</th>
 		<th>flightId </th>
 		<th>DepartureDate</th>
 		<th>Date of Booking</th>
 		<th>Class</th>
 		<th>Status </th>
 		</tr>
<% 		List<Object> tickets=new ArrayList<Object>(); 
		tickets=(List<Object>)request.getAttribute("tickets");
		Iterator<Object> iterator=tickets.iterator();
		while(iterator.hasNext()){
			 Ticket ticket=new Ticket();
			 ticket=(Ticket)iterator.next();
 %>
 	<tr>	
 			<td><%= ticket.getPassengerName() %></td>
 			<td><%= ticket.getDepTime()%></td>
 			<td><%= ticket.getTicketId()%></td>
 			<td><%= ticket.getFlightId()%></td>
 			<td><%= ticket.getDepDate()%></td>
 			<td><%= ticket.getDateOfBooking()%></td>
 			<td><%= ticket.getFlightClass() %></td>
 			<td><%= ticket.getStatus()%></td>
 			<%session.setAttribute("ticketid", ticket.getTicketId()); %>
 			<%session.setAttribute("flightid", ticket.getFlightId()); %>
 			<%if(ticket.getStatus().toString()=="CONFIRMED"){%>
 			 <td><button class="btn btn-dark" onClick="">confirm</button></td>
 			 <td><button class="btn btn-dark" type="submit" >cancel</button></td>
 			<%} %>

 	</tr>
 	<%} %>
 		 </form>
  	</table>
<%
}
} %>
</body>
<script>
	function cancel_ticket(){
		
	}
</script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</html>