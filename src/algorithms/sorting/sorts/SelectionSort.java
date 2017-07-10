package algorithms.sorting.sorts;

import algorithms.sorting.Sortable;
import util.IOUtils;

/**
 * Contains a program to sort an array of integers in Ascending order using 
 * the Selection sort algorithm 
 */
public class SelectionSort implements Sortable{

	public static void main( String[] args ) {

		int[] arrayToSort = { 5, 4, 6, 2, 1, 3 };
		
		IOUtils.printArray( arrayToSort );
		
		new SelectionSort().sort( arrayToSort );
		
		IOUtils.printSortedArray( arrayToSort );
	}

	@Override
	public void sort( int[] a ){
		
		for( int i=0; i<a.length; i++ ) {
			int index = i;
			for( int j=i+1; j<a.length; j++ ) {
				if( a[j] < a[index] ) {
					index = j;
				}
			}
			
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;			
		}
				
	}

	@Override
	public String getName(){
		return "Selection Sort";
	}
}
