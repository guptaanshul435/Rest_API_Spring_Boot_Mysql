package ms.library.mylibrary.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	public static boolean isValidEmail(String email){
		
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
		Pattern pattern= Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);  
	    return matcher.matches();
	}
	public static boolean isValidNumber(String mobNumber){
		//validates phone numbers having 10 digits (9998887776)  
		if (mobNumber.matches("\\d{10}"))  
		return true;  
		//validates phone numbers having digits, -, . or spaces  
		else if (mobNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))  
		return true;  
		else if (mobNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))  
		return true;  
		//validates phone numbers having digits and extension (length 3 to 5)  
		else if (mobNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))  
		return true;  
		//validates phone numbers having digits and area code in braces  
		else if (mobNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))  
		return true;  
		else if (mobNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))  
		return true;  
		else if (mobNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))  
		return true;  
		//return false if any of the input matches is not found  
		else  
		return false;  	
	}
   public static boolean isValidName(String name){
		String regex = "^[A-Za-z]\\w{5,29}$";
		Pattern p=Pattern.compile(regex);
		return p.matcher(name).matches();
	}

}
