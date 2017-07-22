package datastructs.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	
	private TreeNode parentNode = null;
	private List<TreeNode> childNodes = null;
	private boolean navigated = false;
	
	public TreeNode( TreeNode parentNode ) {
		this.parentNode = parentNode;
		childNodes = new ArrayList<>();
	}
	
	public void toggleNavigated() {
		navigated = !navigated;
	}
	
	public boolean isNavigated() {
		return navigated;
	}
	
	void setNavigated( boolean navigated ) {
		navigated = false;
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
