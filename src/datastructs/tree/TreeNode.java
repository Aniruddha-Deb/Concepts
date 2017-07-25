package datastructs.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Serializable{
	
	private static final long serialVersionUID = -5046991069846257269L;
	
	private TreeNode parentNode = null;
	private List<TreeNode> childNodes = null;
	private String name = null;
	
	public TreeNode( TreeNode parentNode, String name ) {
		this.parentNode = parentNode;
		this.name = name;
		childNodes = new ArrayList<>();
	}
	
	public String getName(){
		return name;
	}
	
	public void setParentNode( TreeNode parentNode ) {
		this.parentNode = parentNode;
	}
	
	public TreeNode( String name ) {
		childNodes = new ArrayList<>();
		this.name = name;
	}
	
	public void addChildNodes( List<TreeNode> tNodes ) {
		if( tNodes.size() != 0 ) {
			childNodes.addAll( tNodes );
		}
	}
	
	public void addChildNode( TreeNode n ) {
		childNodes.add( n );
	}

	public TreeNode getParentNode(){
		return parentNode;
	}
	
	public List<TreeNode> getChildNodes(){
		return childNodes;
	}
}
