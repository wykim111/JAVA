package ArrayPractice;

interface WEEK{
	
}

public class practice6 {

	String week_str = "월화수목금토일";
	
	public practice6(int week_idx)
	{
		try {
			char ch = week_str.charAt(week_idx);
			System.out.println(ch + "요일");
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e);
			
			//throw new IllegalArgumentException("잘못 입력하셨습니다.");
		}
		
	}
	
	
	
}
