package Proxy_Pattern;

public class Proxy_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printable p = new PrinterProxy("Alice");
		System.out.println("�̸��� ���� " + p.getPrinterName() + "�Դϴ�.");
		p.setPrinterName("Bob");
		System.out.println("�̸��� ���� " + p.getPrinterName() + "�Դϴ�.");
		p.print("Hello, world.");
	}

}
