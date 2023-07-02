package Homework4_Inheritance;

import java.util.Scanner;


public class PersonMenu {
	
	
	
	//Main Menu
	private static final int STUDENT_MENU = 1;
	private static final int EMPLOYEE_MENU = 2;
	private static final int EXIT_MENU = 9;
	
	//Student Menu
	private static final int INSERT_STUDENT = 1;
	private static final int PRINT_STUDENT = 2;
	private static final int EXIT_STUDENT_MENU = 9;
	
	//Employee Menu
	private static final int INSERT_EMPLOYEE = 1;
	private static final int PRINT_EMPLOYEE = 2;
	private static final int EXIT_EMPLOYEE_MENU = 9;
	
	//CONST EVENT TYPE INDEX
	private static final int EVT_ROLE_STUDENT_IDX = 0;
	private static final int EVT_ROLE_EMPLOYEE_IDX = 1;
	
	
	Scanner scScanner = new Scanner(System.in);//Input 객체 선언
	PersonController pcPersonController = new PersonController();
	
	
	
	//Main Menu UI
	public void mainMenu()
	{
	
	
		//CMD 입력
		while(true)
		{
			int[] person_size_arr = pcPersonController.personCount();		
			int student_size = person_size_arr[EVT_ROLE_STUDENT_IDX];
			int employee_size = person_size_arr[EVT_ROLE_EMPLOYEE_IDX];
			
			
			//Policy 출력
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은"+student_size +"명입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은"+employee_size +"명입니다.");
			
			// M과 N에 들어가는 숫자는 PersonController(pc)클래스에 있는
			// personCount()메소드의 반환 값을 이용하여 출력
			
			
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 나가기");
			
			System.out.print("메뉴 번호 : ");
			int select_num = scScanner.nextInt();
			boolean exit_flag = false;
			
			switch(select_num)
			{
				case STUDENT_MENU:
				{
					System.out.println("mainMenu :: enter STUDENT_MENU");
			
					studentMenu();		
					
				}
				break;
				case EMPLOYEE_MENU:
				{
					System.out.println("mainMenu :: enter EMPLOYEE_MENU");
					employeeMenu();
				}
				break;
				case EXIT_MENU:
				{
					exit_flag = true;
					System.out.println("mainMenu :: enter EXIT_MENU");
				}
				break;
				default : 
				{
					System.out.println("mainMenu :: enter INVALID SELECT");
				}
				break;
				
			}
			
			if(exit_flag == true)
			{
				break;
			}
			
		}
		
	}//main_menu
	
	public void studentMenu()
	{
		
		while(true)
		{
			boolean student_menu_exit_flag = false; 
			int student_select_num;
			
			int[] person_size_arr = pcPersonController.personCount();		
			int student_size = person_size_arr[EVT_ROLE_STUDENT_IDX];
				
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로...");
			
			if (student_size == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화되지 않습니다.");
			}
			
			System.out.print("메뉴 번호: ");
			
			student_select_num = scScanner.nextInt();
			
			switch(student_select_num)
			{
				case INSERT_STUDENT :
				{
					System.out.println("studentMenu :: enter INSERT_STUDENT");
					
					if(student_size == 3)
					{
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					}
					else
					{
						insertStudent();	
					}
					
					
				}
				break;
				
				case PRINT_STUDENT :
				{
					System.out.println("studentMenu :: enter PRINT_STUDENT");
					printStudent();
				}
				break;
				
				case EXIT_STUDENT_MENU :
				{
					System.out.println("studentMenu :: enter EXIT_STUDENT_MENU");
					student_menu_exit_flag = true;
				}
				break;
				
				default :
				{
					System.out.println("studentMenu :: enter INVALID SELECT");
				}
				break;
			
			}
			
			if(student_menu_exit_flag == true)
			{
				break;
			}
			
		}
	}
	
	public void employeeMenu()
	{
		while(true)
		{
			boolean employee_menu_exit_flag = false; 
			int employee_select_num;
			
			int[] person_size_arr = pcPersonController.personCount();		
			int employee_size = person_size_arr[EVT_ROLE_EMPLOYEE_IDX];
			
			
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로...");
			
			if (employee_size == 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더 이상 활성화되지 않습니다.");
			}
			
			
			System.out.print("메뉴 번호: ");
			
			employee_select_num = scScanner.nextInt();
			//scScanner.nextLine();
			
			switch(employee_select_num)
			{
				case INSERT_EMPLOYEE :
				{
					System.out.println("employeeMenu :: enter INSERT_EMPLOYEE");
					
					if(employee_size == 10)
					{
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					}
					else
					{
						insertEmployee();	
					}
					
				}
				break;
				
				case PRINT_EMPLOYEE :
				{
					System.out.println("employeeMenu :: enter PRINT_EMPLOYEE");
					printEmployee();
				}
				break;
				
				case EXIT_EMPLOYEE_MENU :
				{
					System.out.println("employeeMenu :: enter EXIT_EMPLOYEE_MENU");
					employee_menu_exit_flag = true;
				}
				break;
				
				default :
				{
					System.out.println("employeeMenu :: enter INVALID SELECT");
				}
				break;
			
			}
			
			if(employee_menu_exit_flag == true)
			{
				break;
			}
			
		}
	}
	
	public void insertStudent()
	{
		char proceed_flag;
		String name;
		int age;
		double height;
		double weight;
		int grade;
		String major;
		
		
		while(true)
		{
			scScanner.nextLine();//buffer clear
			System.out.print("학생 이름 : ");
			name = scScanner.nextLine();
			
			System.out.print("학생 나이 : ");
			age = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("학생 키 :");
			height = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("학생 몸무게 : ");
			weight = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("학생 학년 :");
			grade = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("학생 전공 : ");
			major = scScanner.nextLine();
			
			
			pcPersonController.insertStudent(name, age, height, weight, grade, major);
			
			int[] arr = pcPersonController.personCount();
			
			if(arr[EVT_ROLE_STUDENT_IDX] != 3)
			{
				System.out.print("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요: ");
				
				proceed_flag = scScanner.next().charAt(0);
				
				if(proceed_flag == 'N' || proceed_flag == 'n')
				{
					break;
				}
			}
			else
			{
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료, 학생 메뉴로 돌아갑니다.");
				break;
			}
			
		}
		
	}
	
	public void printStudent()
	{
		Student[] student_array_list = pcPersonController.printStudent();
		
		for(int i=0;i<student_array_list.length;i++)
		{
			if(student_array_list[i] == null)
			{
				break;
			}
			
			System.out.println(student_array_list[i]);
		}
		
		
	}
	
	public void insertEmployee()
	{
		char proceed_flag;
		String name;
		int age;
		double height;
		double weight;
		int salary;
		String major;
		
		
		while(true)
		{
			scScanner.nextLine();//buffer clear
			System.out.print("사원 이름 : ");
			name = scScanner.nextLine();
			
			System.out.print("사원 나이 : ");
			age = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("사원 키 :");
			height = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("사원 몸무게 : ");
			weight = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("사원 급여 :");
			salary = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("사원 부서 : ");
			major = scScanner.nextLine();
			
			
			pcPersonController.insertEmployee(name, age, height, weight, salary, major);
			
			int[] arr = pcPersonController.personCount();
			
			if(arr[EVT_ROLE_EMPLOYEE_IDX] != 10)
			{
				System.out.print("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요: ");
				
				proceed_flag = scScanner.next().charAt(0);
				
				if(proceed_flag == 'N' || proceed_flag == 'n')
				{
					break;
				}
			}
			else
			{
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료, 사원 메뉴로 돌아갑니다.");
				break;
			}
			
		}
	}
	
	public void printEmployee()
	{
		Employee[] employee_array_list = pcPersonController.printEmployee();
		
		for(int i=0;i<employee_array_list.length;i++)
		{
			if(employee_array_list[i] == null)
			{
				break;
			}
			
			System.out.println(employee_array_list[i]);
		}
	}
	
	
}
