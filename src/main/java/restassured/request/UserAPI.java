package restassured.request;

public class UserAPI {

	public static String getPOSTRequestBody() {
		
		return "{\n"
		   		+ "    \"firstName\": \"Garry\",\n"
		   		+ "    \"lastName\": \"Kasparov\",\n"
		   		+ "    \"salary\": 500000,\n"
		   		+ "    \"address\": {\n"
		   		+ "        \"houseNumber\": \"WB-132\",\n"
		   		+ "        \"street\": \"Bakuxanov Qes., Sulh Kuc. 1 A, Feteliyev Kuc. Kesismesi Az1000, Absheron\",\n"
		   		+ "        \"city\": \"Baku\",\n"
		   		+ "        \"state\": \"NA\",\n"
		   		+ "        \"country\": \"Azerbaijan\",\n"
		   		+ "        \"pincode\": \"AZ-1000\"\n"
		   		+ "    },\n"
		   		+ "    \"contactNumbers\": [\n"
		   		+ "        \"+994 994 12 4299669\"\n"
		   		+ "    ]\n"
		   		+ "}";
	}
	
public static String getPUTRequestBody() {
		
		return "{\n"
		   		+ "    \"firstName\": \"Garry\",\n"
		   		+ "    \"lastName\": \"Kasparov\",\n"
		   		+ "    \"salary\": 50000,\n"
		   		+ "    \"address\": {\n"
		   		+ "        \"houseNumber\": \"WB-132\",\n"
		   		+ "        \"street\": \"Bakuxanov Qes., Sulh Kuc. 1 A, Feteliyev Kuc. Kesismesi Az1000, Absheron\",\n"
		   		+ "        \"city\": \"Baku\",\n"
		   		+ "        \"state\": \"NA\",\n"
		   		+ "        \"country\": \"Azerbaijan\",\n"
		   		+ "        \"pincode\": \"AZ-1000\"\n"
		   		+ "    },\n"
		   		+ "    \"contactNumbers\": [\n"
		   		+ "        \"+994 994 12 4299669\"\n"
		   		+ "    ]\n"
		   		+ "}";
	}
}
