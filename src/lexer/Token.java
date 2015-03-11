package lexer;

public abstract class Token {
    	protected int tag;
    	
    	public Token(int tag) {
    	    this.tag = tag;
    	}
    	
    	public int getTag() {
    	    return tag;
    	}
    	
    	public String toString() {
    	    return "tag: " + tag;
    	}
    	
    	public abstract String getValue();

        public static int getPriority(int tag) {
  	  switch(tag) {
  	  case Tag.PLUS:
  	      return 1;
  	  case Tag.MINUS:
  	      return 1;
  	  case Tag.MULTIPLY:
  	      return 2;
  	  case Tag.DIVIDE:
  	      return 2;
  	  case Tag.LEFT_BRACKET:
  	      return 3;
  	  case Tag.RIGHT_BRACKET:
  	      return 0; 
  	  default:
  	      return -1;
  	  }
      }
}
