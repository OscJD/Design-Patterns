package observer;

public class Subject {
	protected int m_value;
	protected DivObserver m_div_obj;
	protected ModObserver m_mod_obj;
	public Subject()
	{
		m_div_obj = new DivObserver(4);
		m_mod_obj = new ModObserver(3);
	}
	public void set_value(int value)
	{
		m_value = value;
		notifyObservers();
	}
	public void notifyObservers()
	{
		m_div_obj.update(m_value);
		m_mod_obj.update(m_value);
	}

	public static void main(String[] args) {
		Subject subj = new Subject();
		subj.set_value(14);
	}

}
