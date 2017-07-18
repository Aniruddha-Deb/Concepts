package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name = null;
	private List<Edge> adjacentEdges = null;
	private int maxEdges = 0;
	
	public Node( String name, int maxEdges ) {
		this.name = name;
		this.adjacentEdges = new ArrayList<>();
		this.maxEdges = maxEdges;
	}

	/**
	 * By default, nodes are connected to the right of the current node.
	 */
	public void connect( Node n ){
		this.addEdge( new Edge( this, n ) );
		n.addEdge( new Edge( n, this ) );
	}
	
	private void addEdge( Edge e ) throws IllegalArgumentException {
		if( maxEdges < adjacentEdges.size()+1 ) {
			throw new IllegalArgumentException( "Node " + name + " is full." );
		}
		adjacentEdges.add( e );
	}
	
	public String getName() {
		return name;
	}
	
	public List<Edge> getEdges() {
		return adjacentEdges;
	}
	
	@Override
	public String toString(){
		String s = name;
		for( Edge e : adjacentEdges ) {
			if( e.getLeft().equals( this ) ) {
				s += "-" + e.getRight().getName();
			}
			else {
				s += "-" + e.getLeft().getName();				
			}
		}
		return s;
	}
}
