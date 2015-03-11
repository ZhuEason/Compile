package parser;

import java.util.LinkedList;
import java.util.Queue;

import lexer.*;

public class Scanner {
    private Queue<Token> tokenStream;
    private int signCount;
    
    public Scanner(String exp) {
	tokenStream = new LinkedList<Token>();
	signCount = 0;
	setQueue(exp);
    }
    
    public void setQueue(String exp) {
	char ch;
	Token newToken;
	String num = "";
	
	for (int i = 0; i < exp.length(); i++) {
	    ch = exp.charAt(i);
	    num = "";
	    
	    while (  i < exp.length()  && ch == ' ') {
		i = i + 1;
		if (i < exp.length()) {
		    ch = exp.charAt(i);
		}
	    }
	    
	    while ( i < exp.length() && ((ch >= '0' && ch <= '9') || ch == '.')) {
		num += ch;
		i = i+1;
		if (i < exp.length()) {
		    ch = exp.charAt(i);
		}
	    }
	    
	    if (!num.equals("")) {
		newToken = new Num(num);
		tokenStream.offer(newToken);
	    }
	    
	    while ( i < exp.length() && ch == ' ') {
		i = i + 1;
		if (i < exp.length()) {
		    ch = exp.charAt(i);
		}
	    }
	    
	    switch (ch) {
	    case '+':
		tokenStream.offer(new Sign("+", Tag.PLUS));
		signCount++;
		break;
	    case '-':
		tokenStream.offer(new Sign("-", Tag.MINUS));
		signCount++;
		break;
	    case '*':
		tokenStream.offer(new Sign("*", Tag.MULTIPLY));
		signCount++;
		break;
	    case '/':
		tokenStream.offer(new Sign("/", Tag.DIVIDE));
		signCount++;
		break;
	    case '(' :
		tokenStream.offer(new Sign("(", Tag.LEFT_BRACKET));
		break;
	    case ')':
		tokenStream.offer(new Sign(")", Tag.RIGHT_BRACKET));
		break;
	    default:
		break;
	    }
	}
	
    }
    
    public Queue<Token> getToken() {
	    return tokenStream;
    }
    
    public int getSignCount() {
	return signCount;
    }
    
//    public static void main(String args[]) {
//    	  String exp= "123.3+4*(4+3)";
//    	  Scanner c = new Scanner(exp);
//    	  
//    	  Queue<Token> token = c.getToken();
//    	  
//    	  while (!token.isEmpty()) {
//    	      System.out.println(token.poll());
//    	  }
//    	  System.out.println("Num of sign: " + c.getSignCount());
//    }
}
