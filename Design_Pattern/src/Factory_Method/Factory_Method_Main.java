package Factory_Method;
import framework.*;
import idcard.*;

public class Factory_Method_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("ȫ�浿");
		Product card2 = factory.create("�̼���");
		Product card3 = factory.create("������");
		
		card1.use();
		card2.use();
		card3.use();
	}

}
