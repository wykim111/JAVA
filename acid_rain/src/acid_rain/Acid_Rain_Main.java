package acid_rain;

public class Acid_Rain_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Acid_Rain_Main main = new Acid_Rain_Main();
		Account acc_gui = new Account();//���� ���� ȭ�� ���
		
		//Main View ��ġ ���
		acc_gui.set_Acid_Rain_main(main);
		
		
		
		
	}
	public void showGameView(Account acc_gui,String acc_id)
	{
		acc_gui.dispose();//����ȭ�� ���ֱ�
		System.out.println("showGameView" + "id = " + acc_id);
		Game_View game = new Game_View(acc_id);
	}
	

}
