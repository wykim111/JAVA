package Chapter25;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

class ActionEventHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
	}
	
}

public class JButtonActionEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frm =new JFrame("JButton Disable");
		frm.setBounds(120,120,250,150);
		frm.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("Button One");
		JButton btn2 = new JButton("Button Two");
		
		ActionListener actionHandler = new ActionEventHandler();
		btn1.addActionListener(actionHandler);
		btn2.addActionListener(actionHandler);
		
		frm.add(btn1);
		frm.add(btn2);
		btn1.setEnabled(false);
		
		frm.setVisible(true);
	}

}
