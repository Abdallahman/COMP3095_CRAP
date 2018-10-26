package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;


import coreServlet.DatabaseAccess;
import coreServlet.User;
import helper.HelperReg;
import helper.VerifyRecaptcha;
import utilities.helperDB;
@WebServlet("/login_Servlet")

public class login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String btnSubmit = request.getParameter("btn");
		if (btnSubmit.equals("Login")) {
			
			
			
			HelperReg usr = new HelperReg();
			String username = request.getParameter("txtUserName");
			String password = request.getParameter("txtPassword");
			
						
				if (usr.isMissing(username) || usr.isMissing(password))
						response.sendRedirect("login.jsp");
					
				else if (!usr.validate(username) || !usr.validatePassword(password)){
					
					String errorMessage = "Invalid username and/ or password";
					request.setAttribute("error", errorMessage);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				
				}
              				
				else {
				// declare a string to hold a name of the user	
					boolean isFound;
			      try {
						isFound = helperDB.checkExistUser(username, password);
						if (isFound == true) {		
							HttpSession session =request.getSession();
							session.setAttribute("username", username);
							request.getRequestDispatcher("dashboard.jsp").include(request, response);					
							
						}
						else
						{
							String errorMessage = "Invalid username and/ or password";
							request.setAttribute("error", errorMessage);
							request.getRequestDispatcher("login.jsp").forward(request, response);
						
								}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				
				
				
							} else {
		response.sendRedirect("register.jsp");
		}
	}
}

