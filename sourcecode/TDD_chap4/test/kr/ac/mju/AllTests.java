package kr.ac.mju;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({FailTest.class, MovieListTest.class})
public class AllTests {
	
	public static Test suiute(){
		TestSuite suite = new TestSuite("Test Suite");
		return suite;
	}
}
