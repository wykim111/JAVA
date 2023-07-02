package Strategy_Pattern;
import java.util.Random;

public class ProbStrategy implements Strategy{

	private Random random;
	private int prevHandValue = 0;
	private int currentHandValue = 0;
	private int[][] history = {
			{1,1,1},
			{1,1,1},
			{1,1,1},
	};
	
	public ProbStrategy(int seed)
	{
		random = new Random(seed);
	}
	
	@Override
	public Hand nextHand() {
		// TODO Auto-generated method stub
		return null;
	}

	private int getSum(int hv)
	{
		int sum = 0;
		
		for(int i=0;i<3;i++)
		{
			sum += history[hv][i];
		}
		return sum;
	}
	
	@Override
	public void study(boolean win) {
		// TODO Auto-generated method stub
		if(win)
		{
			history[prevHandValue][currentHandValue]++;
		}
		else
		{
			history[prevHandValue][(currentHandValue+1)%3]++;
			history[prevHandValue][(currentHandValue+2)%3]++;
		}
	}

}
