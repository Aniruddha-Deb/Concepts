package datastructs.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Node> nodes = null;
	
	public Graph() {
		nodes = new ArrayList<>();
	}
	
	public List<Node> getNodes(){
		return nodes;
	}
	
	public static void main( String[] args ){
		Graph g = new Graph();
		g.getNodes().add( new Node( "C" ) );
	}
}
