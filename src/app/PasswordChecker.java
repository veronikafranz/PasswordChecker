package app;
import java.util.Scanner;

/**
 * A class that checks password for characteristics
 *  
 * @author veron
 */
public class PasswordChecker {
	

	/**
	 * checks a password for the following characteristics:
	 * A valid password consists of minimum 8 and maximum 16 characters, 
	 * contains at least one digit, one upper case and one lower case and no space.
	 * 
	 * @param password
	 * @return true, if password is valid, else false
	 */
	public boolean checkPassword(String password) {
		if(password == null) {
			return false;
		}
		
		return checkDigits(password)
				&& checkUpperCase(password)
				&& checkLowerCase(password)
				&& !containsSpace(password)
				&& checkLength(password);
	}
	
	private boolean checkDigits(String password) {
		//Zifferprüfung
		for(int i = 0; i < password.length(); i++) {
			//wenn enthalten
			if(Character.isDigit(password.charAt(i))) {
				return true;				
			}
		}
		return false;
	}
	
	private boolean checkUpperCase(String password) {
		//upperCase-Prüfung
		for(int i = 0; i < password.length(); i++) {
			//wenn upperCase enthalten
			if(Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkLowerCase(String password) {
		//lowerCase-Prüfung
		for(int i = 0; i < password.length(); i++) {
			//wenn lowerCase enthalten
			if(Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private boolean containsSpace(String password) {
		//containsSpace-Prüfung
		for(int i = 0; i < password.length(); i++) {
			//wenn Space enthalten
			if(password.charAt(i) == ' ') {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkLength(String password) {
		if(password.length() >= 8 && password.length() <= 16) {
			return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
		PasswordChecker pwc = new PasswordChecker();
		Scanner sc = new Scanner(System.in);
		String passwort = null;
		try {
			System.out.println("Please enter a password:");
			passwort = sc.next();
		} finally {
			sc.close();
			System.out.println("Password is good: " + pwc.checkPassword(passwort));
		}
	}	

}
