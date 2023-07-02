package Chapter25;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class button_MouseEventHandler implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스 버튼 눌렀다 풀림");
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

public class JButtonMouseEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frm = new JFrame("JButton Disable");
		frm.setBounds(120,120,250,150);
		frm.setLayout(new FlowLayout());
		
		button_MouseEventHandler mouseHandler = new button_MouseEventHandler();
		JButton btn1 = new JButton("Button One");
		btn1.addMouseListener(mouseHandler);
		JButton btn2 = new JButton("Button Two");
		btn2.addMouseListener(mouseHandler);
		
		frm.add(btn1);
		frm.add(btn2);
		btn1.setEnabled(false);
		
		frm.setVisible(true);
	}

}
