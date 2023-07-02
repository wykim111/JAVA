package ArrayPractice;

public class practice2 {
	
	private int[] intArr = new int[10];
	private	int intArr_idx = 0;
	
	public practice2()
	{
		for(int data = 10;data > 0;data--)
		{
			intArr[intArr_idx] = data;
			++intArr_idx;
		}
	}
	
	public void print_practice2()
	{
		
		for(int i = 0;i < 10;i++)
		{
			System.out.print(intArr[i] + " ");
			
		}
		System.out.println();
		
		
		
	}
	
	
}
