package interaction;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import parser.*;
import tree.BinaryTree;
import tree.Node;
import tree.TreeGraphic;

public class UI extends JFrame{
    private  Calculator cal;
    private JTextField inputField, resultField;
    
    public UI() {
	
	super("Calculator UI");

	Container c = getContentPane();
	c.setLayout(new FlowLayout());
	

	
	inputField = new JTextField(10);
	inputField.addActionListener( new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cal = new Calculator(e.getActionCommand());
		resultField.setText(cal.process());
		Queue<Node> token = cal.getPostFix();
		TreeGraphic btree = new TreeGraphic(token);
	    }
	});
	
	c.add(inputField);
	
	resultField = new JTextField(10);
	resultField.setEditable(false);
	c.add(resultField);
	
	setSize(400, 100);
	show();
    }
    
    public static void main(String args[]) {
	UI window = new UI();
	
	window.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
		System.exit(0);
	    }
	});;
    }
}
