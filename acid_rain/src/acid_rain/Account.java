package acid_rain;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Account extends JFrame implements ActionListener,KeyListener {
	
	public String user_id;
	private JTextField textField;//ID 입력창
	private JLabel NewLabel_set_ID, NewLabel_ID;
	private JButton NewButton;
	Acid_Rain_Main main;
	
	public Account()
	{
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("산성비");
		getContentPane().setLayout(null);

		//label : ID 설정 요구
		NewLabel_set_ID = new JLabel("ID 설정");
		NewLabel_set_ID.setHorizontalAlignment(SwingConstants.CENTER);
		NewLabel_set_ID.setFont(new Font("굴림",Font.PLAIN,27));
		NewLabel_set_ID.setBounds(20, 32, 381, 31);
		getContentPane().add(NewLabel_set_ID);
		
		//textField : ID 입력창
		textField = new JTextField();
		textField.setFont(new Font("굴림",Font.BOLD,24));
		textField.setBounds(24, 261, 238, 66);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		//Button
		JButton NewButton = new JButton("확인");
		NewButton.setFont(new Font("굴림",Font.BOLD,22));
		NewButton.setBounds(290, 261, 156, 66);
		getContentPane().add(NewButton);
		NewButton.addActionListener(this);
	
		//label : ID 설정
		NewLabel_ID = new JLabel("ID");
		NewLabel_ID.setHorizontalAlignment(SwingConstants.LEFT);
		NewLabel_ID.setFont(new Font("굴림",Font.BOLD,19));
		NewLabel_ID.setBounds(20, 200, 188, 47);
		getContentPane().add(NewLabel_ID);
		setVisible(true);
		
		textField.addKeyListener(this);
		
	
	}

	public void set_Acid_Rain_main(Acid_Rain_Main main)
	{
		this.main = main;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override//엔터키 이벤트
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//ENTER KEY 이벤트
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(!textField.getText().equals(""))
			{
				user_id = textField.getText().toString();
				System.out.println(user_id);
				main.showGameView(this,user_id);
			}
			else
			{
				NewLabel_set_ID.setText("유효하지 않은 ID 입니다.");
			}
				
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override//버튼 이벤트
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!textField.getText().equals(""))
		{
			user_id = textField.getText().toString();
			main.showGameView(this, user_id);
		}
		else
		{
			NewLabel_set_ID.setText("유효하지 않은 ID 입니다.");
		}
	}
}
