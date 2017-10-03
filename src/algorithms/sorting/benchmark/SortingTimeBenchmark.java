package algorithms.sorting.benchmark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algorithms.sorting.Sortable;
import algorithms.sorting.sorts.BubbleSort;
import algorithms.sorting.sorts.InsertionSort;
import algorithms.sorting.sorts.SelectionSort;
import algorithms.sorting.sorts.quicksort.MultiThreadedQuickSort;
import algorithms.sorting.sorts.quicksort.SingleThreadedQuickSort;
import util.LargeArray;

public class SortingTimeBenchmark {
	
	static List<Sortable> sorts = new ArrayList<>();
	static {
		sorts.add( new InsertionSort() );
		sorts.add( new SelectionSort() );
		sorts.add( new BubbleSort() );
		sorts.add( new SingleThreadedQuickSort() );
		sorts.add( new MultiThreadedQuickSort() );
	}

	/**
	 * 
	 * For Ideal results, run with a stack size of 16M
	 */
	public static void main( String[] args ) throws IOException{

		int[] benchmarkArray = LargeArray.getArray();
		
		for( Sortable s : sorts ) {
			long startTimeInMillis = System.currentTimeMillis();
			s.sort( benchmarkArray );
			long endTimeInMillis = System.currentTimeMillis();
			long timeTaken = endTimeInMillis - startTimeInMillis;
			System.out.println( s.getName() + " = " + timeTaken + " ms" );
		}
	}
}
