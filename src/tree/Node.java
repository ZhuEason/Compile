package tree;

import lexer.Tag;

public class Node {
    private String node;
    private Node left;
    private Node right;
    private int x;
    private int y;
    private int lever;
    
    public Node(String node) {
	setNode(node);
	left = null;
	right = null;
    }
    
    public Node(int node) {
	setNode(node);
	left = null;
	right = null;
    }
    
    public void setNode(String node) {
	this.node = node;
    }
    
//    public void setNode(Double node) {
//	this.node = String.valueOf(node);
//    }
//    
    public void setNode(int node) {
	if (node == Tag.PLUS) {
	    this.node = "+";
	} else if (node == Tag.DIVIDE) {
	    this.node = "/";
	} else if (node == Tag.MINUS) {
	    this.node = "-";
	} else if (node == Tag.MULTIPLY) {
	    this.node = "*";
	}
    }
    
    public void setLeft(Node newLeft) {
	left = newLeft;
    }
    
    public void setRight(Node newRight) {
	right = newRight;
    }
    
    public void setX( int x) {
	this.x = x;
    }
    
    public void setY (int y) {
	this.y = y;
    }
    
    public void setLever(int newLever) {
	lever = newLever;
    }
    
    public int getX() {
	return x;
    }
    
    public int getY() {
	return y;
    }
    
    public String getNode() {
	return node;
    }
    
    public Node getLeft() {
	return left;
    }
    
    public Node getRight() {
	return right;
    }
    
    public int getLever() {
	return lever;
    }
    
    public String toString() {
	return node + " (" + x + "," + y + ")";
    }
}
