package algorithms.sorting;

import util.IOUtils;

/**
 * Contains a program to sort an array of integers in Ascending order using 
 * the Selection sort algorithm 
 */
public class SelectionSort {

	public static void main( String[] args ) {

		int[] arrayToSort = { 5, 4, 6, 2, 1, 3 };
		
		IOUtils.printArray( arrayToSort );
		
		for( int i=0; i<arrayToSort.length; i++ ) {
			int index = i;
			for( int j=i+1; j<arrayToSort.length; j++ ) {
				if( arrayToSort[j] < arrayToSort[index] ) {
					index = j;
				}
			}
			
			int temp = arrayToSort[i];
			arrayToSort[i] = arrayToSort[index];
			arrayToSort[index] = temp;			
		}
		
		IOUtils.printSortedArray( arrayToSort );
	}
}
