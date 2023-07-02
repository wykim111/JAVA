package ArrayPractice;

public class practice3 {
	
	int[] int_arr;
	int data = 1;

	
	public practice3(int size)
	{
		int_arr = new int[size];

		
		for(int idx = 0;idx < size;idx++)
		{
			int_arr[idx] = data;
			++data;
		}
	
	}
	
	void print_practice3()
	{
		for(int idx = 0;idx < int_arr.length;idx++)
		{
			System.out.print(int_arr[idx] + " ");
		}
	
	}
}
