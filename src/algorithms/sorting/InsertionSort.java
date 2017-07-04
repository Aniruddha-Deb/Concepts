package algorithms.sorting;

/**
 * Contains a program to sort an array of integers in Ascending order using 
 * the Insertion sort algorithm 
 */
public class InsertionSort {

	public static void main( String[] args ) {
		
		int[] arrayToSort = { 5, 4, 6, 2, 1, 3 };
		
		printArray( arrayToSort );
		
		for( int i=1; i<arrayToSort.length; i++ ) {
			int key = arrayToSort[i];
			int j = i-1;
			while( j >= 0 && arrayToSort[j] > key ) {
				arrayToSort[j+1] = arrayToSort[j];
				j--;
			}
			arrayToSort[j+1] = key;
		}
		
		System.out.print( "Sorted : " );
		printArray( arrayToSort );
	}
	
	static void printArray( int[] array ) {
		System.out.print( "[ " );
		for( int i=0; i<array.length; i++ ) {
			if( i == array.length - 1 ) {
				System.out.print( array[i] + " " );
			}
			else {
				System.out.print( array[i] + ", " );
			}
		}
		System.out.println( "]" );
	}
}
