package Chapter23;

class MyRunnable implements Runnable
{
	public void run() {
		for(int i=10;i>=0;i--)
		{
			System.out.println(i + " ");
		}
	}
}


public class MyRunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new MyRunnable());
		t.start();
	}

}
