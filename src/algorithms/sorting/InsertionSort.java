package algorithms.sorting;

import util.IOUtils;

/**
 * Contains a program to sort an array of integers in Ascending order using 
 * the Insertion sort algorithm 
 */
public class InsertionSort {

	public static void main( String[] args ) {
		
		int[] arrayToSort = { 5, 4, 6, 2, 1, 3 };
		
		IOUtils.printArray( arrayToSort );
		
		for( int i=1; i<arrayToSort.length; i++ ) {
			int key = arrayToSort[i];
			int j = i-1;
			while( j >= 0 && arrayToSort[j] > key ) {
				arrayToSort[j+1] = arrayToSort[j];
				j--;
			}
			arrayToSort[j+1] = key;
		}
		
		IOUtils.printSortedArray( arrayToSort );
	}	
}
