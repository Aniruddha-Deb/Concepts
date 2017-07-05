package algorithms.searching;

import util.IOUtils;

public class LinearSearch {

	public static void main( String[] args ) {
		
		int[] a = { 7, 21, 55, 1, 2, 5, 13, 9, 4 };
		int element = 9;
		
		IOUtils.printArray( a );
		System.out.println( "To find element with value " + element );
		
		for( int i=0; i<a.length; i++ ) {
			if( a[i] == element ) {
				System.out.println( "Found element " + element + " At index " + i );
				System.exit( 42 );
			}
		}
		
		System.out.println( "Could not find element" );
	}
}
