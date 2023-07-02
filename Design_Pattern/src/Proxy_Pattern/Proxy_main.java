package Proxy_Pattern;

public class Proxy_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printable p = new PrinterProxy("Alice");
		System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
		p.setPrinterName("Bob");
		System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
		p.print("Hello, world.");
	}

}
