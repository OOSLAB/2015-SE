package kr.ac.mju;

import java.util.Enumeration;
import java.util.Vector;

public class MovieList extends Vector<Movie> {

	public MovieList (){
		super();
	}

	public Enumeration movies() {
		// TODO Auto-generated method stub
		return this.elements();
	}
}
