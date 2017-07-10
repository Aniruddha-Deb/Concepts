package algorithms.sorting.sorts;

import algorithms.sorting.Sortable;
import util.IOUtils;

/**
 * Contains a program to sort an array of integers in Ascending order using 
 * the Insertion sort algorithm 
 */
public class InsertionSort implements Sortable {
	
	public static void main( String[] args ) {
		
		int[] arrayToSort = { 5, 4, 6, 2, 1, 3 };
		
		IOUtils.printArray( arrayToSort );
		
		new InsertionSort().sort( arrayToSort );
		
		IOUtils.printSortedArray( arrayToSort );
	}

	@Override
	public void sort( int[] array ){
		for( int i=1; i<array.length; i++ ) {
			int key = array[i];
			int j = i-1;
			while( j >= 0 && array[j] > key ) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}		
	}

	@Override
	public String getName(){
		return "Insertion Sort";
	}	
}
