package Phone_Manager_Project;

import java.util.Scanner;

class PhoneInfo_2
{
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo_2(String _name,String _phoneNumber,String _birth)
	{
		this.name = _name;
		this.phoneNumber = _phoneNumber;
		this.birth = _birth;
	}
	public PhoneInfo_2(String _name,String _phoneNumber)
	{
		this.name = _name;
		this.phoneNumber = _phoneNumber;
	}
	public void showPhoneInfo()
	{
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
		
		if(birth != null)
		{
			System.out.println("birth : " + birth);
		}
		System.out.println("");
	}
	
}

public class PhoneBookVer02 {

	static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ���α׷� ����");
		System.out.println("���� : ");
	}
	
	public static void readData()
	{
		System.out.println("�̸� : ");
		String name = keyboard.nextLine();//������� ����
		
		System.out.println("��ȭ��ȣ : ");
		String phone = keyboard.nextLine();
		
		System.out.println("������� : ");
		String birth = keyboard.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phone,birth);
		System.out.println("\n�Էµ� ���� ���...");
		
		info.showPhoneInfo();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		
		while(true)
		{
			showMenu();
			choice = keyboard.nextInt();
			keyboard.nextLine();//buffer Flush
			
			switch(choice)
			{
			case 1:
				readData();
				break;
			case 2:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}
	}

}
