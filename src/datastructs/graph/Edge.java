package datastructs.graph;

public class Edge {

	private Node leftNode = null;
	private Node rightNode = null;

	public void addLeft( Node n ) {
		leftNode = n;
	}
	
	public void addRight( Node n ) {
		rightNode = n;
	}
	
	public Node getLeft() {
		return leftNode;
	}
	
	public Node getRight() {
		return rightNode;
	}
}
