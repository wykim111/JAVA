package Phone_Manager_Project;

import java.util.Scanner;

class PhoneInfo_3
{
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo_3(String _name,String _phoneNumber,String _birth)
	{
		this.name = _name;
		this.phoneNumber = _phoneNumber;
		this.birth = _birth;
	}
	public PhoneInfo_3(String _name,String _phoneNumber)
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
class PhoneBookManager
{
	final int MAX_CNT = 100;
	PhoneInfo_3[] infoStorage = new PhoneInfo_3[MAX_CNT];
	int curCnt = 0;
	
	public void readData()
	{
		System.out.println("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();//������� ����
		
		System.out.println("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.println("������� : ");
		String birth = MenuViewer.keyboard.nextLine();
		
		infoStorage[curCnt] = new PhoneInfo_3(name, phone, birth);
		System.out.println("\n�Էµ� ���� ���...");
		curCnt++;
		
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
		
	}
	
	public void searchData()
	{
		System.out.println("������ �˻��� �����մϴ�...");
		System.out.println("�̸� : ");
		
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		
		if(dataIdx <= 0)
		{
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
		}
		else
		{
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n");
		}
	}
	
	//to do
	public void deleteData()
	{
		System.out.println("������ ������ �����մϴ�");
		
		System.out.print("�̸� : ");
		
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		
		if(dataIdx < 0)
		{
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
		}
		else
		{
			for(int idx = dataIdx;idx < curCnt-1;idx++)
			{
				infoStorage[idx] = infoStorage[idx+1];
			}
			
			curCnt--;
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	private int search(String name)
	{
		for(int idx = 0;idx < curCnt;idx++)
		{
			PhoneInfo_3 curInfo = infoStorage[idx];
			
			if(name.compareTo(curInfo.name) == 0)
				return idx;
		}
		
		return -1;
	}

}

class MenuViewer
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu()//static ��������
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		System.out.println("���� : ");
	}
}


public class PhoneBookVer03 {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		
		while(true)
		{
			MenuViewer.showMenu();
			choice = MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();
			
			switch(choice)
			{
			case 1://�Է�
				break;
			case 2://�˻�
				break;
				
			}
		}
	}

}
