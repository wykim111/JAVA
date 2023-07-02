package Chapter23;

class Sum_one
{
	int num;
	
	public Sum_one() {num = 0;}
	public void addNum(int n) {num += n;}
	public int getNum() {return num;}
}

class AdderThread_One extends Thread
{
	Sum_one sumInst;
	int start,end;
	
	public AdderThread_One(Sum_one sum, int s, int e)
	{
		sumInst = sum;
		start = s;
		end = e;
	}
	
	public void run()
	{
		for(int i=start;i<=end;i++)
		{
			sumInst.addNum(i);
		}
	}

}
public class ThreadHeapMultiAccess {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Sum_one s= new Sum_one();
		
		AdderThread_One at1 = new AdderThread_One(s, 1, 50);
		AdderThread_One at2 = new AdderThread_One(s, 51, 100);
		
		at1.start();
		at2.start();
		
		try
		{
			at1.join();
			at2.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("1부터100까지의 합 :" + s.getNum());
		
	}

}
