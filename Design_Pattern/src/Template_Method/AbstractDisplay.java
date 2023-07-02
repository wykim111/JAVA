package Template_Method;

public abstract class AbstractDisplay {//�߻� Ŭ����
	public abstract void open();
	public abstract void print();
	public abstract void close();
	
	public final void display()
	{
		open();
		for(int i=0;i<5;i++)
		{
			print();
		}
		close();
	}
}
