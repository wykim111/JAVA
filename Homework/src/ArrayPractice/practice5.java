package ArrayPractice;

public class practice5 {
	
	String str;
	char key_ch;
	
	public practice5(String param_str,char param_key_ch)
	{
		str = param_str;
		key_ch = param_key_ch;
	}
	
	void print_get_idx_ch(char key_ch)
	{
		System.out.print("application에 " + key_ch + "가 존재하는 위치(인덱스) :");
	
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == key_ch)
			{
				System.out.print(i + " ");
			}
			
		}
		System.out.println();
	}
	
	void print_get_ch_cnt(char key_ch)
	{
		int key_ch_cnt = 0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == key_ch)
			{
				++key_ch_cnt;
			}
		}
		
		System.out.println(key_ch+"개수 : " + key_ch_cnt);
		
	}
	
}
