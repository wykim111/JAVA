package practice;

import java.util.Scanner;

public class practice9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[][][] student = {
								
									{
										{"강건강", "남나나"},
										{"도대담", "류라라"},
										{"문미미", "박보배"},
									
									},
									{
										{"송성실", "윤예의"},	
										{"진재주", "차천축"},
										{"피퐁표", "홍하하"}
									}
								};
		
		int search_layer = -1;
		int search_row = -1;
		int search_col = -1;
	
		boolean match_flag = false;
		String sz_num_line = "";
		
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String target_student = sc.nextLine();

search_loop :
		for(int group_num = 0; group_num < student.length;group_num++)
		{
			for(int row = 0;row < student[group_num].length;row++)
			{
				for(int col = 0; col < student[group_num][row].length;col++)
				{
					String match_student = student[group_num][row][col];
					
					if(target_student.compareTo(match_student) == 0)
					{
						match_flag = true;
						
						search_layer = group_num+1;
						search_row = row+1;
						search_col = col+1;
						
						//exit loop
						break search_loop;
					}
				}
			}
			
		}
		
		System.out.println("search_row = " + search_row + ' ' + "search_col = " + search_col);
	
		if(search_row == 1)
		{
			sz_num_line = "첫 번째";
		}
		else if(search_row == 2)
		{
			sz_num_line = "두 번째";
		}
		else if(search_row == 3)
		{
			sz_num_line = "세 번째";
		}
		
		
		if((search_col % 2) ==  1)
		{
			System.out.println("검색하신 " +target_student+ " 학생은 "+ search_layer + "분단 " +sz_num_line  +" 줄 왼쪽에 있습니다.");
		}
		else
		{
			System.out.println("검색하신 " +target_student+ " 학생은 "+ search_layer + "분단 " + sz_num_line +" 줄 오른쪽에 있습니다.");
		}
		
	
	}

}
