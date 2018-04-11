package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl {
	
	class Node {
		List<Node> connectedNodes = null;
		int num = -1;
		
		public Node( int num ) {
			this.num = num;
			connectedNodes = new ArrayList<>();
		}
		
		public void add( Node n ) {
			connectedNodes.add( n );
		}
		
		@Override
		public String toString(){
			return num+"";
		}
	}
	
	class Graph {
		
		List<Node> aList = null;
		
		public Graph() {
			aList = new ArrayList<>();
		}

		public void add( Node n ) {
			aList.add( n );
		}
		
		public void connect( Node n1, Node n2 ) {
			aList.get( aList.indexOf( n1 ) ).add( n2 );
			aList.get( aList.indexOf( n2 ) ).add( n1 );
		}
		
		public void connect( int n1, int n2 ) {
			aList.get( n1 ).add( aList.get( n2 ) );
			aList.get( n2 ).add( aList.get( n1 ) );
		}

		List<String> traversedEdges = null;
		List<Node> traversedNodes = null;
		
		public void reset() {
			traversedEdges = new ArrayList<>();
			traversedNodes = new ArrayList<>();
		}
				
		private String strfy( Node n, int recLev ) {
			String s = "";
			
			for( int i=0; i<recLev; i++ ) {
				if( i == recLev - 1 ) {
					s += "└---";
				}
				else {
					s += "    ";
				}
			}
			s += n + "\n";
			traversedNodes.add( n );
	        recLev++;
	        for( Node x : n.connectedNodes ) {
	        	String e1 = x + "," + n;
	        	String e2 = n + "," + x;
	        	if( traversedEdges.contains( e1 ) || traversedEdges.contains( e2 ) ) {
	        		continue;
	        	}
	            traversedEdges.add( e1 );
	            traversedEdges.add( e2 );
	            s += strfy( x, recLev );
	        }
	        recLev--;
	        return s;
		}
		
		public String strfy() {
			reset();
			String s = "";
			for( Node n : aList ) 
				if( !traversedNodes.contains( n ) ) s += strfy( n, 0 );
			return s;
		}
		
		@Override
		public String toString(){
			return super.toString();
		}
	}
	
	void test() {
		Graph g = new Graph();
		for( int i=0; i<3; i++ ) {
			g.add( new Node( i ) );
		}
		g.connect( 0, 1 );
		g.connect( 1, 2 );
		g.connect( 2, 0 );
		
		System.out.println( g.strfy() );
	}

	public static void main( String[] args ){
		new GraphImpl().test();
	}
}
