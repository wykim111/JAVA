package ArrayPractice;


public class practice1 {

	int[] intArr = new int[10];
	int intArr_idx = 0;
	
	public practice1()
	{
		for(int data = 1;data < 11;data++)
		{
			intArr[intArr_idx] = data;
			++intArr_idx;
		}
	}
	
	public void print_practice1()
	{
		
		for(int i = 0;i < 10;i++)
		{
			System.out.print(intArr[i] + " ");
			
		}
		System.out.println();
		
		
		
	}

}
