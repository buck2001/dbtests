package com.example.demo.constants;

public class AppConstants {
	// app APIs
	public final static String HEALTH_CHECK = "/";
	public final static String PERSON_API = "person";
	public final static String PERSON_API_PEOPLE = "/people";
	public final static String PERSON_API_FIND_PERSON = "/people/{id}";
	public final static String PERSON_API_UPDATE_DELETE_PERSON = "/people/{id}";

	// url paths etc.
	public final static String PERSON_ID = "id";

	// mongo db
	public static String DATABASE_NAME = "TestDatabase";
	public static String TABLE_PERSON = "Person";
//	public static String MONGODB_URL = "localhost";
//	public static int MONGODB_PORT = 27017;
	public static String bob = "mongodb+srv://PNTest:spectrum9!@pnmongodbcluster-nymh8.mongodb.net/test?retryWrites=true";

	// mongoDB codes
	public static int RECORD_EXISTS = 11000;
	public static int RECORD_DOESNT_EXIST = 11000;
	public static int INSERT_FAILED = 11000;

	// system literals
	public final static String IM_ALIVE = "I'm alive!";

	// Person fields
	public final static String PERSON_FIRST_NAME = "firstName";
	public final static String PERSON_LAST_NAME = "lastName";
	public final static String PERSON_OBJECT_ID = "_id";

	// database action text results
	public final static String NOT = "NOT ";
	public final static String UPDATED = "UPDATED";
	public final static String DELETED = "DELETED";
	public final static String REMOVED = "REMOVED";
	public final static String INSERTED = "INSERTED";

	// postgres JDBC vars

	public final static String url = "jdbc:postgresql://localhost/dvdrental";
	public final static String user = "postgres";
	public final static String password = "spectrum9";
	// spring.datasource.url=jdbc:postgresql://localhost:5432/dvdrental

	public static void main(String args[]) {
//		System.out.println("? quantifier ....");
//		// ! equals !=
//		System.out.println("ACCY + " + Pattern.matches("(?!/actuator).+", "/actuator/bob/smiff?43"));
//
//		System.out.println(Pattern.matches("[amn]?", "a"));// true (a or m or n comes one time)
//		System.out.println(Pattern.matches("[amn]?", "aaa"));// false (a comes more than one time)
//		System.out.println(Pattern.matches("[amn]?", "aammmnn"));// false (a m and n comes more than one time)
//		System.out.println(Pattern.matches("[amn]?", "aazzta"));// false (a comes more than one time)
//		System.out.println(Pattern.matches("[amn]?", "am"));// false (a or m or n must come one time)
//
//		System.out.println("+ quantifier ....");
//		System.out.println(Pattern.matches("[amn]+", "a"));// true (a or m or n once or more times)
//		System.out.println(Pattern.matches("[amn]+", "aaa"));// true (a comes more than one time)
//		System.out.println(Pattern.matches("[amn]+", "aammmnn"));// true (a or m or n comes more than once)
//		System.out.println(Pattern.matches("[amn]+", "aazzta"));// false (z and t are not matching pattern)
//
//		System.out.println("* quantifier ....");
//		System.out.println(Pattern.matches("[amn]*", "ammmna"));// true (a or m or n may come zero or more times)
	}
}
