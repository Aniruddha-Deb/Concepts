package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IOBenchmark {
	
	// object init

	static {
		try {
			System.setIn( new FileInputStream( new File( "res/array.txt" ) ) );
		} catch( FileNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	static Scanner sc = new Scanner( System.in );
	static FastIO io = new FastIO( System.in, System.out );
	
	public static void main( String[] args ) throws IOException {
		
		int tsize = 20000;
		long[] l = new long[tsize];
		long stime, etime;
				
		stime = System.currentTimeMillis();
		for( int i=0; i<tsize; i++ ) {
			char c;
			String s = "";
			while( (c=(char)br.read()) != ' ' ) {
				s += c;
			}
			l[i] = Long.parseLong( s );
		}
		etime = System.currentTimeMillis();
		System.out.println( "BufferedReader = " + (etime - stime) );
		
		stime = System.currentTimeMillis();
		for( int i=0; i<tsize; i++ ) {
			l[i] = Long.parseLong( io.ir.next() );
		}
		etime = System.currentTimeMillis();
		System.out.println( "FastIO = " + (etime - stime) );
		
		stime = System.currentTimeMillis();
		for( int i=0; i<tsize; i++ ) {
			l[i] = sc.nextLong();
		}
		etime = System.currentTimeMillis();
		System.out.println( "Scanner = " + (etime - stime) );
	}

}
