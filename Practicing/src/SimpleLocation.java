
public class SimpleLocation {
	private double latitude;
	private double longitud;
	
	public SimpleLocation() {
		this.latitude = 3.4;
		this.longitud = 4.5;
	}
	public SimpleLocation(double lat, double lon) {
		this.latitude = lat;
		this.longitud = lon;
	}
	
	public double distance(SimpleLocation other) {
	 
		double distance;
		distance = (this.latitude + this.longitud +	other.latitude + other.longitud);
		return distance;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(double lat) {
		if(lat > 180 || lat<-180) {
			System.out.println("Your latitude value is out of range");
		}
		else {
		this.latitude = lat;
		}
	}
}
