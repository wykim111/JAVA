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
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice = choice;
	}
	public void showWrongChoice()
	{
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
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
	
	//싱글톤 패턴
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
		System.out.print("이름 : ");
		String name = MenuViewer_06.keyboard.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = MenuViewer_06.keyboard.nextLine();
		
		return new PhoneInfo_06(name, phone);
	}
	
	private PhoneInfo_06 readUnivFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer_06.keyboard.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.print("전공 : ");
		String major = MenuViewer.keyboard.nextLine();
		
		System.out.print("학년 : ");
		int year = MenuViewer_06.keyboard.nextInt();
		
		return new PhoneUnivInfo_06(name, phone,major,year);
		
	}
	
	private PhoneInfo_06 readCompanyFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer_06.keyboard.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.print("회사 : ");
		String company = MenuViewer.keyboard.nextLine();
		
		
		return new PhoneCompanyInfo_06(name, phone,company);
		
	}
	
	public void inputData() throws MenuChoiceException
	{
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반, 2. 대학,3. 회사");
		System.out.print("선택 >>");
		
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
		System.out.println("데이터 입력이 완료 되었습니다.");
	}
	
	
	public void searchData()
	{
		System.out.println("데이터 검색을 시작합니다...");
		System.out.print("이름 : ");
		
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		
		if(dataIdx < 0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}
	
	//to do
	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다");
		
		System.out.print("이름 : ");
		
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		
		if(dataIdx < 0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
		}
		else
		{
			for(int idx = dataIdx;idx < cur_cnt-1;idx++)
			{
				infoStorage[idx] = infoStorage[idx+1];
			}
			
			cur_cnt--;
			System.out.println("데이터 삭제가 완료되었습니다.");
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
	
	public static void showMenu()//static 지워보기
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 : ");
	}
}

public class PhoneBookVer06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SingleTone Pattern 적용
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
				case INIT_MENU.INPUT://입력
					manager.inputData();
					break;
				case INIT_MENU.SEARCH://검색
					manager.searchData();
					break;
				case INIT_MENU.DELETE://삭제
					manager.deleteData();
					break;
				case INIT_MENU.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			catch(MenuChoiceException e)
			{
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
			}
		}

	}

}
