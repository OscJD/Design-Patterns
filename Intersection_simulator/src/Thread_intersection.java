
public class Thread_intersection extends Thread {

	private Intersection intersection;
	public static String light_status;
	public static String ocuppied="no";
	private long t1=0;
	private long t2=0;
	

	public Thread_intersection(Intersection intersection) {
		this.intersection = intersection;
		this.light_status = intersection.get_status();
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
		while(true) {
		
		t1 = System.currentTimeMillis();
		
		System.out.println("Intersection light status " + this.light_status + " " + (t1-t2));
		Thread.sleep(2500);
		this.intersection.set_status(Boolean(this.intersection.get_status()));
		this.light_status = Boolean(this.intersection.get_status());
		
		t2 = t1;
		}
	}
	 
	 private String Boolean(String light_status){
		 if(light_status=="green")
			 return "red";
		 else
			 return "green";
	 }
}

