package Singleton_Pattern;

public class Singleton_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start.");
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2)
		{
			System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
		}
		else
		{
			System.out.println("obj1과 obj2는 다른 인스턴스입니다.");
		}
		
		System.out.println("End.");
	}

}
