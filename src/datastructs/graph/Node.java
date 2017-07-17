package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name = null;
	private List<Edge> edges = null;
	
	public Node( String name ) {
		this.name = name;
		this.edges = new ArrayList<>();
	}
	
	public void addEdge( Edge e ) {
		edges.add( e );
	}
	
	public String getName() {
		return name;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
}
