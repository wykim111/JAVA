package Singleton_Pattern;

public class Singleton_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start.");
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2)
		{
			System.out.println("obj1�� obj2�� ���� �ν��Ͻ��Դϴ�.");
		}
		else
		{
			System.out.println("obj1�� obj2�� �ٸ� �ν��Ͻ��Դϴ�.");
		}
		
		System.out.println("End.");
	}

}
