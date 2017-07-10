package algorithms.sorting.sorts.quicksort;

import java.io.IOException;

import algorithms.sorting.Sortable;
import util.IOUtils;

public class SingleThreadedQuickSort implements Sortable{
	
	public static void main( String[] args ) throws IOException{
		
		int[] arrayToSort = { 8, 7, 2, 4, 9, 7 };
		
		IOUtils.printArray( arrayToSort );
		
		new SingleThreadedQuickSort().sort( arrayToSort );
		
		IOUtils.printSortedArray( arrayToSort );
	}
	
	public void sort( int[] a ) {
		sort( a, 0, a.length-1 );
	}
		
	private void sort( int[] a, int low, int high ) {
		if( low < high ) {
			int pIndex = partition( a, low, high );
			
			sort( a, low, pIndex-1 );
			sort( a, pIndex+1, high );
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
		return "Single-Threaded Quick Sort";
	}
}
