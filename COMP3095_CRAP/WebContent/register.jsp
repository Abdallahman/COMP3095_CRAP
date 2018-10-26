<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A Web page</title>
</head>
<body>


	<div style="margin: auto;">
		<hr />
		<h1>REGISTRATION PAGE</h1>
		<h4 align="center"> <%if(request.getAttribute("error")!= null) {%>
<%= request.getAttribute("error") %><br/>
<%} %> </h4>

		<form method="post" action="register_Servlet">


			<table>

				<tr>
					<td><label for="firstName">First Name*</label></td>
					<td><input type="text" name="firstName" id="firstName" placeholder="First Name"
						></td>
				</tr>
				<tr>
					<td><label for="lastName">Last Name*</label></td>
					<td><input type="text" name="lastName" id="lastName" placeholder="last name" ></td>
				</tr>
				<tr>
					<td><label for="email">Your Email*</label></td>
					<td><input type="text" name="email" id="email" placeholder="e.g hello@contact.net" ></td>
				</tr>
				<tr>
					<td><label for="Address">Address*</label></td>
					<td><input type="text" name="Address" id="email" placeholder="00 James Ave, ON" ></td>
				</tr>
				
				<tr>
					<td><label for="subject">Password*</label></td>
					<td><input type="text" name="password" id="password" placeholder="password" ></td>
				</tr>
				<tr>
					<td><label for="subject">Confirm Password*</label></td>
					<td><input type="text" name="password" id="password" placeholder="Confirm password" ></td>
				</tr>
				
			</table>
		
			<table><tr>
			<td>
  <input type="checkbox" name="vehicle2" value="Yes"> I have agree to the <a href=""> terms of service</a> </td>
</tr>
			
		 <tr>
			<td> <button type="submit" name="btn" value="register">Register</button> </td>
			<td><button type="submit" name="btn" value="cancel">Cancel</button> </td>
			</tr></table>
			 <br>
			
		</form>
	</div>

</body>
</html>