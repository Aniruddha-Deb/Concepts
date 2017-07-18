package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Node> nodes = null;
	
	public Graph() {
		nodes = new ArrayList<>();
	}
	
	public void addNode( Node n ) {
		nodes.add( n );
	}
	
	public List<Node> getNodes(){
		return nodes;
	}
	
	public static void main( String[] args ){
		Graph g = new Graph();
		Node n1 = new Node( "A", 1 );
		Node n2 = new Node( "B", 1 );
		Node n3 = new Node( "C", 1 );

		n1.connect( n2 );
		n2.connect( n3 );
		
		g.addNode( n1 );
		g.addNode( n2 );
		g.addNode( n3 );
		
		System.out.println( g.getNodes().toString() );
	}
}
