package restassured.jsonutil;

public class StudentAPI {
	
	public static String getStudentJSON() {
		
		return "{\n"
				+ "	\"studentId\" : 6215489,\n"
				+ "	\"firstName\" : \"James\",\n"
				+ "	\"lastName\" : \"Bond\",\n"
				+ "	\"totalMarks\" : 182,\n"
				+ "	\"subjects\" : [\n"
				+ "		{\n"
				+ "			\"subjectId\" : \"SCI-1\",\n"
				+ "			\"subjectName\" : \"Physics\",\n"
				+ "			\"departmentName\" : \"Science\",\n"
				+ "			\"marks\" : 87\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"subjectId\" : \"CSE-2\",\n"
				+ "			\"subjectName\" : \"Object Oriented Programming\",\n"
				+ "			\"departmentName\" : \"Computer Science\",\n"
				+ "			\"marks\" : 95\n"
				+ "		}\n"
				+ "	],\n"
				+ "	\"address\" : {\n"
				+ "		\"houseNumber\" : \"2XB\",\n"
				+ "		\"street\" : \"Sushant Lok Phase 1\",\n"
				+ "		\"city\" : \"Gurgaon\",\n"
				+ "		\"state\" : \"Haryana\",\n"
				+ "		\"country\" : \"India\",\n"
				+ "		\"pincode\" : 122002\n"
				+ "	},\n"
				+ "	\"contactNumbers\" : [1234567890, 9876543210]\n"
				+ "}";
	}

}
