package observer;

public class DivObserver {
	protected int m_div;
	public DivObserver(int div)
	{
		m_div = div;
	}
	public void update(int val)
	{
		System.out.println(val + " div " + m_div + " is " + val / m_div + '\n');
	}

}
