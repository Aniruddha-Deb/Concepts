package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LargeArray {

	public static final File FILE = new File( "res/array.txt");
	public static final int ARRAY_SIZE = 100000;
	
	// used to generate the array.
	public static void main( String[] args ) throws Exception {

		FILE.createNewFile();
		PrintWriter writer = new PrintWriter( new FileOutputStream( FILE ) );

		for( int i=0; i<ARRAY_SIZE; i++ ) {
			int num = (int)(Math.random()*Integer.MAX_VALUE);
			writer.print( num + " " );
		}
		
		writer.close();
	}
	
	// used to retrieve the array 
	public static int[] getArray() throws IOException{
		Scanner sc = new Scanner( new FileInputStream( FILE ) );
		int[] array = new int[ARRAY_SIZE];
		for( int i=0; i<ARRAY_SIZE; i++ ) {
			array[i] = sc.nextInt();			
		}
		
		sc.close();
		return array;
	}
}
