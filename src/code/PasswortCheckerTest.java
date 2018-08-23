package code;
import junit.framework.TestCase;

public class PasswortCheckerTest extends TestCase {

	PasswordChecker pwc;
	
	public void setUp() {
		pwc = new PasswordChecker();
	}
	
	public void testeMitGrossuchstabeUndMitZahl() {
		assertEquals("Prüfung bei Großbuchstabe und Zahl fehlerhaft.", true, pwc.checkPassword("fhghjr9H"));
	}
	
	public void testeMitGrossuchstabeUndOhneZahl() {
		assertEquals("Prüfung mit Großbuchstabe und ohne Zahl fehlerhaft.", false, pwc.checkPassword("fhHhjr"));
	}
	
	public void testeOhneGrossbuchstabeUndMitZahl() {
		assertEquals("Prüfung ohne Großbuchstabe und mit Zahl fehlerhaft.", false, pwc.checkPassword("fhghjr9"));
	}
	
	public void testeOhneGrossuchstabeUndOhneZahl() {
		assertEquals("Prüfung ohne Großbuchstabe und ohne Zahl fehlerhaft.", false, pwc.checkPassword("fhghjr!"));
	}
	
	public void testeOhneKleinbuchstabe() {
		assertEquals("Prüfung ohne Kleinbuchstabe fehlerhaft.", false, pwc.checkPassword("FHOFDB89"));
	}
	
	public void testeMitLeerzeichen() {
		assertEquals("Prüfung mit Leerzeichen fehlerhaft.", false, pwc.checkPassword("fHJ8hg hjr!"));
	}
}

