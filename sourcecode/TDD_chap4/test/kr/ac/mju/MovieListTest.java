package kr.ac.mju;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Enumeration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieListTest {

	private Movie starWars, stargate, starTrek;
	private MovieList emptyList, scifiList;

	@Before
	public void setUp() {
		starWars = new Movie();
		stargate = new Movie();
		starTrek = new Movie();
		emptyList = new MovieList();
		scifiList = new MovieList();
		scifiList.addElement(starWars);
		scifiList.addElement(stargate);
		scifiList.addElement(starTrek);
	}

	@After
	public void tearDown() {
		starWars = null;
		stargate = null;
		starTrek = null;
		emptyList = null;
		scifiList = null;
	}

	/*
	 * This is the assertTrue and assertFalse. 
	 * This method has a parameter which data type is boolean. 
	 * assertTrue() : if the parameter is true, the test will succeed.
	 * assertFalse() : if the parameter is false, the test will succeed.
	 */
	@Test
	public void testEmptyList() {
		emptyList = new MovieList();
		
		assertTrue("An empty list should report empty", emptyList.isEmpty());
		Enumeration emptyEnumerator = emptyList.movies();
		assertFalse("Empty list should have empty Enumeration",
				emptyEnumerator.hasMoreElements());
	}

  	/*
	 * assertNotNull : if the parameter is null, the test will be failed.
	 */
	@Test
	public void testEmptyListEnumberation() {
		emptyList = new MovieList();
		Enumeration emptyEnumerator = emptyList.movies();
		assertNotNull("Empty list should have non-null Enumeration",
				emptyEnumerator);
	}

	/*
	 * assertSame : if two parameters are same object, the test will succeed.
	 */
	@Test
	public void testIteration() {
		scifiList = new MovieList();
		Enumeration threeMovieEnumerator = scifiList.movies();

		starWars = new Movie();
		stargate = new Movie();
		starTrek = new Movie();
		scifiList.addElement(starWars);
		scifiList.addElement(stargate);
		scifiList.addElement(starTrek);

		assertSame("First movie from threeMovieEnumerator is bad", starWars,
				(Movie) threeMovieEnumerator.nextElement());
		assertSame("First movie from threeMovieEnumerator is bad", stargate,
				(Movie) threeMovieEnumerator.nextElement());
		assertSame("First movie from threeMovieEnumerator is bad", starTrek,
				(Movie) threeMovieEnumerator.nextElement());
	}

	/*
	 * In contrast with assertSame method,
	 * assertEquals : if two parameters have same value regardless same object, 
	 * the test will succeed.
	 */
	@Test
	public void testRemoving() {
		assertEquals("Bad inital size", 3, scifiList.size());
		scifiList.remove(starWars);
		assertEquals("Bad size after removing the first movie", 2,
				scifiList.size());
	}
	
	/* It is important to understand the difference between assertSame and assertEquals.
	 * The former passes only when the two objects being compared are the same object.
	 * Make sure you understand that the same object
	 */
}
