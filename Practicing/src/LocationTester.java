
public class LocationTester 
{
	public static void main(String[] args)
	{
		SimpleLocation ucsd= new SimpleLocation();
		SimpleLocation lima= new SimpleLocation(5,5);
		
		//System.out.println(ucsd.distance(lima));
		System.out.println(lima.getLatitude());
		lima.setLatitude(398);
		System.out.println(lima.getLatitude());
		
	}

}
