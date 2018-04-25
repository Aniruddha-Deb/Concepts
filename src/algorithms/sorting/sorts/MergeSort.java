package algorithms.sorting.sorts;

import java.util.Arrays;

import algorithms.sorting.Sortable;

public class MergeSort implements Sortable{

	@Override
	public void sort( int[] a ){
		System.out.println( Arrays.toString( mergeSort( a, 0, a.length ) ) );
	}
	
	int[] mergeSort( int[] a, int p, int r ) {
		int[] retArr = new int[a.length];
		if( p < r ) {
			int q = (p+r)/2;
			int[] arr1 = mergeSort( a, p, q );
			int[] arr2 = mergeSort( a, q+1, r );
			int i = 0;
			for( ; i<arr1.length; i++ ) {
				retArr[i] = arr1[i];
			}
			int j = i-1;
			i=0;
			for( ; i<arr2.length; i++ ) {
				retArr[i+j] = arr2[i];
			}
		}
		else return new int[]{a[p]};
		return retArr;
	}

	@Override
	public String getName(){
		return "Merge Sort";
	}
	
	public static void main( String[] args ){
		new MergeSort().sort( new int[]{5, 2, 4, 6, 1, 3, 2, 6} );
	}

}
