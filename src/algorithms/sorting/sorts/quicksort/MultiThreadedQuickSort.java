package algorithms.sorting.sorts.quicksort;

import algorithms.sorting.Sortable;
import util.IOUtils;

public class MultiThreadedQuickSort implements Sortable{

	public static void main( String[] args ){
		
		int[] arrayToSort = { 5, 2, 6, 7, 1, 3 };
		
		IOUtils.printArray( arrayToSort );
		
		new MultiThreadedQuickSort().sort( arrayToSort, 0, arrayToSort.length-1 );
		
		IOUtils.printSortedArray( arrayToSort );
	}
	
	public void sort( int[] a ) {
		sort( a, 0, a.length-1 );
	}
	
	private void sort( int[] a, int low, int high ) {
		if( low < high ) {
			int pIndex = partition( a, low, high );
			
			new Thread( () -> sort( a, low, pIndex-1 ) ); 
			new Thread( () -> sort( a, pIndex+1, high ) ); 
		}
	}
	
	private int partition( int[] a, int low, int high ) {
		
		int pivot = a[high];
		int i = low-1;
		
		for( int j=low; j<high; j++ ) {
			if( a[j] <= pivot ) {
				i++;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		
		i++;
		int temp = a[i];
		a[i] = a[high];
		a[high] = temp;
		
		return i;
	}

	@Override
	public String getName(){
		return "Multi-Threaded Quick Sort";
	}
}
