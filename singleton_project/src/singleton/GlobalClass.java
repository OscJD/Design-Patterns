package singleton;

public class GlobalClass
{
    protected int m_value;
  
    public static GlobalClass global_ptr = null;
    
    public GlobalClass() {
    		m_value = 0;
    }
    public GlobalClass(int v)
    {
        m_value = v;
    }
    public int get_value()
    {
        return m_value;
    }
    public void set_value(int v)
    {
        m_value = v;
    }
};