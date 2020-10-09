package singleton;

public class TestSingleton {
	static singleton_class init = singleton_class.getInstance();
	
	public static void foo()
	{
	 singleton_class init = singleton_class.getInstance();
	  init.set_value(1);
	  System.out.println("foo: global_ptr is " + init.get_value() + ", and the instance is: "+ init.getInstance() + "\n");
	}
	
	public static void bar()
	{
	  init.set_value(2);
	  System.out.println("bar: global_ptr is " + init.get_value() + ", and the instance is: "+ init.getInstance() + "\n");
	}
	
	public static void main(String[] args) {
		System.out.println("main: global_ptr is " + init.get_value() + ", and the instance is: "+ init.getInstance() + "\n");
		foo();
		bar();
	}
	
}
