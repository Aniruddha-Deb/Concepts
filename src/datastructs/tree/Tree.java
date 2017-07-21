package datastructs.tree;

import java.util.ArrayList;
import java.util.List;

import datastructs.graph.Graph;
import datastructs.graph.Node;

public class Tree {
	
	public TreeNode rootNode = null;	
	
	public Tree( Graph g ) {
		rootNode = new TreeNode();
		TreeNode parentSubNode = getNode( g.getNodes().get( 0 ), rootNode );
		rootNode.addNode( parentSubNode );
	}
	
	private TreeNode getNode( Node node, TreeNode parentNode ) {
		List<TreeNode> tNodes = new ArrayList<>();
		TreeNode parent = new TreeNode( parentNode );
		for( Node n : node.getRightNodes() ) {
			if( n.getRightNodes().size() == 0 ) {
				return parent;
			}
			else {
				System.out.println( "Adding node" );
				tNodes.add( getNode( n, parent ) );
			}
		}
		parent.addNodes( tNodes );
		return parent;
	}

	public int getLongestChain() {
		return getLongestChain( rootNode );
	}
	
	private int getLongestChain( TreeNode n ) {
		int longestChain = 0;
		
		return longestChain;
	}
	
}
