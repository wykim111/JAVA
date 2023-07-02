package Chapter23;

import java.util.Scanner;

class IntegerComm
{
	int num = 0;
	boolean isNewNum = false;
	
	
	public void setNum(int n)
	{
		System.out.println("1 :" + isNewNum);
		synchronized (this) 
		{
			System.out.println("2");
			if(isNewNum == true)
			{
				System.out.println("3");
				try
				{
					System.out.println("4-1");
					
					wait();
				}
				catch(InterruptedException e)
				{
					System.out.println("5");
					e.printStackTrace();
				}
			}
			
			System.out.println("6");
			num = n;
			isNewNum = true;
			notify();
		}//sync
	}
	public int getNum()
	{
		int retNum = 0;
		
		System.out.println("7" + isNewNum);
		
		synchronized (this) 
		{
			System.out.println("8");
			if(isNewNum == false)
			{
				System.out.println("9");
				try
				{
					System.out.println("9-1");
					wait();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
			System.out.println("10");
			retNum = num;
			isNewNum = false;
			notify();
		}//sync
		
		return retNum;
	}
}

class IntegerSummer extends Thread
{
	IntegerComm comm = new IntegerComm();
	int sum = 0;
	
	
	public IntegerSummer(IntegerComm comm)
	{
		this.comm = comm;
	}
	
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			sum += comm.getNum();
		}
		
		System.out.println("입력된 정수의 총 합 :" + sum);
	}
}

public class exer23_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerComm comm = new IntegerComm();
		IntegerSummer summer = new IntegerSummer(comm);
		summer.start();
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("총 5개의 정수 입력...");
		
		for(int i=0;i<5;i++)
		{
			int num = keyboard.nextInt();
			comm.setNum(num);
		}
		
		try 
		{
			summer.join();
			
		} 
		catch (InterruptedException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
