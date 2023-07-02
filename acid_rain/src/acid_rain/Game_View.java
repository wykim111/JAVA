package acid_rain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Game_View extends JFrame implements ActionListener,KeyListener, ListSelectionListener {
	private JTextField textField_1;
	private JButton btn_gamestart;
	
	private String[] work = { "�ٺ�", "����ϴ�", "�ݹ�", "������", "��������", "���ΰ�", "�հ���", "���÷�", "�����ϴ�", "��������", "�����ϴ�", "����ɴ�",
			"����", "�پ��", "�����ִ�", "����ϴ�", "��ȣ�ϴ�", "���ϴ�", "���ڴ�", "��ǳ��", "�ڹ�", "�ؾ", "�����ϴ�", "�����ϴ�", "�ݴ��ϴ�", "��ġ�ϴ�",
			"�����Ǵ�", "��¦", "����", "��", "��", "��", "å", "����", "����", "�ҳ���", "����", "�ʷ�", "�Ͼ��", "���", "�ܵ����", "�����ϴ�", "���Ҹ�",
			"����ʹ�", "��Ȯ�ϴ�", "�ѹ��ѹ�", "����", "�������", "���", "����", "�̺�", "���" };
	private String[] game_LV = { "level 1", "level 2", "level 3", "level 4", "level 5", "level 6", "level 7", "level 8",
			"level 9", "level 10" };
	
	private JPanel panel_Screen;
	private JLabel label[] = new JLabel[10000];
	private JLabel score;
	private int scorenum = 0;
	int i = 0;
	private int spd = 3500;
	private JList list;
	private int life = 0;
	private JLabel level;
	private JPanel panel_over;
	private JPanel panel_life1;
	private JPanel panel_life2;
	private JPanel panel_life3;
	
	
	private JLabel Label_user_id;// == private JLabel Label_nickname
	private JLabel lblNewLabel;
	private JLabel lblScore;
	private JLabel lblUser;// == private JLabel lblNick
	
	private String user_id;
	Acid_Rain_Main main;
	
	
	public Game_View(String param_user_id)
	{
		this.user_id = param_user_id;
		
		//ȭ�� ����
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//�ܾ� �Է�
		textField_1 = new JTextField();
		textField_1.setBounds(115, 631, 267, 38);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		//���� ����Ʈ �����ֱ�
		list = new JList(game_LV);
		list.setSelectedIndex(0);
		list.setFont(new Font("����",Font.BOLD,22));
		list.setBounds(986, 44, 162, 280);
		
		//���� ��ư
		btn_gamestart = new JButton("����");
		btn_gamestart.setFont(new Font("����",Font.BOLD,23));
		btn_gamestart.setBounds(497, 627, 105, 38);
		getContentPane().add(btn_gamestart);
		
		//���� ȭ��
		panel_Screen = new JPanel();
		panel_Screen.setBackground(Color.ORANGE);
		panel_Screen.setForeground(Color.ORANGE);
		panel_Screen.setBounds(43, 29, 740, 571);
		getContentPane().add(panel_Screen);
		panel_Screen.setLayout(null);
		panel_Screen.setVisible(false);
		
		//����ȭ�鿡�� ������ ��
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 520, 740, 10);
		panel_Screen.add(panel_1);
		
		//������
		score = new JLabel("0��");
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("����",Font.BOLD,25));
		score.setBounds(823, 241, 149, 45);
		getContentPane().add(score);
		
		//�г���
		Label_user_id = new JLabel(param_user_id);
		Label_user_id.setHorizontalAlignment(SwingConstants.CENTER);
		Label_user_id.setFont(new Font("����",Font.BOLD,25));
		Label_user_id.setBounds(823,71,149,27);
		getContentPane().add(Label_user_id);

		//���� ����Ʈ
		level = new JLabel("level 1");
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("����",Font.BOLD,24));
		level.setBounds(846, 142, 99, 42);
		getContentPane().add(level);
		
		//����1
		panel_life1 = new JPanel();
		panel_life1.setBackground(Color.RED);
		panel_life1.setBounds(824, 319, 26, 27);
		getContentPane().add(panel_life1);
		
		//����2
		panel_life2 = new JPanel();
		panel_life2.setBackground(Color.RED);
		panel_life2.setBounds(864, 319, 26, 27);
		getContentPane().add(panel_life2);
		
		//����3
		panel_life3 = new JPanel();
		panel_life3.setBackground(Color.RED);
		panel_life3.setBounds(904, 319, 26, 27);
		getContentPane().add(panel_life3);
	
		//���� ��� ȭ��
		panel_over = new JPanel();//���� ��� ��׶���
		panel_over.setBackground(Color.PINK);
		panel_over.setBounds(14, 142, 794, 286);
		panel_over.setVisible(false);
		getContentPane().add(panel_over);
		panel_over.setLayout(null);
		
		//���� ���� ��
		lblNewLabel = new JLabel("���� ����!");
		lblNewLabel.setBounds(0,36,794,63);
		panel_over.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("����",Font.BOLD,54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//�г���
		lblUser = new JLabel("ID");// �г���
		lblUser .setBounds(0, 115, 794, 45);
		panel_over.add(lblUser);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.RED);
		lblUser.setFont(new Font("����",Font.BOLD,54));
		
		//���Ӱ�� ����
		lblScore = new JLabel("Score");
		lblScore.setBounds(0, 232, 794, 42);
		panel_over.add(lblScore);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.RED);
		lblScore.setFont(new Font("����", Font.BOLD, 54));
		
		setVisible(true);
		
		//��ư �̺�Ʈ
		btn_gamestart.addActionListener(this);
		//Ű �̺�Ʈ
		textField_1.addKeyListener(this);
		//����Ʈ �̺�Ʈ
		list.addListSelectionListener(this);
		//�ؽ�Ʈ �ʵ� ��Ŀ��
		textField_1.requestFocus();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	class Acid_Rain_Thread {
		
		public void run()
		{
			panel_Screen.setVisible(true);//���� ȭ�� ����
			
			for(i=0;i<=10000;i++)
			{
				try {
					Random random = new Random();//���� ��ü ����
					label[i] = new JLabel(work[random.nextInt(work.length)]);//�ܾ�
					
					label[i].setBounds(0,0,80,20);
					panel_Screen.add(label[i]);//�ܾ� �߰�
					label[i].setLocation(random.nextInt(678),2);//x�� �������� ���
					
					new Acid_Rain_Move().start();
					
					//���� ������ ���� �ӵ� ����
					Thread.sleep(spd);
						
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
	//�ܾ �̵��ϰ�, ���� ���� üũ 
	class Acid_Rain_Move extends Thread{
		
		public void run() {
			
			//�ܾ ������ ������ŭ �ݺ����� ������ �� �ܾ�� y pos ����
			for(int word_idx = 0; word_idx <= i;word_idx++)
			{
				if(label[word_idx].isVisible())
				{
					int y_pos = label[word_idx].getY();
					int x_pos = label[word_idx].getX();
					
					label[word_idx].setLocation(x_pos,y_pos+10);
				}
				
				//�ܾ �����뼱�� �Ѿ����� Ȯ��
				if(label[word_idx].isVisible() && label[word_idx].getY() > 512)
				{
					//�ܾ Y��ǥ�� ������ �ܾ� �����
					label[word_idx].setVisible(false);
					life++;
				}
			}
			
			//������ üũ
			switch(life)
			{
				case 0://���� ��� ���� ����
				{
					
				}
				break;
				case 1://���� 1�� ����
				{
					
				}
				break;
			
				case 2://���� 2�� ����
				{
					
				}
				break;
				case 3://���� 3�� ����
				{
					
				}
				break;
				default:
				{
					
				}
				break;
				
			}
				
		}
		
		
	}
	
	
	public void set_Acid_Rain_main(Acid_Rain_Main main){
		this.main = main;
	}
	@Override
	//ListSelectionEvent : List���� ���õ� �������� ���� �� ��
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		String str;
		
		if(arg0.getSource() == list)
		{
			switch(list.getSelectedIndex())
			{
				case 0:
				{
					spd = 3500;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 1:
				{
					spd = 2900;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 2:
				{
					spd = 2600;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 3:
				{
					spd = 2300;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 4:
				{
					spd = 1900;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 5:
				{
					spd = 1600;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 6:
				{
					spd = 1300;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 7:
				{
					spd = 1000;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 8:
				{
					spd = 800;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				case 9:
				{
					spd = 400;//���� �ӵ�
					str=(String)list.getSelectedValue();//����Ʈ �̸� ����
					level.setText(str); //���� �󺧿� �ش� ���� ���
				}
				break;
				default :
				{
					break;
				}
			}
				
		}
	}
		
}
	
	
	

}
