package Chapter23;

class MessageSendingThread_Two extends Thread
{
	String message;
	
	public MessageSendingThread_Two(String str, int prio)
	{
		message = str;
		setPriority(prio);
	}
	
	public void run()
	{
		for(int i=0;i<1000000;i++)
		{
			System.out.println(message + "("+getPriority()+")");
			
			try
			{
				sleep(1);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}

public class PriorityTestTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageSendingThread_Two tr1 = new MessageSendingThread_Two("First",Thread.MAX_PRIORITY);
		MessageSendingThread_Two tr2 = new MessageSendingThread_Two("Second",Thread.NORM_PRIORITY);
		MessageSendingThread_Two tr3 = new MessageSendingThread_Two("Third",Thread.MIN_PRIORITY);

		tr1.start();
		tr2.start();
		tr3.start();
	
	}

}
