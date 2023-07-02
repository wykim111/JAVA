package ArrayPractice;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;


public class Application {

	public static void Menu_Print()
	{
		System.out.println("====================");
		System.out.println("1. 실습문제 1번");
		System.out.println("2. 실습문제 2번");
		System.out.println("3. 실습문제 3번");
		System.out.println("4. 실습문제 4번");
		System.out.println("5. 실습문제 5번");
		System.out.println("====================");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Menu_Print();
		System.out.println("실습문제 번호를 선택해주세요.");
		
		int exer_num = sc.nextInt();
		
		//sc.next();
		
		switch(exer_num)
		{
			case 1:
			{
				System.out.println("실습문제 1 소개");
				practice1 pr1 = new practice1();
				
				pr1.print_practice1();
				
			}
			break;
			case 2:
			{
				System.out.println("실습문제 2 소개");
				practice2 pr2 = new practice2();
				
				pr2.print_practice2();
			}
			break;
			case 3:
			{
				System.out.println("실습문제 3 소개");
				System.out.print("양의 정수 : ");
				
				int arr_size = sc.nextInt();
				
				practice3 pr3 = new practice3(arr_size);
				
				pr3.print_practice3();
				
				
			}
			break;
			case 4:
			{
				System.out.println("실습문제 4 소개");
				
				practice4 pr4 = new practice4();
				pr4.print_practice4();
				
			}
			break;
			case 5:
			{
				System.out.println("실습문제 5 소개");
				
				System.out.print("문자열 : ");
				String input_str = sc.next();
				
				System.out.print("문자 : ");
				
				char target_ch = sc.next().charAt(0);
				
				practice5 pr5 = new practice5(input_str,target_ch);
				
				pr5.print_get_idx_ch(target_ch);
				pr5.print_get_ch_cnt(target_ch);
				
				
			}
			break;
			case 6:
			{
				System.out.print("0 ~ 6 사이 숫자 입력 : ");
				int week_num = sc.nextInt();
				
				practice6 pr6 = new practice6(week_num);
				
				
				
			}
			break;
			default :
			{
				System.out.println("연습문제에 없는 번호입니다. 다시 선택해 주세요");
			
			}
			break;
			
		}
		
		
	}

}
