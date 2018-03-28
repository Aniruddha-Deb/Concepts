package javalangfeatures.streams;

import java.util.Arrays;

import javalangfeatures.arrays.ArrayFeatures;

public class StreamFeatures {

	public static void main( String[] args ){
		
		// declaring an array which will be used as a test stream
		int[] a = new int[10];
		Arrays.setAll( a, i -> (int)(Math.random()*20) );
		ArrayFeatures.print( a, "A" );
		
		// A stream is immediately closed after being operated upon. Hence, 
		// streams should only be created if they are to be used.
		// The following statements would give an error:
		// IntStream s = Arrays.stream( a );
		// s.anyMatch( i -> i==9 )
		// s.allMatch( i -> i>4 ) -- error here as stream is closed
		
		// match examples
		// checking if any element matches 9
		System.out.println( Arrays.stream( a ).anyMatch( i -> i==9 ) );
		// checking if all elements are greater than 4
		System.out.println( Arrays.stream( a ).allMatch( i -> i>4 ) );
		// checking if none of the elements match 6
		System.out.println( Arrays.stream( a ).noneMatch( i -> i==6 ) );
		
		// returns the count of all elements in the stream
		// this is usually used when reading from an input stream or the like
		// an easier option is to use the size() method in a list or other data 
		// structure or use the length variable in an array
		System.out.println( Arrays.stream( a ).count() );
	}
}
