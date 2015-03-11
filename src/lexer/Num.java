package lexer;

public class Num extends Token{
    private String value;
    
    public Num(String exp) {
	super(Tag.NUM);
	setNum(exp);
    }
    
    public void setNum(String str) {
	this.value = str;
    }
    
    public String getValue() {
	return value;
    }
    
    
    public String toString() {
	return super.toString() +" num: " + value;
    }
}
