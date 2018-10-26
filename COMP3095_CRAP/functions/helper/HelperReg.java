package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperReg {


		public boolean validate(String emailsr) {
			
			 Matcher matcher = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
, Pattern.CASE_INSENSITIVE).matcher(emailsr);
		        if(matcher.find())
		           return true;		
		        return false;
		        
		}
		
		// Validate password
		// 8-12 characters password with at least one digit, at least one lower case letter
		// at least one upper case letter, at least one special character with no whitespaces

		public boolean validatePassword(String password) {
			 String PASSWORD_REGEX =
					"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$";

		     Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
		     if (PASSWORD_PATTERN.matcher(password).matches()) 
					return true;
			return false;
		}
		
		public boolean isMissing(String value) {
			if(value == null || value ==" " || value.length()==0)
				return true;
			return false;
		}


}
