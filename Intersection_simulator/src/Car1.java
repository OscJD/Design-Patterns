

public class Car1 extends Thread{
	
	int ID;
	private String is_done = "no";
	private boolean passed = false;

	public Car1(Car car) {
		this.ID = car.getID();		
	}
	
	@Override
	public void run() {
		
		try {
            go();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
		
	}
	
	 private void go() throws InterruptedException{
		
			System.out.println("Car ID "+ this.ID + " is approaching the intersection");
			Thread.sleep(3000);
			System.out.println("Car ID "+ this.ID + " arrived to the intersection");
	
		synchronized(Thread_intersection.ocuppied) {
			
			while((Thread_intersection.ocuppied == "yes") || (Thread_intersection.light_status == "red")) {	
				
				if(Thread_intersection.ocuppied == "yes")
				{
					System.out.println("Car ID "+ this.ID + " waiting on the intersection");
					Thread_intersection.ocuppied.wait();
					}
				else {
					//System.out.println("Cars waining to green light");
				}
			}
			
			System.out.println("Car ID "+ this.ID + " is on the intersection");
			Thread_intersection.ocuppied = "yes";
			Thread.sleep(1000);
			System.out.println("Car ID "+ this.ID + " is out of the intersection");
			Thread_intersection.ocuppied = "no";
			
			Thread_intersection.ocuppied.notifyAll();
			
		}
		Thread.sleep(3000);
		System.out.println("Car ID "+ this.ID + " is gone from the instersection ");
		
		}
	}


