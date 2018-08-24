package app;
import junit.framework.TestCase;

public class PasswortCheckerTest extends TestCase {

	PasswordChecker pwc;
	
	public void setUp() {
		pwc = new PasswordChecker();
	}
	
	public void testUpperCase() {
		assertEquals("Test with upper case failed.", true, pwc.checkPassword(new char[] {'f','g', 'H','9','z','u', 'o', 'p'}));
		assertEquals("Test without upper case failed.", false, pwc.checkPassword(new char[] {'f','g', 'h','9','z','u', 'o', 'p'}));
		assertEquals("Test with upper case failed.", true, pwc.checkPassword(new char[] {'f','g', 'h','9','z','u', 'o', 'Q'}));
	}
	
	public void testDigit() {
		assertEquals("Test with digit failed.", true, pwc.checkPassword(new char[] {'f','g', 'H','9','z','U', 'o', 'p'}));
		assertEquals("Test without digit failed.", false, pwc.checkPassword(new char[] {'f','g', 'H','i','z','U', 'o', 'p'}));
		assertEquals("Test with digit failed.", true, pwc.checkPassword(new char[] {'f','g', 'H','c','z','U', 'o', '3'}));
	}
	
	public void testLowerCase() {
		assertEquals("Test without lower case failed.", false, pwc.checkPassword(new char[] {'H','G', '9','P','Z','U', 'L', 'W'}));
		assertEquals("Test with lower case failed.", true, pwc.checkPassword(new char[] {'H','G', '9','P','Z','U', 'L', 'w'}));

	}
	
	public void testSpace() {
		assertEquals("Test without space failed.", true, pwc.checkPassword(new char[] {'H','h','H','9','Z','U', 'L', 'W'}));
		assertEquals("Test with space failed.", false, pwc.checkPassword(new char[] {'H','h', ' ','9','Z','o', 'L', 'W'}));

	}
	
	public void testLength() {
		assertEquals("Testing lenght = 0 failed.", false, pwc.checkPassword(new char[] {}));
		assertEquals("Testing lenght = 2 failed.", false, pwc.checkPassword(new char[] {'H','h'}));
		assertEquals("Testing lenght = 7 failed.", false, pwc.checkPassword(new char[] {'H','h','9','Z','U','u','p'}));
		assertEquals("Testing lenght = 8 failed.", true, pwc.checkPassword(new char[] {'H','o','h','9','Z','U','u','p'}));
		assertEquals("Testing lenght = 15 failed.", true, pwc.checkPassword(new char[] {'H','o','h','9','Z','U','u','p', 'U','u','p','i','6', '5', '5'}));
		assertEquals("Testing lenght = 16 failed.", true, pwc.checkPassword(new char[] {'8', 'H','o','h','9','Z','U','u','p', 'U','u','p','i','6', '5', '5'}));
		assertEquals("Testing lenght = 17 failed.", false, pwc.checkPassword(new char[] {'8', 'H','o','h','9','Z','U','u','p', 'U','u','p','i','6', '5', '5', 'p'}));
	}
}

