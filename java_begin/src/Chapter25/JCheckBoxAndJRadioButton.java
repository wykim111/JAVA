package Chapter25;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

class CheckBoxHandler implements ItemListener
{
	JRadioButton btn1;
	JRadioButton btn2;
	JRadioButton btn3;

	public CheckBoxHandler(JRadioButton b1,JRadioButton b2,JRadioButton b3)
	{
		btn1 = b1;
		btn2 = b2;
		btn3 = b3;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
		}
		else	//Item DESELECTED
		{
			btn1.setEnabled(false);
			btn2.setEnabled(false);
			btn3.setEnabled(false);		
		}
	}
}

public class JCheckBoxAndJRadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frm = new JFrame("Choice Component");
		frm.setBounds(120, 120, 200, 200);
		frm.setLayout(new GridLayout(0,1));
		
		JCheckBox checkBox = new JCheckBox("Are you a programmer");
		
		JRadioButton rbtn1 = new JRadioButton("I like C");
		JRadioButton rbtn2 = new JRadioButton("I like C++");
		JRadioButton rbtn3 = new JRadioButton("I like Java",true);
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rbtn1);
		bGroup.add(rbtn2);
		bGroup.add(rbtn3);
		
		checkBox.addItemListener(new CheckBoxHandler(rbtn1, rbtn2, rbtn3));
		frm.add(checkBox);
		frm.add(rbtn1);frm.add(rbtn2);frm.add(rbtn3);
		
		rbtn1.setEnabled(false);
		rbtn2.setEnabled(false);
		rbtn3.setEnabled(false);
		
		rbtn1.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							System.out.println("I like C too");
						}
						else
						{
							System.out.println("계속눌러있음");
						}
					}
				}
				
		);
		
		rbtn2.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							System.out.println("I like C++ too");
						}
					}
				}
				
		);
		
		rbtn3.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							System.out.println("I like JAVA too");
						}
					}
				}
				
		);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}

}
