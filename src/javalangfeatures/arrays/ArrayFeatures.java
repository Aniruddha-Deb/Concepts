package javalangfeatures.arrays;

import java.util.Arrays;

public class ArrayFeatures {
	
	public static void main( String[] args ){
		
		// initializing a few arrays to play around with
		int[] a = new int[10];
		int[] b = new int[10];
		int[] c = new int[10];
		int[] d = new int[10];
 				
		// filling an array using fill()
		Arrays.fill( a, 0 );
		print( a, "A" );
		
		// generating the first 10 natural numbers using setAll()
		// i is the index of the element whose value is to be set
		Arrays.setAll( b, i -> i+1 );
		print( b, "B" ); 
		
		// random filling arrays c and d
		Arrays.setAll( c, i -> (int)(Math.random()*20) );		
		Arrays.setAll( d, i -> (int)(Math.random()*20) );
		print( c, "C" );
		print( d, "D" );
		
		// sorting array c
		// The sort implementation in java is a dual pivot quicksort
		Arrays.sort( c );
		print( c, "Sorted C" );
		
		// sorting array d using parallel sort
		// this is a divide and conquer sort
		Arrays.parallelSort( d );
		print( d, "Sorted D" );
		
		// binary searching '5' in array b
		int index = Arrays.binarySearch( b, 5 );
		System.out.println( "Index of 5 in b: " + index );
	}
	
	public static void print( int[] a, String name ) {
		// printing an array using a stream (further explained in the stream 
		// features class
		System.out.print( name + ": " );
		Arrays.stream( a ).forEach( i -> System.out.print( i+", " ) );
		System.out.println();
	}
}
