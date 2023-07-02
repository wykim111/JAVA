package Chapter25;


import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MouseEventHandler_one implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getComponent();
		button.setText("Clicked");
		System.out.println("Clicked_Button" + e.getButton());
		System.out.println("���콺 ��ư ������ Ǯ��");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println("���콺 ��ư ����");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println("���콺 ��ư Ǯ��");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println("Ŀ�� ��ư �� ����");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Ŀ�� ��ư �� Ż��");
	}
	
}

class FrameMouseEventHandler implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("JFrame�󿡼� ���콺 ��ư ������ Ǯ��");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
public class exer25_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frm = new JFrame("First Swing");
		frm.setBounds(120, 120, 400, 400);
		frm.setLayout(new FlowLayout());
		frm.addMouseListener(new FrameMouseEventHandler());
		
		JButton btn1 = new JButton("My Button");
		MouseListener listener = new MouseEventHandler_one();
		btn1.addMouseListener(listener);
		
		JButton btn2 = new JButton("Your Button");
		btn2.addMouseListener(listener);
		
		JButton btn3 = new JButton("Our Button");
		btn3.addMouseListener(listener);
		
		frm.add(btn1);
		frm.add(btn2);
		frm.add(btn3);
		frm.setVisible(true);
	}

}
