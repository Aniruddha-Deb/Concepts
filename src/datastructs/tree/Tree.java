package datastructs.tree;

import java.util.ArrayList;
import java.util.List;

import datastructs.graph.Graph;
import datastructs.graph.Node;

public class Tree {
	
	private TreeNode rootNode = null;
	
	public Tree( Graph g ) {
		rootNode = new TreeNode( g.getNodes().get( 0 ).getName() );
		if( g.getNodes().size() > 1 ) {
			TreeNode parentSubNode = getNode( g.getNodes().get( 1 ), rootNode );
			rootNode.addChildNode( parentSubNode );
		}
	}
	
	private Tree( TreeNode root ) {
		rootNode = root;
	}
	
	private TreeNode getNode( Node node, TreeNode parentNode ) {
		
		List<TreeNode> childNodes = new ArrayList<>();
		TreeNode parent = new TreeNode( parentNode, node.getName() );
		
		if( node.getRightNodes().size() == 0 ) {
			return parent;
		}
		
		for( Node n : node.getRightNodes() ) {
			TreeNode sn = getNode( n, parent );
			if( sn != null ) {
				childNodes.add( sn );
			}
		}
		parent.addChildNodes( childNodes );
		
		return parent;
	}
	
	private void setUnexplored( TreeNode n ) {
		if( n.getChildNodes().isEmpty() ) {
			n.setNavigated( false );
		}
		else {
			for( TreeNode subNode : n.getChildNodes() ) {
				setUnexplored( subNode );
			}
		}
	}

	public int getNumNodes() {
		setUnexplored( rootNode );
		return getNumChildNodes( rootNode );
	}

	private int getNumChildNodes( TreeNode n ) {
		int numNodes = 1;
		for( TreeNode sn : n.getChildNodes() ) {
			numNodes += getNumChildNodes( sn );
		}
		return numNodes;
	}
	
	public TreeNode getRootNode(){
		return rootNode;
	}
	
	public int getDeepestLevel() {
		return getDeepestLevel( rootNode );
	}
	
	private int getDeepestLevel( TreeNode n ) {
		int deepestLevel = 1;
		int longestChain = 0;
		for( TreeNode sn : n.getChildNodes() ) {
			int snLength = getDeepestLevel( sn );
			if( snLength > longestChain ) {
				longestChain = snLength;
			}
		}
		return deepestLevel+longestChain;
	}
	
	private TreeNode getDeepestNodeOf( TreeNode n ) {
		TreeNode deepestNode = n;
		for( TreeNode sn : n.getChildNodes() ) {
			deepestNode = getDeepestNodeOf( sn );
		}
		return deepestNode;
	}
	
	public Tree getReversedTree() {
		TreeNode root = getDeepestNodeOf( rootNode );
		TreeNode revRoot = reverseTree( root, null );
		return new Tree( revRoot );
	}
	
	private TreeNode reverseTree( TreeNode rootNode, TreeNode parent ) {
		if( rootNode.getParentNode() != null ) {			
			rootNode.getParentNode().getChildNodes().remove( rootNode );
			rootNode.addChildNode( reverseTree( rootNode.getParentNode(), rootNode ) );
		}
		rootNode.setParentNode( parent );
		return rootNode;
	}
	
	public int getLongestPath() {
		int p1 = this.getDeepestLevel();
		int p2 = this.getReversedTree().getDeepestLevel();
		return p1 > p2 ? p1 : p2;
	}
	
	@Override
	public String toString(){
		return getNodesAsString( rootNode, 0 );
	}
	
	private String getNodesAsString( TreeNode parentNode, int recLev ) {
		
		String s = "";
		
		for( int i=0; i<recLev; i++ ) {
			if( i == recLev - 1 ) {
				s += "└---";
			}
			else {
				s += "    ";
			}
		}
		s += parentNode.getName() + "\n";
        recLev++;
        for( TreeNode n : parentNode.getChildNodes() ) {
            s += getNodesAsString( n, recLev );
        }
        recLev--;
        return s;
	}
}
