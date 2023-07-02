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
	
	
	Scanner scScanner = new Scanner(System.in);//Input ��ü ����
	PersonController pcPersonController = new PersonController();
	
	
	
	//Main Menu UI
	public void mainMenu()
	{
	
	
		//CMD �Է�
		while(true)
		{
			int[] person_size_arr = pcPersonController.personCount();		
			int student_size = person_size_arr[EVT_ROLE_STUDENT_IDX];
			int employee_size = person_size_arr[EVT_ROLE_EMPLOYEE_IDX];
			
			
			//Policy ���
			System.out.println("�л��� �ִ� 3����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� �л���"+student_size +"���Դϴ�.");
			System.out.println("����� �ִ� 10����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� �����"+employee_size +"���Դϴ�.");
			
			// M�� N�� ���� ���ڴ� PersonController(pc)Ŭ������ �ִ�
			// personCount()�޼ҵ��� ��ȯ ���� �̿��Ͽ� ���
			
			
			
			System.out.println("1. �л� �޴�");
			System.out.println("2. ��� �޴�");
			System.out.println("9. ������");
			
			System.out.print("�޴� ��ȣ : ");
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
				
			System.out.println("1. �л� �߰�");
			System.out.println("2. �л� ����");
			System.out.println("9. ��������...");
			
			if (student_size == 3) {
				System.out.println("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰� �޴��� �� �̻� Ȱ��ȭ���� �ʽ��ϴ�.");
			}
			
			System.out.print("�޴� ��ȣ: ");
			
			student_select_num = scScanner.nextInt();
			
			switch(student_select_num)
			{
				case INSERT_STUDENT :
				{
					System.out.println("studentMenu :: enter INSERT_STUDENT");
					
					if(student_size == 3)
					{
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
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
			
			
			System.out.println("1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("9. ��������...");
			
			if (employee_size == 10) {
				System.out.println("����� ���� �� �ִ� ������ �� á�� ������ ��� �߰� �޴��� �� �̻� Ȱ��ȭ���� �ʽ��ϴ�.");
			}
			
			
			System.out.print("�޴� ��ȣ: ");
			
			employee_select_num = scScanner.nextInt();
			//scScanner.nextLine();
			
			switch(employee_select_num)
			{
				case INSERT_EMPLOYEE :
				{
					System.out.println("employeeMenu :: enter INSERT_EMPLOYEE");
					
					if(employee_size == 10)
					{
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
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
			System.out.print("�л� �̸� : ");
			name = scScanner.nextLine();
			
			System.out.print("�л� ���� : ");
			age = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("�л� Ű :");
			height = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("�л� ������ : ");
			weight = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("�л� �г� :");
			grade = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("�л� ���� : ");
			major = scScanner.nextLine();
			
			
			pcPersonController.insertStudent(name, age, height, weight, grade, major);
			
			int[] arr = pcPersonController.personCount();
			
			if(arr[EVT_ROLE_STUDENT_IDX] != 3)
			{
				System.out.print("�׸� �Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� ��������: ");
				
				proceed_flag = scScanner.next().charAt(0);
				
				if(proceed_flag == 'N' || proceed_flag == 'n')
				{
					break;
				}
			}
			else
			{
				System.out.println("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰��� ����, �л� �޴��� ���ư��ϴ�.");
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
			System.out.print("��� �̸� : ");
			name = scScanner.nextLine();
			
			System.out.print("��� ���� : ");
			age = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("��� Ű :");
			height = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("��� ������ : ");
			weight = scScanner.nextDouble();
			scScanner.nextLine();//buffer clear
			System.out.print("��� �޿� :");
			salary = scScanner.nextInt();
			scScanner.nextLine();//buffer clear
			System.out.print("��� �μ� : ");
			major = scScanner.nextLine();
			
			
			pcPersonController.insertEmployee(name, age, height, weight, salary, major);
			
			int[] arr = pcPersonController.personCount();
			
			if(arr[EVT_ROLE_EMPLOYEE_IDX] != 10)
			{
				System.out.print("�׸� �Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� ��������: ");
				
				proceed_flag = scScanner.next().charAt(0);
				
				if(proceed_flag == 'N' || proceed_flag == 'n')
				{
					break;
				}
			}
			else
			{
				System.out.println("����� ���� �� �ִ� ������ �� á�� ������ ��� �߰��� ����, ��� �޴��� ���ư��ϴ�.");
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
