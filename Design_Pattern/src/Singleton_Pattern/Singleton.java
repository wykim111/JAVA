package Singleton_Pattern;

public class Singleton {
	private static Singleton singleton = new Singleton();
	
	private Singleton()
	{
		System.out.println("�ν��Ͻ��� �����Ͽ����ϴ�.");
	}
	
	public static Singleton getInstance()
	{
		return singleton;
	}
}
