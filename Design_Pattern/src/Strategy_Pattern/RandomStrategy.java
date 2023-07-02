package Strategy_Pattern;

import java.util.Random;

public class RandomStrategy implements Strategy {

	private Random random;
	
	public RandomStrategy(int seed)
	{
		random = new Random(seed);
	}
	
	@Override
	public Hand nextHand() {
		// TODO Auto-generated method stub
		return Hand.getHand(random.nextInt(3));
	}

	@Override
	public void study(boolean win) {
		// TODO Auto-generated method stub
		
	}
	
}
