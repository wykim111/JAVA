package Chapter25;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

class PWHandler implements ActionListener
{
	JTextField id;
	JPasswordField pw;
	
	public PWHandler(JTextField id, JPasswordField pw)
	{
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ID : " + id.getText());
		System.out.println("Password :" + new String(pw.getPassword()));
		
		id.setText("");
		pw.setText("");
	}
}

public class AdapterEventHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frm = new JFrame("JLabel & JTextField");
		frm.setBounds(120,120,180,80);
		frm.setLayout(new GridLayout(2,2));
		
		JLabel idLabel = new JLabel("ID ",SwingConstants.RIGHT);
		JTextField idText = new JTextField(10);
		
		JLabel pwLabel = new JLabel("password ",SwingConstants.RIGHT);
		JPasswordField pwText = new JPasswordField(10);
		pwText.setEchoChar('*');
		
		pwText.addActionListener(new PWHandler(idText, pwText));
		
		frm.add(idLabel);frm.add(idText);
		frm.add(pwLabel);frm.add(pwText);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}

}
