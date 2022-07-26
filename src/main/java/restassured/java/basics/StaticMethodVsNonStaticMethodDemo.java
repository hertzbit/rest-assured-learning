package restassured.java.basics;

import static restassured.java.basics.StaticDemo.*;
import static java.lang.System.*;
public class StaticMethodVsNonStaticMethodDemo {

	public static void main(String[] args) {
		
		given();
		when();
		then();
		System.err.println("ERROR");
		out.println("Something went wrong !");
	}
}
