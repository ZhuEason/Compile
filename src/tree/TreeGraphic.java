package tree;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Queue;

import javax.swing.JFrame;

import parser.Calculator;

public class TreeGraphic extends BinaryTree {
    
    private final static int radius = 0;
    
    public TreeGraphic(Queue<Node> post) {
	super(post);

	setSize(600, 500);
	show();
    }
    
    public void paint(Graphics g) {
	g.setColor(Color.RED);
	g.setFont(new Font("SanSerif", Font.BOLD, 25));
	g.drawString("THE BINARY TREE OF THE EXPRESSION", 80, 80);
	g.setColor(Color.BLUE);
	recursive_preOrder(getRoot(), g);
    }
    
    public void recursive_preOrder(Node root, Graphics g) {
 	if (root != null) {
 	    g.drawString(root.getNode(), root.getX(), root.getY());
 	    if (root.getLeft() != null) {
 		g.drawLine(root.getX()-radius, root.getY()+radius, root.getLeft().getX()+radius, root.getLeft().getY()-radius);
 	    }
 	    if (root.getRight() != null) {
 		g.drawLine(root.getX()+radius, root.getY()+radius, root.getRight().getX()-radius, root.getRight().getY()-radius);
 	    }
 	    recursive_preOrder(root.getLeft(), g);
 	    recursive_preOrder(root.getRight(), g);
 	}
     }
    
//    public  static void main (String argc[]) {
//	String exp= "2+2.2*(3+5)";
//	Calculator c = new Calculator(exp);
//	Queue<Node> token = c.getPostFix();
//	
//	System.out.println(c.process());
//	
//	TreeGraphic btree = new TreeGraphic(token);
//	System.out.println("root: " + btree.getRoot());
//	
//	btree.preOrder();
//    }
    
}
