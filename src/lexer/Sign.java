package lexer;

public class Sign extends Token{
    
    private String value;
    
    public Sign(String value, int tag) {
	super(tag);
	this.value = value;
    }
    
    public String getValue() {
	return value;
    }
    
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
    
    public String toString() {
   	return super.toString() +" Sign: " + value ;
       }
}
