package algorithms.searching;

import util.IOUtils;

public class BinarySearch {

	public static void main( String[] args ) {
		
		// Note that the array needs to be sorted. If raw, unsorted data is given, 
		// then it should be sorted with a sorting algorithm like insertion or 
		// merge sort
		int[] a = { 1, 2, 4, 5, 7, 9, 13, 21, 55 };
		int element = 9;
		
		IOUtils.printArray( a );
		System.out.println( "To find element with value " + element );
		
		int upper = a.length;
		int lower = 0;

		do {
			int mid = (upper+lower)/2;
			if( a[mid] == element ) {
				System.out.println( "Found element " + element + " At index " + mid );
				System.exit( 42 );
			}
			else if( a[mid] > element ) {
				upper = mid-1;
			}
			else {
				lower = mid+1;
			}			
		} while( lower <= upper );
		
		System.out.println( "Could not find element" );
	}
}
