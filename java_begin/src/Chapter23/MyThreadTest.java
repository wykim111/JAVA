package Chapter23;

class MyThread extends Thread{
	public void run() {
		for(int i=10;i>=0;i--)
		{
			System.out.println(i + " ");
		}
	}
}


public class MyThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new MyThread();
		t.start();
	}

}
