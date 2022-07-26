package restassured.java.basics;

public class ObjectUsage {

	public static Vehicle getTeslaObject() {
		
		Tesla.numberOfTeslaObjects++;
		return new Tesla("12345", "Black");
	}

	public static Vehicle getTataObject() {

		Tata.numberOfTataObjects++;
		return new Tata("98765", "Blue");
	}

}
