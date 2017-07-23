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
		Graph G = new Graph();
		Node a = new Node( "A", 1 );
		Node b = new Node( "B", 3 );
		Node c = new Node( "C", 3 );
		Node d = new Node( "D", 3 );
		Node e = new Node( "E", 3 );
		Node f = new Node( "F", 3 );
		Node g = new Node( "G", 3 );
		Node h = new Node( "H", 5 );
		Node i = new Node( "I", 3 );
		Node j = new Node( "J", 3 );
		Node k = new Node( "K", 3 );
		Node l = new Node( "L", 3 );
		Node m = new Node( "M", 3 );
		Node n = new Node( "N", 3 );

		a.connect( b );
		b.connect( c );
		b.connect( d );
		d.connect( e );
		d.connect( f );
		e.connect( g );
		g.connect( l );
		f.connect( h );
		c.connect( i );
		c.connect( j );
		j.connect( k );
		j.connect( m );
		k.connect( n );
		
		G.addNode( a );
		G.addNode( b );

		Tree t = new Tree( G );
		System.out.println( "Created tree" );
		System.out.println( "Original: " );
		System.out.println( t.toString() );
		System.out.println( "Reverse: " );
		System.out.println( t.getReversedTree().toString() );
		System.out.println( "Num nodes: " + t.getNumNodes() );
		System.out.println( "Deepest level: " + t.getDeepestLevel() );
		System.out.println( "Longest path: " + t.getLongestPath() );
	}
}
