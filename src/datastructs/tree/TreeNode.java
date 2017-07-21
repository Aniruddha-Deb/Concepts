package datastructs.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
	
	private TreeNode parentNode = null;
	private List<TreeNode> childNodes = null;
	
	public TreeNode( TreeNode parentNode ) {
		this.parentNode = parentNode;
		childNodes = new ArrayList<>();
	}
	
	public TreeNode() {
		childNodes = new ArrayList<>();
	}
	
	public void addNodes( List<TreeNode> tNodes ) {
		if( tNodes.size() != 0 ) {
			childNodes.addAll( tNodes );
		}
	}
	
	public void addNode( TreeNode n ) {
		childNodes.add( n );
	}

	public TreeNode getParentNode(){
		return parentNode;
	}
	
	public List<TreeNode> getChildNodes(){
		return childNodes;
	}
}
