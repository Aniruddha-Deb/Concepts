package datastructs.tree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import datastructs.graph.Graph;
import datastructs.graph.Node;

public class Tree implements Serializable{
	
	private static final long serialVersionUID = 8951708210701233864L;
	private TreeNode rootNode = null;
	
	public Tree( Graph g ) {
		Node rn = g.getFirstNode();
		rootNode = new TreeNode( null, rn.getName() );
		for( Node n : rn.getRightNodes() ) {
			rootNode.addChildNode( getNode( n, rootNode ) );
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
	
	public int getNumNodes() {
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
		int deepestLevel = 0;
		for( TreeNode sn : n.getChildNodes() ) {
			TreeNode lowestNode = getDeepestNodeOf( sn );
			int len = getDeepestLevel( sn );
			if( len > deepestLevel ) {
				deepestNode = lowestNode;
				deepestLevel = len;
			}
		}
		return deepestNode;
	}
	
	public Tree getReversedTree() {
		Tree duplicate = this.getDuplicateTree();
		TreeNode root = getDeepestNodeOf( duplicate.getRootNode() );
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
	
	public Tree getDuplicateTree() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream( baos );
			oos.writeObject( this );
			oos.flush();
			
			ByteArrayInputStream bais = new ByteArrayInputStream( baos.toByteArray() );
			ObjectInputStream ois = new ObjectInputStream( bais );
			return (Tree)ois.readObject();
		} catch( Exception ex ) {
			return null;
		}
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
