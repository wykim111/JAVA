package acid_rain;

public class Acid_Rain_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Acid_Rain_Main main = new Acid_Rain_Main();
		Account acc_gui = new Account();//계정 설정 화면 출력
		
		//Main View 위치 등록
		acc_gui.set_Acid_Rain_main(main);
		
		
		
		
	}
	public void showGameView(Account acc_gui,String acc_id)
	{
		acc_gui.dispose();//계정화면 없애기
		System.out.println("showGameView" + "id = " + acc_id);
		Game_View game = new Game_View(acc_id);
	}
	

}
