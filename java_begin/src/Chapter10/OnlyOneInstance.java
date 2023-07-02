package Chapter10;

class SimpleNumber
{
	int num = 0;
	private SimpleNumber() {}
	public void addNum(int n) {num+=n;}
	public void showNum() {System.out.println(num);}
	
	//教臂沛 盔府
	//static栏肺 按眉 积己
	private static SimpleNumber snInst = null;
	
	public static SimpleNumber getSimpleNumberInst()
	{
		if(snInst != null)
		{
			return snInst;
		}
		
		
		return snInst = new SimpleNumber();
	}
}

public class OnlyOneInstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleNumber num1 = SimpleNumber.getSimpleNumberInst();
		num1.addNum(20);
		
		SimpleNumber num2 = SimpleNumber.getSimpleNumberInst();
		num1.addNum(30);
		
		num1.showNum();
		num2.showNum();
	}

}
