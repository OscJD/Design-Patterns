

public class Main {
		
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car() ;
		Car car3 = new Car() ;
		Car car4 = new Car();

		Intersection intersection = new Intersection();

		Car1 thread1 = new Car1(car1) ;
		Car1 thread2 = new Car1(car2) ;
		Car1 thread3 = new Car1(car3) ;
		Car1 thread4 = new Car1(car4) ;
	
		Thread_intersection intersection_main = new Thread_intersection(intersection);
		
		
		
		thread1.start() ;
		thread2.start() ;
		intersection_main.start();
		thread3.start() ;
		thread4.start() ;
		
			
			/*
			int counter =0;
			while(true) {
				System.out.println(counter++);
			}
			*/
		
	}

}
