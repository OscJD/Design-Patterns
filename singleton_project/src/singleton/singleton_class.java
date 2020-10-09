package singleton;


public class singleton_class{
	
	private static singleton_class instance;
	private static int m_value;
	
	private singleton_class(){}
	
	static {
		
		try {
			instance = new singleton_class();
		}catch(Exception e) {
			throw new RuntimeException("Exception ocurred in creating singleton instance");
		}
		}
	
	public static singleton_class getInstance() {
		return instance;
	}
	
	public static int get_value() {
		return m_value;
	}
	
	public static void set_value(int m) {
		m_value = m;
	}
	
	
}


