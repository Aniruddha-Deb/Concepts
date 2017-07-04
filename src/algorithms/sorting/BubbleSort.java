package algorithms.sorting;

import util.IOUtils;

/**
 * Contains a program to sort an array of integers in Ascending order using 
 * the Insertion sort algorithm 
 */
public class BubbleSort {

	public static void main( String[] args ) {

		int[] arrayToSort = { 5, 4, 6, 2, 1, 3 };
		
		IOUtils.printArray( arrayToSort );
		
		for( int i=0; i<arrayToSort.length; i++ ) {
			for( int j=0; j<arrayToSort.length-1-i; j++ ) {
				if( arrayToSort[j] > arrayToSort[j+1] ) {
					// swap the numbers with each other
					int temp = arrayToSort[j];
					arrayToSort[j] = arrayToSort[j+1];
					arrayToSort[j+1] = temp;
				}
			}
		}
		
		IOUtils.printSortedArray( arrayToSort );
	}
}
