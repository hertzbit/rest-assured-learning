package restassured.java.basics;

class MobilePhoneBuilder {
	
	private String imeiID; //Random String
	private Integer storageCapacity; //128, 256...
	private String chipDetails; //Apple, Snapdragon..
	
	public MobilePhoneBuilder addImeiId(String imeiId) {
		this.imeiID = imeiId;
		System.out.println("Setting IMEI ID : " + imeiId);
		return this;
	}
	
	public MobilePhoneBuilder addStorageCapacity(Integer storageCapacity) {
		this.storageCapacity = storageCapacity;
		System.out.println("Setting Storage Capacity : " + storageCapacity);
		return this;
	}
	
	public MobilePhoneBuilder addChipDetails(String chipDetails) {
		this.chipDetails = chipDetails;
		System.out.println("Setting Chip Details : " + chipDetails);
		return this;
	}

	@Override
	public String toString() {
		return "MobilePhone [imeiID=" + imeiID + 
				", storageCapacity=" + storageCapacity + 
				", chipDetails=" + chipDetails
				+ "]";
	}
	
	public static MobilePhoneBuilder build() {
		return new MobilePhoneBuilder();
	}
}


public class BuilderDemo {

	public static void main(String[] args) {
		
		MobilePhoneBuilder mobilePhone =  MobilePhoneBuilder.build()
												.addChipDetails("Apple")
												.addImeiId("987655421")
												.addStorageCapacity(256);
		
		System.out.println(mobilePhone);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
