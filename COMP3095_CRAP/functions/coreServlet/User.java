package coreServlet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    
	private String fName;
    private String lName;
    private String email;
    public String password;
    public String role;
    
    public User() {}
	public User(String fn, String ln, String eml, String ps) {
		this.fName = fn;
		this.lName = ln;
		this.email = eml;
		this.password = ps;
	};
	
	public void setFirstName(String fName) { this.fName = fName; }
	public String getFirstName(String fName) { return fName; }
	
	public void setLastName(String lName) { this.lName = lName; }
	public String getLastName(String lName) { return lName; }
	
	public void setEmail(String email) { this.email = email; }
	public String getEmail(String email) { return email; }
	
	public void setPassword(String password) { this.password = password; }
	public String getPassword(String password) { return password; }
	
	public String toString() {
		return this.fName + this.lName +this.email +this.password;
	}
	
	// Check if the String isValid
	public boolean isMissing(String value) {
		if(value == null || value ==" " || value.length()==0)
			return true;
		return false;
	}

	//VAlidation of password
	 
	
	  //Is 'renatamoura' a valid password? false
	  //Is 'renata' a valid password? false
	  //Is 'Renata$' a valid password? true
	  //Is 'Ded12e3#' a valid password? true
	  
	 
	
}
