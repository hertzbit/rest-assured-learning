package restassured.jsonutil;

public class JiraUtils {

	public static String getRequestBodyForLogin() {
		
		return "{\n"
				+ "    \"username\": \"askhertzbit\",\n"
				+ "    \"password\": \"12345678HB\"\n"
				+ "}";
	}
	
	public static String getRequestBodyForCreateIssue() {
		
		return "{\n"
				+ "    \"fields\" : {\n"
				+ "        \"project\" : {\n"
				+ "            \"key\" : \"RES\"\n"
				+ "        },\n"
				+ "        \"summary\" : \"POST API Not Working\",\n"
				+ "        \"description\" : \"Not found is received even if the entries persist in the database\",\n"
				+ "        \"issuetype\" : {\n"
				+ "            \"name\" : \"Bug\"\n"
				+ "        }\n"
				+ "    }\n"
				+ "}";
	}
	
	public static String getRequestBodyToCreateComment () {
		
		return "{\n"
				+ "    \"body\": \"Trying to reproduce the issue on the local setup\",\n"
				+ "    \"visibility\": {\n"
				+ "        \"type\": \"role\",\n"
				+ "        \"value\": \"Administrators\"\n"
				+ "    }\n"
				+ "}";
	}
	
	public static String getRequestBodyToUpdateComment() {
		
		return "{\n"
				+ "    \"body\": \"Trying to reproduce issue on Development Environment\",\n"
				+ "    \"visibility\": {\n"
				+ "        \"type\": \"role\",\n"
				+ "        \"value\": \"Administrators\"\n"
				+ "    }\n"
				+ "}";
	}
}
