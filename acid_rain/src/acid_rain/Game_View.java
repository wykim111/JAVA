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
	
	private String[] work = { "바보", "우수하다", "반발", "마라톤", "전해지다", "주인공", "손가락", "수시로", "선명하다", "수도꼭지", "건전하다", "가라앉다",
			"믿음", "뛰어가다", "숨어있는", "고용하다", "보호하다", "착하다", "나쁘다", "선풍기", "자바", "붕어빵", "선택하다", "찬성하다", "반대하다", "위치하다",
			"생각되다", "깜짝", "감다", "꿈", "별", "감", "책", "오다", "가다", "소나기", "가방", "초록", "일어나다", "쏘다", "겨드랑이", "존경하다", "종소리",
			"갖고싶다", "명확하다", "뚜벅뚜벅", "할인", "아장아장", "사과", "감사", "이별", "대기" };
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
		
		//화면 구성
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//단어 입력
		textField_1 = new JTextField();
		textField_1.setBounds(115, 631, 267, 38);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		//레벨 리스트 보여주기
		list = new JList(game_LV);
		list.setSelectedIndex(0);
		list.setFont(new Font("굴림",Font.BOLD,22));
		list.setBounds(986, 44, 162, 280);
		
		//시작 버튼
		btn_gamestart = new JButton("시작");
		btn_gamestart.setFont(new Font("굴림",Font.BOLD,23));
		btn_gamestart.setBounds(497, 627, 105, 38);
		getContentPane().add(btn_gamestart);
		
		//게임 화면
		panel_Screen = new JPanel();
		panel_Screen.setBackground(Color.ORANGE);
		panel_Screen.setForeground(Color.ORANGE);
		panel_Screen.setBounds(43, 29, 740, 571);
		getContentPane().add(panel_Screen);
		panel_Screen.setLayout(null);
		panel_Screen.setVisible(false);
		
		//게임화면에서 빨간색 선
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 520, 740, 10);
		panel_Screen.add(panel_1);
		
		//점수판
		score = new JLabel("0점");
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("굴림",Font.BOLD,25));
		score.setBounds(823, 241, 149, 45);
		getContentPane().add(score);
		
		//닉네임
		Label_user_id = new JLabel(param_user_id);
		Label_user_id.setHorizontalAlignment(SwingConstants.CENTER);
		Label_user_id.setFont(new Font("굴림",Font.BOLD,25));
		Label_user_id.setBounds(823,71,149,27);
		getContentPane().add(Label_user_id);

		//레벨 리스트
		level = new JLabel("level 1");
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("굴림",Font.BOLD,24));
		level.setBounds(846, 142, 99, 42);
		getContentPane().add(level);
		
		//생명1
		panel_life1 = new JPanel();
		panel_life1.setBackground(Color.RED);
		panel_life1.setBounds(824, 319, 26, 27);
		getContentPane().add(panel_life1);
		
		//생명2
		panel_life2 = new JPanel();
		panel_life2.setBackground(Color.RED);
		panel_life2.setBounds(864, 319, 26, 27);
		getContentPane().add(panel_life2);
		
		//생명3
		panel_life3 = new JPanel();
		panel_life3.setBackground(Color.RED);
		panel_life3.setBounds(904, 319, 26, 27);
		getContentPane().add(panel_life3);
	
		//게임 결과 화면
		panel_over = new JPanel();//게임 결과 백그라운드
		panel_over.setBackground(Color.PINK);
		panel_over.setBounds(14, 142, 794, 286);
		panel_over.setVisible(false);
		getContentPane().add(panel_over);
		panel_over.setLayout(null);
		
		//게임 오버 라벨
		lblNewLabel = new JLabel("게임 오버!");
		lblNewLabel.setBounds(0,36,794,63);
		panel_over.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("굴림",Font.BOLD,54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//닉네임
		lblUser = new JLabel("ID");// 닉네임
		lblUser .setBounds(0, 115, 794, 45);
		panel_over.add(lblUser);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.RED);
		lblUser.setFont(new Font("굴림",Font.BOLD,54));
		
		//게임결과 점수
		lblScore = new JLabel("Score");
		lblScore.setBounds(0, 232, 794, 42);
		panel_over.add(lblScore);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.RED);
		lblScore.setFont(new Font("굴림", Font.BOLD, 54));
		
		setVisible(true);
		
		//버튼 이벤트
		btn_gamestart.addActionListener(this);
		//키 이벤트
		textField_1.addKeyListener(this);
		//리스트 이벤트
		list.addListSelectionListener(this);
		//텍스트 필드 포커스
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
			panel_Screen.setVisible(true);//게임 화면 등장
			
			for(i=0;i<=10000;i++)
			{
				try {
					Random random = new Random();//랜덤 객체 생성
					label[i] = new JLabel(work[random.nextInt(work.length)]);//단어
					
					label[i].setBounds(0,0,80,20);
					panel_Screen.add(label[i]);//단어 추가
					label[i].setLocation(random.nextInt(678),2);//x값 랜덤으로 출력
					
					new Acid_Rain_Move().start();
					
					//게임 레벨에 따라 속도 조절
					Thread.sleep(spd);
						
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
	//단어가 이동하고, 게임 오버 체크 
	class Acid_Rain_Move extends Thread{
		
		public void run() {
			
			//단어가 생성된 갯수만큼 반복문을 돌려서 각 단어마다 y pos 변경
			for(int word_idx = 0; word_idx <= i;word_idx++)
			{
				if(label[word_idx].isVisible())
				{
					int y_pos = label[word_idx].getY();
					int x_pos = label[word_idx].getX();
					
					label[word_idx].setLocation(x_pos,y_pos+10);
				}
				
				//단어가 마지노선을 넘었는지 확인
				if(label[word_idx].isVisible() && label[word_idx].getY() > 512)
				{
					//단어가 Y좌표를 넘으면 단어 사라짐
					label[word_idx].setVisible(false);
					life++;
				}
			}
			
			//라이프 체크
			switch(life)
			{
				case 0://생명 모두 잃지 않음
				{
					
				}
				break;
				case 1://생명 1개 잃음
				{
					
				}
				break;
			
				case 2://생명 2개 잃음
				{
					
				}
				break;
				case 3://생명 3개 잃음
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
	//ListSelectionEvent : List에서 선택된 아이템이 변경 될 떄
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		String str;
		
		if(arg0.getSource() == list)
		{
			switch(list.getSelectedIndex())
			{
				case 0:
				{
					spd = 3500;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 1:
				{
					spd = 2900;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 2:
				{
					spd = 2600;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 3:
				{
					spd = 2300;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 4:
				{
					spd = 1900;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 5:
				{
					spd = 1600;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 6:
				{
					spd = 1300;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 7:
				{
					spd = 1000;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 8:
				{
					spd = 800;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
				}
				break;
				case 9:
				{
					spd = 400;//게임 속도
					str=(String)list.getSelectedValue();//리스트 이름 저장
					level.setText(str); //레벨 라벨에 해당 정보 출력
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
