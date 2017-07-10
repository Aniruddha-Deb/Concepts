package algorithms.sorting.sorts;

import algorithms.sorting.Sortable;
import util.IOUtils;

/**
 * Contains a program to sort an array of integers in Ascending order using 
 * the Bubble sort algorithm 
 */
public class BubbleSort implements Sortable{

	public static void main( String[] args ) {

		int[] arrayToSort = { 5, 4, 6, 2, 1, 3 };
		
		IOUtils.printArray( arrayToSort );
		
		new BubbleSort().sort( arrayToSort );
		
		IOUtils.printSortedArray( arrayToSort );
	}
	
	@Override
	public void sort( int[] array ) {
		for( int i=0; i<array.length; i++ ) {
			for( int j=0; j<array.length-1-i; j++ ) {
				if( array[j] > array[j+1] ) {
					// swap the numbers with each other
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	@Override
	public String getName(){
		return "Bubble Sort";
	}
}
