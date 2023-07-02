package Phone_Manager_Project;

import java.util.Scanner;

interface INIT_MENU_06
{
	int INPUT=1, SEARCH=2, DELETE = 3,EXIT=4;
}

interface INPUT_SELECT_06
{
	int NORMAL=1,UNIV=2, COMPANY=3;
}

class MenuChoiceException extends Exception
{
	int wrongChoice;
	
	public MenuChoiceException(int choice)
	{
		super("�߸��� ������ �̷������ϴ�.");
		wrongChoice = choice;
	}
	public void showWrongChoice()
	{
		System.out.println(wrongChoice + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
	}
}

class PhoneInfo_06
{
	String name;
	String phoneNumber;
	
	public PhoneInfo_06(String name,String num)
	{
		this.name = name;
		phoneNumber = num;
	}
	public void showPhoneInfo()
	{
		System.out.println("name :" + name);
		System.out.println("phone :" + phoneNumber);
	}
}

class PhoneUnivInfo_06 extends PhoneInfo_06
{
	String major;
	int year;

	public PhoneUnivInfo_06(String _name, String _phoneNumber,String major,int year) {
		super(_name, _phoneNumber);
		this.major = major;
		this.year = year;
		
	}
	
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("major : " + major);
		System.out.println("year : " + year);
	}
	
}

class PhoneCompanyInfo_06 extends PhoneInfo_06
{
	String company;
	
	// TODO Auto-generated constructor stub
	public PhoneCompanyInfo_06(String name, String num, String company)
	{
		super(name,num);
		this.company = company;
	}

	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("company : "+ company);
	}
	
}

class PhoneBookManeger_06
{
	final int MAX_CNT = 100;
	PhoneInfo_06[] infoStorage = new PhoneInfo_06[MAX_CNT];
	int cur_cnt = 0;
	
	static PhoneBookManeger_06 inst = null;
	
	//�̱��� ����
	public static PhoneBookManeger_06 createManagerInst()
	{
		if(inst == null)
		{
			inst = new PhoneBookManeger_06();
		}
		return inst;
	}
	
	private PhoneBookManeger_06() {}
	
	private PhoneInfo_06 readFriendInfo()
	{
		System.out.print("�̸� : ");
		String name = MenuViewer_06.keyboard.nextLine();
		
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer_06.keyboard.nextLine();
		
		return new PhoneInfo_06(name, phone);
	}
	
	private PhoneInfo_06 readUnivFriendInfo()
	{
		System.out.print("�̸� : ");
		String name = MenuViewer_06.keyboard.nextLine();
		
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.print("���� : ");
		String major = MenuViewer.keyboard.nextLine();
		
		System.out.print("�г� : ");
		int year = MenuViewer_06.keyboard.nextInt();
		
		return new PhoneUnivInfo_06(name, phone,major,year);
		
	}
	
	private PhoneInfo_06 readCompanyFriendInfo()
	{
		System.out.print("�̸� : ");
		String name = MenuViewer_06.keyboard.nextLine();
		
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.print("ȸ�� : ");
		String company = MenuViewer.keyboard.nextLine();
		
		
		return new PhoneCompanyInfo_06(name, phone,company);
		
	}
	
	public void inputData() throws MenuChoiceException
	{
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ�, 2. ����,3. ȸ��");
		System.out.print("���� >>");
		
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo_06 info = null;
		
		if(choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);
		
		
		switch(choice)
		{
		case INPUT_SELECT.NORMAL:
			info = readFriendInfo();
			break;
		case INPUT_SELECT.UNIV:
			info = readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY:
			info = readCompanyFriendInfo();
			break;
		}
		infoStorage[cur_cnt++] = info;
		System.out.println("������ �Է��� �Ϸ� �Ǿ����ϴ�.");
	}
	
	
	public void searchData()
	{
		System.out.println("������ �˻��� �����մϴ�...");
		System.out.print("�̸� : ");
		
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		
		if(dataIdx < 0)
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
			for(int idx = dataIdx;idx < cur_cnt-1;idx++)
			{
				infoStorage[idx] = infoStorage[idx+1];
			}
			
			cur_cnt--;
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	private int search(String name)
	{
		for(int idx = 0;idx < cur_cnt;idx++)
		{
			PhoneInfo_06 curInfo = infoStorage[idx];
			
			if(name.compareTo(curInfo.name) == 0)
				return idx;
		}
		
		return -1;
	}
}

class MenuViewer_06
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu()//static ��������
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		System.out.print("���� : ");
	}
}

public class PhoneBookVer06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SingleTone Pattern ����
		PhoneBookManeger_06 manager = PhoneBookManeger_06.createManagerInst();
		int choice;
		
		while(true)
		{
			try
			{
				MenuViewer_06.showMenu();
				choice = MenuViewer_06.keyboard.nextInt();
				MenuViewer_06.keyboard.nextLine();
				
				if(choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT)
				{
					throw new MenuChoiceException(choice);
				}
				
				switch(choice)
				{
				case INIT_MENU.INPUT://�Է�
					manager.inputData();
					break;
				case INIT_MENU.SEARCH://�˻�
					manager.searchData();
					break;
				case INIT_MENU.DELETE://����
					manager.deleteData();
					break;
				case INIT_MENU.EXIT:
					System.out.println("���α׷��� �����մϴ�.");
					return;
				}
			}
			catch(MenuChoiceException e)
			{
				e.showWrongChoice();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.");
			}
		}

	}

}
