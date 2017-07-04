package util;

public class IOUtils {
	
	public static void printSortedArray( int[] array ) {
		System.out.print( "Sorted : " );
		printArray( array );
	}
	
	public static void printArray( int[] array ) {
		System.out.print( "[ " );
		for( int i=0; i<array.length; i++ ) {
			if( i == array.length - 1 ) {
				System.out.print( array[i] + " " );
			}
			else {
				System.out.print( array[i] + ", " );
			}
		}
		System.out.println( "]" );
	}

}
