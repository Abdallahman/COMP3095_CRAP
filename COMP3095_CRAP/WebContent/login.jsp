<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://www.google.com/recaptcha/api.js"></script>
<link href="layout.css" type="text/css" rel="stylesheet">
<title>A Web Page</title>
</head>
<body>
<h1 align="center"> LOGIN</h1>
<h4 align="center" color="green"> <%if(request.getAttribute("error")!= null) {%>
<%= request.getAttribute("error") %><br/>
<%}%> </h4>
<form action="login_Servlet" method="post">
<label> Username:    </label>
<input type="text" name="txtUserName"> <br>
<label> Password:    </label>
<input type="text" name="txtPassword"> <br>

<div class="g-recaptcha" data-sitekey="6LfcrXYUAAAAAGKsC2mcrtk_UVH2_zH7wuFfsP9c" align="center">

</div>
 <input type="submit" name="btn" value="Login">
<input type="submit" name="btn" value="Register"><br>

<a href="#"> Forgot your password</a>
 <br>

<br>
</form>
</body>
</html>