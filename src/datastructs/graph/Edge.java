package datastructs.graph;

public class Edge {

	private Node leftNode = null;
	private Node rightNode = null;
	
	public Edge( Node leftNode, Node rightNode ) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public Node getLeft() {
		return leftNode;
	}
	
	public Node getRight() {
		return rightNode;
	}
}
