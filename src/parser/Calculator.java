package parser;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import lexer.*;
import tree.Node;

public class Calculator extends Scanner {
    
    private Stack<Double> num;
    private Stack<Integer> sign;
    private Queue<Token> tokenStream;
    private Queue<Node> postFix;
    
    public Calculator(String exp) {
	super(exp);
	new String("");
	num = new Stack<Double>();
	sign = new Stack<Integer>();
	tokenStream = super.getToken();
	postFix = new LinkedList<Node>();
    }
    
    public String process() {
	double number;
	Token token;
	
	while ( !tokenStream.isEmpty()) {
	    token = tokenStream.poll();
	   
	    if  (token.getTag() == Tag.NUM) {
		number = Double.parseDouble(token.getValue());
		num.push(number);
		postFix.offer(new Node(token.getValue()));
	    } else {
		//when next token is a sign
		if ( sign.isEmpty() || (Token.getPriority(token.getTag()) > Token.getPriority(sign.peek())) || sign.peek().equals(Tag.LEFT_BRACKET) || token.getTag() == Tag.LEFT_BRACKET) {
		    sign.push(token.getTag());
		} else if (token.getTag() == Tag.RIGHT_BRACKET){
		    processBracket();
		} else if (Token.getPriority(token.getTag()) <= Token.getPriority(sign.peek())) {
		    postFix.offer(new Node(sign.peek()));
		    calculate();
		    sign.push(token.getTag());
		}
	    }
	}
	
	while (num.size() >= 2) {
	    postFix.offer(new Node(sign.peek()));
	    calculate();
	}
	
	DecimalFormat df1 = new DecimalFormat(".000");
	
	return df1.format(num.peek());
    }
    
	public void processBracket() {
	        while ( !sign.isEmpty() && !sign.peek().equals(Tag. LEFT_BRACKET)) {
	            postFix.offer(new Node(sign.peek()));
		    calculate();
		}
		if (sign.peek().equals(Tag.LEFT_BRACKET) ) {
		    sign.pop();
		}
	 }
	
	 public void calculate() {
	     	
		if ( num.size() >= 2) {
		    double temp1 = num.pop();
		    double temp2 = num.pop();
		    double result = 0;
		    
		    		    
		    int topSign = sign.pop();
		    
		    
		    switch (topSign) {
		    	case Tag.PLUS:
		    	    result = temp2 + temp1;
		    	    break;
		    	case Tag.MINUS:
		    	    result = temp2 - temp1;
		    	    break;
		    	case Tag.MULTIPLY:
		    	    result = temp2 * temp1;
		    	    break;
		    	case Tag.DIVIDE:
		    	    result = temp2 / temp1;
		    	    break;
		    }
		    num.push(result);
		} else {
		    System.out.println("85error");
		}
	 }
	 
	public Queue<Node> getPostFix() {
	    return postFix;
	}
	 
    
//    public static void main(String argc[]) {
//	String exp= "(1+2)*(3-2.9*2)";
//	Calculator c = new Calculator(exp);
//	Queue<Node> token = c.getPostFix();
//	
//	System.out.println(c.process());
//	
//	
//	
//	 while (!token.isEmpty()) {
//    	      System.out.println(token.poll());
//    	  }
//    }
    
}
