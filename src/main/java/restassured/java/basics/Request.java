package restassured.java.basics;

class Response {
	
	private String responseId;
	private String requestId;
	
	public Response(String responseId, String requestId) {
		super();
		this.responseId = responseId;
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", requestId=" + requestId + "]";
	}
}


public class Request {
	
	public String requestID;
	
	public Request modifyRequestId (String requestID) {
		this.requestID = requestID;
		return this;
	}
	
	public Response when() {
		return new Response ("12345", this.requestID);
	}
	
	public static void main(String[] args) {
		
		Request request = new Request();
		
		String responseBody = request.modifyRequestId("98765")
									.when().toString();
		System.out.println(responseBody);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
