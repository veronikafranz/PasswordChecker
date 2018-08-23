package code;
import junit.framework.TestCase;

public class PasswortCheckerTest extends TestCase {

	PasswordChecker pwc;
	
	public void setUp() {
		pwc = new PasswordChecker();
	}
	
	public void testeMitGrossuchstabeUndMitZahl() {
		assertEquals("Pr�fung bei Gro�buchstabe und Zahl fehlerhaft.", true, pwc.checkPassword("fhghjr9H"));
	}
	
	public void testeMitGrossuchstabeUndOhneZahl() {
		assertEquals("Pr�fung mit Gro�buchstabe und ohne Zahl fehlerhaft.", false, pwc.checkPassword("fhHhjr"));
	}
	
	public void testeOhneGrossbuchstabeUndMitZahl() {
		assertEquals("Pr�fung ohne Gro�buchstabe und mit Zahl fehlerhaft.", false, pwc.checkPassword("fhghjr9"));
	}
	
	public void testeOhneGrossuchstabeUndOhneZahl() {
		assertEquals("Pr�fung ohne Gro�buchstabe und ohne Zahl fehlerhaft.", false, pwc.checkPassword("fhghjr!"));
	}
	
	public void testeOhneKleinbuchstabe() {
		assertEquals("Pr�fung ohne Kleinbuchstabe fehlerhaft.", false, pwc.checkPassword("FHOFDB89"));
	}
	
	public void testeMitLeerzeichen() {
		assertEquals("Pr�fung mit Leerzeichen fehlerhaft.", false, pwc.checkPassword("fHJ8hg hjr!"));
	}
}

