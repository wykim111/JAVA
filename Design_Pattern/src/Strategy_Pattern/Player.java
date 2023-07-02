package Strategy_Pattern;

public class Player {
	
		private String name;
		private Strategy strategy;
		private int wincount;
		private int losecount;
		private int gamecount;
		
		public Player(String name, Strategy strategy)
		{
			this.name = name;
			this.strategy = strategy;
		}
		
		public Hand nextHand()
		{
			return strategy.nextHand();
		}
		
		public void win()
		{
			strategy.study(true);//½Â
			wincount++;
			gamecount++;
		}
		
		public void lose()
		{
			strategy.study(false);//ÆÐ
			losecount++;
			gamecount++;
		}
		
		public void even()
		{
			gamecount++;//¹«½ÂºÎ
		}

		@Override
		public String toString() {
			return "player [name=" + name + ", strategy=" + strategy + ", wincount=" + wincount + ", losecount="
					+ losecount + ", gamecount=" + gamecount + "]";
		}
		
	
	
}
