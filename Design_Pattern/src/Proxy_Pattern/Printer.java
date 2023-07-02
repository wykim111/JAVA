package Proxy_Pattern;

public class Printer implements Printable {

	private String name;
	
	public Printer()
	{
		heavyJob("Printer�� �ν��ͽ��� ���� ��");
	}
	public Printer(String name)
	{
		this.name = name;
		heavyJob("Printer�� �ν��ͽ� (" + name + ")�� ���� ��");
	}
	
	@Override
	public void setPrinterName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}

	@Override
	public String getPrinterName() {
		// TODO Auto-generated method stub
		
		return name;
	}

	@Override
	public void print(String string) {
		// TODO Auto-generated method stub
		System.out.println("=== " + name + " ===");
		System.out.println(string);
	}
	
	private void heavyJob(String msg)
	{
		System.out.println(msg);
		
		for(int i=0;i<5;i++)
		{
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{
				
			}
			System.out.println(".");
		}
		
		System.out.println("�Ϸ�.");
	}
	
}
