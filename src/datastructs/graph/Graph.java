package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

import datastructs.tree.Tree;

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
		Node n2 = new Node( "B", 3 );
		Node n3 = new Node( "C", 1 );
		Node n4 = new Node( "D", 2 );
		Node n5 = new Node( "E", 3 );
		Node n6 = new Node( "F", 1 );
		Node n7 = new Node( "G", 1 );

		n1.connect( n2 );
		n2.connect( n3 );
		n2.connect( n4 );
		n4.connect( n5 );
		n5.connect( n6 );
		n5.connect( n7 );
		
		g.addNode( n1 );
		g.addNode( n2 );
		g.addNode( n3 );

		Tree t = new Tree( g );
		System.out.println( t.toString() );
		System.out.println( "Created tree" );
	}
}
