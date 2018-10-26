package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;
//import com.sun.corba.se.pept.transport.Connection;

import coreServlet.User;
import helper.HelperReg;
import utilities.helperDB;

@WebServlet("/register_Servlet")
public class register_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public register_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Initialization of variable of button
		String btn =  request.getParameter("btn");
		HttpSession session =request.getSession();
		// check which button are pressed
		if(btn.equals("register")) {
			
		// Initialize all the value from the user input
			
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String address=request.getParameter("Address");
		String password=request.getParameter("password");
		
		// instantiation of  the regular expression class called HelperReg
		HelperReg usr = new HelperReg();
		
		// Test empty string or null value 
		// Test the validity of the email or password
		
		if ((usr.isMissing(firstName) == true) || (usr.isMissing(lastName) == true) || 
		       (usr.isMissing(email) == true) || (usr.isMissing(password) == true) )
        
{
	String errorMessage = "All fields are required";
	
	request.setAttribute("error", errorMessage);
	request.getRequestDispatcher("register.jsp").forward(request,  response);
	
}else {
	if(usr.validate(email) != true || usr.validatePassword(password) != true){
		
		String errorMessage = "The password must be between 6 and 12 characters";
		String errorMessage2 = "You must enter a valid email address";
		request.setAttribute("error", errorMessage + "\n" + errorMessage2);
		request.getRequestDispatcher("register.jsp").forward(request,  response);
}
}			
		
		
		try {
			
			// Check whether the user already exist
			if (helperDB.checkExistUser(email, password) == true) {		
				
				String errorMessage = "You are already registered. Please Login to continue";
				//String errorMessage2 = "You must enter a valid email address";
				request.setAttribute("error", errorMessage);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				// If not insert all the information of the user to the database
					String query = "INSERT INTO USERS (firstname, lastname, email, password)"
							+ " VALUES ('"+firstName+"','"+lastName+"','"+email+"','"+password+"')";
					if(helperDB.addData(query) == true) 
						
					    session.setAttribute("username", firstName);
						request.getRequestDispatcher("dashboard.jsp").include(request,  response);
					}} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			
		}}
		
	    else {
			response.sendRedirect("register.jsp");
		}
}
}

