package Strategy;
/*
 * https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns
 * 
 * 
 */
public abstract class Duck {
	
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
	
	public Duck()
	{
		
	}
	
	public abstract void display();

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
	
	
	public void performFly()
	{
		flyBehavior.fly();
	}
	
	public void performQuack()
	{
		quackBehavior.quack();
	}
	

	
	public void swim()
	{
		System.out.println("��� ������ ���� ��ϴ�., ��¥ ������ ����");
	}
}
