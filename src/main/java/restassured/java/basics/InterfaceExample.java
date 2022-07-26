package restassured.java.basics;

import static restassured.java.basics.ObjectUsage.*;

public class InterfaceExample {

	public static void main(String[] args) {

		Tesla tesla = (Tesla) getTeslaObject();
		Tata tata = (Tata) getTataObject();
		
		System.out.println(tesla.getVehicleDetails());
		System.out.println(tata.getVehicleDetails());
		System.out.println(Tesla.numberOfTeslaObjects);
		System.out.println(Tata.numberOfTataObjects);
	}
}
