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
		System.out.println("이름 : ");
		String name = MenuViewer.keyboard.nextLine();//개행까지 읽음
		
		System.out.println("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		
		System.out.println("생년월일 : ");
		String birth = MenuViewer.keyboard.nextLine();
		
		infoStorage[curCnt] = new PhoneInfo_3(name, phone, birth);
		System.out.println("\n입력된 정보 출력...");
		curCnt++;
		
		System.out.println("데이터 입력이 완료되었습니다.");
		
	}
	
	public void searchData()
	{
		System.out.println("데이터 검색을 시작합니다...");
		System.out.println("이름 : ");
		
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		
		if(dataIdx <= 0)
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
			for(int idx = dataIdx;idx < curCnt-1;idx++)
			{
				infoStorage[idx] = infoStorage[idx+1];
			}
			
			curCnt--;
			System.out.println("데이터 삭제가 완료되었습니다.");
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
	
	public static void showMenu()//static 지워보기
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.println("선택 : ");
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
			case 1://입력
				break;
			case 2://검색
				break;
				
			}
		}
	}

}
