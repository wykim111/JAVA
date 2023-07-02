package CAR_GAME;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Chapter23.MyThreadTest;

public class CarGame extends JFrame {

	class MyThread extends Thread
	{
		private JLabel label;
		private int x,y;
		
		public MyThread(String fname, int x, int y)
		{
			this.x = x;
			this.y = y;
			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x,y,100,100);
			add(label);
		}
		
		public void run()
		{
			for(int i=0;i<200;i++)
			{
				x += (10 * Math.random());
				label.setBounds(x,y,100,100);
				repaint();
				try {
					Thread.sleep(100);
					
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public CarGame()
	{
		setTitle("CarRace");
		setSize(600,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);//절대위치 배치관리자
		
		(new MyThread("C:/Users/ksq11/OneDrive/바탕 화면/자동차_이미지/아반떼.gif",100,0)).start();
		(new MyThread("C:/Users/ksq11/OneDrive/바탕 화면/자동차_이미지/소나타.gif",100,100)).start();
		(new MyThread("C:/Users/ksq11/OneDrive/바탕 화면/자동차_이미지/그랜저.gif",100,200)).start();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarGame t = new CarGame();
	}

}
