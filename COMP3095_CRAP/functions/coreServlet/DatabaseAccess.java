package coreServlet;

/****************************************************************************************************
* Description: DatabaseAccess - Example provides access to database
****************************************************************************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatabaseAccess {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String username = "admin";
	private static String password = "P@ssword1";
	private static String URL = "jdbc:mysql://localhost:3306/comp3095?";
    private static Connection connect = null;	  
	  //Method to connect to database
	  // Return connection or null
	 
    public static Connection getConnection() throws Exception {
	    try {
	     
	      Class.forName(driver);
	      connect = DriverManager.getConnection(URL,username,password);
	      return connect;
	    } catch (Exception e) {
	      return null;
	    } 
	  }
	  
	  // Method to insert to database
	  // Check if the connection is created 
    
	 public static boolean InsertToDB(String qryd) throws Exception { 
		boolean action = false;
		Connection con = getConnection();
		Statement stmt = null;
		try {
		  stmt = con.createStatement();
		  stmt.executeUpdate(qryd);
		   action = true;
		 } catch(Exception e) {
			action = false;
		 }
		finally {
			try {
				stmt.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		  return action;
	  }
	  
	  
	  //Select from database
	/*  public static String Show_Selected() {
		 String c ="";
		  try {
			 // String c="";
			Connection con = connectDataBase();
			 Statement stmt =  con.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT FROM USERS");
			  while(rs.next()){  
				  c+=rs.getInt(1)+" "+rs.getString(2) + "" + rs.getString(3);  
				  }
			  con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return c;
}*/
}
