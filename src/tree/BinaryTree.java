package tree;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JFrame;

import parser.Calculator;

public class BinaryTree extends JFrame{
    
    private Node root;
    private Queue<Node> postFix;
    
    private final static int originalX = 300;
    private final static int originalY = 150;
    private final static int minimal_lever = 0;
    private final static int max_move = 80;
    
    public BinaryTree(Queue<Node> post) {
	
	super("Graphic");
	
	this.postFix = post;
	Stack<Node> nodeStack = new Stack<Node>();
	String str;
	Node newNode = null;
	
	while (!postFix.isEmpty()) {
	    newNode = postFix.peek();
	    str = newNode.getNode();
	    
	    if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
		newNode.setRight(nodeStack.pop());
		newNode.setLeft(nodeStack.pop());
	    } 
	    
	    nodeStack.push(newNode);
	    postFix.poll();
	}
	
	root = newNode;
	setPoint();
	
    }
    
    public boolean empty() {
	return root == null;
    }
    
    public void preOrder () {
	recursive_preOrder(root);
    }
    
    public void recursive_preOrder(Node root) {
	if (root != null) {
	    System.out.println(root);
	    recursive_preOrder(root.getLeft());
	    recursive_preOrder(root.getRight());
	}
    }
    
    public void setPoint() {
	Queue<Node> queue = new LinkedList<Node>();
	root.setX(originalX);
	root.setY(originalY);
	root.setLever(minimal_lever);
	
	queue.offer(root);
	BFS(queue);
    }
    
    public void BFS(Queue<Node> queue) {
	while (!queue.isEmpty()) {
	    
	    Node newNode = queue.poll();
	    Node nextNode;
	    
	    
		if (newNode.getLeft() != null) {
		    	nextNode = newNode.getLeft();
		    	nextNode.setLever(newNode.getLever()+1);
			nextNode.setX(newNode.getX()-(max_move-nextNode.getLever()*16));
			nextNode.setY(newNode.getY()+max_move);
			queue.offer(newNode.getLeft());
		}
		
		if (newNode.getRight() != null) {
		    	nextNode = newNode.getRight();
		    	nextNode.setLever(newNode.getLever()+1);
			nextNode.setX(newNode.getX()+(max_move-nextNode.getLever()*16));
			nextNode.setY(newNode.getY()+max_move);
			queue.offer(newNode.getRight());
		}
	    
	    
	}
    }
    
    public Node getRoot() {
	return root;
    }
    
//    public static void main(String argc[]) {
//	String exp= "1+2*3";
//	Calculator c = new Calculator(exp);
//	Queue<Node> token = c.getPostFix();
//	
//	System.out.println(c.process());
//	
//	BinaryTree btree = new BinaryTree(token);
//	
//	btree.preOrder();
	
//	 while (!token.isEmpty()) {
//    	      System.out.println(token.poll());
//    	  }
//    }
}
