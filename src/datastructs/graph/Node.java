package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name = null;
	private List<Edge> edges = null;
	// TODO add a numEdges counter
	//private 
	
	public Node( String name, int numEdges ) {
		this.name = name;
		this.edges = new ArrayList<>( numEdges );
	}

}
