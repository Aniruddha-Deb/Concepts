package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

import datastructs.tree.Tree;

public class Graph {
	
	private Node firstNode = null;
	
	public Graph( Node firstNode ) {
		this.firstNode = firstNode;
	}
	
	public Node getFirstNode() {
		return firstNode;
	}
	
	public void addNodeTo( String nodeName, Node rightNode ) {
		addNodeTo( firstNode, nodeName, rightNode );
	}
	
	private void addNodeTo( Node root, String nodeName, Node rightNode ) {
		if( root.getName().equals( nodeName ) ) {
			root.connect( rightNode );
		}
		for( Node n : root.getRightNodes() ) {
			addNodeTo( n, nodeName, rightNode );
		}			
	}
 	
	public static void main( String[] args ){
		Graph G = new Graph( new Node( "X", 3 ) );
		Node a = new Node( "A", 1 );
		Node b = new Node( "B", 4 );
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
		Node o = new Node( "O", 3 );
		Node p = new Node( "P", 3 );
		Node q = new Node( "Q", 3 );
		Node r = new Node( "R", 3 );
		Node s = new Node( "S", 3 );

		G.addNodeTo( "X", a );
		G.addNodeTo( "X", b );
		G.addNodeTo( "B", c );
		G.addNodeTo( "C", d );
		G.addNodeTo( "C", e );
		
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
