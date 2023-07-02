package Proxy_Pattern;

public class PrinterProxy implements Printable {

	private String name;	//이름
	private Printer real;	//본인
	
	public PrinterProxy()
	{
		
	}
	
	public PrinterProxy(String name)
	{
		this.name = name;
	}
	
	public synchronized void setPrinterName(String name) //이름의 설정
	{
		if(real != null)
		{
			real.setPrinterName(name);//"본인"에게 설정
		}
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
		realize();
		real.print(string);
	}
	
	private synchronized void realize()
	{
		if(real == null)
		{
			real = new Printer(name);
		}
	}
	
}
