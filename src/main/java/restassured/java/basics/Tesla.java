package restassured.java.basics;

public class Tesla implements Vehicle{

	private String vehicleId;
	private String vehicleColor;
	public static Integer numberOfTeslaObjects = 0;
	
	public Tesla(String vehicleId, String vehicleColor) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleColor = vehicleColor;
	}

	@Override
	public String getVehicleDetails() {
		return "Vehicle ID : " + vehicleId + " , Vehicle Color : " + vehicleColor;
	}

	@Override
	public String getVehicleId() {
		return "Vehicle ID : " + vehicleId;
	}

}
