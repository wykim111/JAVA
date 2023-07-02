package Chapter09;

class Point
{
	int xPos, yPos;
	
	public Point(int x,int y)
	{
		xPos = x;
		yPos = y;
	}
	
	public void showPointInfo()
	{
		System.out.println("["+xPos+", "+yPos+"]");
	}
}

class Circle
{
	int rad;
	Point center;
	
	public Circle(int x,int y,int r)
	{
		center =new Point(x,y);
		rad = r;
	}
	
	public void showCircleInfo()
	{
		System.out.println("radius : " + rad);
		center.showPointInfo();
	}
}

class Ring
{
	Circle inCircle;
	Circle outCircle;
	
	public Ring(int inX,int inY,int inR,int outX,int outY,int outR)
	{
		inCircle = new Circle(inX, inY, inR);
		outCircle = new Circle(outX, outY, outR);
	}
	
	public void showRingInfo()
	{
		System.out.println("Inner Circle Info...");
		inCircle.showCircleInfo();
		
		System.out.println("Out Circle Info...");
		outCircle.showCircleInfo();
		
	}
	
}
public class exer9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ring ring = new Ring(1,1,4,2,2,9);
		ring.showRingInfo();

	}

}
