package Phone_Manager_Project;

import java.util.Scanner;

class PhoneInfo_04
{
	String name;
	String phoneNumber;
	
	public PhoneInfo_04(String name,String num)
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

class PhoneUnivInfo_04 extends PhoneInfo_04
{
	String major;
	int year;

	public PhoneUnivInfo_04(String _name, String _phoneNumber,String major,int year) {
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

class PhoneCompanyInfo_04 extends PhoneInfo_04
{
	String company;
	
	// TODO Auto-generated constructor stub
	public PhoneCompanyInfo_04(String name, String num, String company)
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

class PhoneBookManeger_04
{
	final int MAX_CNT = 100;
	PhoneInfo_04[] infoStorage = new PhoneInfo_04[MAX_CNT];
	int cur_cnt = 0;
	
	private PhoneInfo_04 readFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer_04.keyboard.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = MenuViewer_04.keyboard.nextLine();
		
		return new PhoneInfo_04(name, phone);
	}
	
	private PhoneInfo_04 readUnivFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer_04.keyboard.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.print("전공 : ");
		String major = MenuViewer.keyboard.nextLine();
		
		System.out.print("학년 : ");
		int year = MenuViewer_04.keyboard.nextInt();
		
		return new PhoneUnivInfo_04(name, phone,major,year);
		
	}
	
	private PhoneInfo_04 readCompanyFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer_04.keyboard.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.print("회사 : ");
		String company = MenuViewer.keyboard.nextLine();
		
		
		return new PhoneCompanyInfo_04(name, phone,company);
		
	}
	
	public void inputData()
	{
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반, 2. 대학,3. 회사");
		System.out.print("선택 >>");
		
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo_04 info = null;
		
		switch(choice)
		{
		case 1:
			info = readFriendInfo();
			break;
		case 2:
			info = readUnivFriendInfo();
			break;
		case 3:
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
			PhoneInfo_04 curInfo = infoStorage[idx];
			
			if(name.compareTo(curInfo.name) == 0)
				return idx;
		}
		
		return -1;
	}
}

class MenuViewer_04
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

public class PhoneBookVer04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBookManeger_04 manager = new PhoneBookManeger_04();
		int choice;
		
		while(true)
		{
			MenuViewer_04.showMenu();
			choice = MenuViewer_04.keyboard.nextInt();
			MenuViewer_04.keyboard.nextLine();
			
			switch(choice)
			{
			case 1://입력
				manager.inputData();
				break;
			case 2://검색
				manager.searchData();
				break;
			case 3://삭제
				manager.deleteData();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}

}
