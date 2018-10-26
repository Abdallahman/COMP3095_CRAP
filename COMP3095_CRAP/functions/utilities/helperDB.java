package utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class helperDB {
	
	//public class Main {
		private static final String USERNAME = "root";
		private static final String PASSWORD = "P@ssword1";
	    private static final String CONN_STRING = 
				"jdbc:mysql://localhost/COMP3095";
		private static Statement stmt = null;
		private static ResultSet rs = null;
		private static Connection conn = null;
		
		// declare the connection 
		// Name the driven name
		// connect using Driver manage
		// Return the Connection 
		//-----------------------------------------------------------------------------
		
		public static Connection getConnect() throws Exception {	
			Connection con = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			} catch (SQLException e) {
				System.err.println(e);
			}
			return con;
		}
		
		// Insert data to the users.
		// check the existing connection from getConnect() function
		// return true if inserted
		// return false if something wrong happen!
		//-----------------------------------------------------------------------------
		
		public static boolean addData(String query) throws SQLException {
			boolean action = false;		
			try {
				conn  = getConnect();
				if (conn != null) {
					stmt = conn.createStatement();
					stmt.executeUpdate(query);		
					action = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}finally {
				if (rs != null)
					rs.close();
				if (stmt !=null )
					stmt.close();
				if (conn != null)
					conn.close();			
			}		
			return action;
		}
		
		//Check existing user by his email
		//User use select and compare with the eamil 
		//Return true and go back to the register
		// Return false
		//-------------------------------------------------------------------------------------------
		
		public static boolean checkExistUser(String email, String password) throws SQLException {
			//boolean action = false;
			boolean action = false;
			try {
				//Get Connection
				    conn  = getConnect();
				    // Create a statemtne
					stmt = conn.createStatement();
					
					String sql = "SELECT email,password FROM users where email='"+email+"' AND password = '"+password+"'";
					rs = stmt.executeQuery(sql);		
					
					if (rs.next()) {
						action = true;
						}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}finally {
				if (rs != null)
					rs.close();
				if (stmt !=null )
					stmt.close();
				if (conn != null)
					conn.close();
					
			}
			
			return action;
		}
		
		
			
}


