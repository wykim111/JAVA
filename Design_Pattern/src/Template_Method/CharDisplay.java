package Template_Method;

public class CharDisplay extends AbstractDisplay {

	private char ch;
	
	public CharDisplay(char ch)
	{
		this.ch = ch;
	}
	
	public void open() {
		// TODO Auto-generated method stub
		System.out.print("<<");
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.print(ch);
	}

	public void close() {
		// TODO Auto-generated method stub
		System.out.println(">>");
	}
	
}
