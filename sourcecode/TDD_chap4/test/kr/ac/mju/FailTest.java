package kr.ac.mju;

import static org.junit.Assert.fail;

import org.junit.Test;

public class FailTest {

	/*
	 * fail() : It causes an immediate test failure.
	 *  When you divide 3 by zero, it should generate arthmaticException. 
	 *  If it doesn¡¯t catch arithmeticException, this test will be failed.
	 */
	@Test
	public void testDivisionByZero() {
		try {
			int x = 3 / 0;
			fail("Division by zero didn't throw an exception.");
		} catch (ArithmeticException e) {
			// pass
		}
	}
}
