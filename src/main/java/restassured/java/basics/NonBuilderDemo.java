package restassured.java.basics;

class MobilePhone {
	
	private String imeiID; //Random String
	private Integer storageCapacity; //128, 256...
	private String chipDetails; //Apple, Snapdragon..
	
	public void addImeiId(String imeiId) {
		this.imeiID = imeiId;
		System.out.println("Setting IMEI ID : " + imeiId);
	}
	
	public void addStorageCapacity(Integer storageCapacity) {
		this.storageCapacity = storageCapacity;
		System.out.println("Setting Storage Capacity : " + storageCapacity);
	}
	
	public void addChipDetails(String chipDetails) {
		this.chipDetails = chipDetails;
		System.out.println("Setting Chip Details : " + chipDetails);
	}

	@Override
	public String toString() {
		return "MobilePhone [imeiID=" + imeiID + 
				", storageCapacity=" + storageCapacity + 
				", chipDetails=" + chipDetails
				+ "]";
	}
}

public class NonBuilderDemo {

	public static void main(String[] args) {
		
		MobilePhone mobilePhone = new MobilePhone();
		System.out.println(mobilePhone);
		mobilePhone.addImeiId("1234567890");
		mobilePhone.addChipDetails("Apple");
		mobilePhone.addStorageCapacity(128);
		System.out.println(mobilePhone);
	}
}
