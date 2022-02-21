import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	
	//connect to a database to get info for test cases/suites like usernames passwords etc.

	public static void main(String[] args) throws SQLException {
		
		String host = "localhost";
		
		String port = "3306";
		
		String connectionUrl = "jdbc:mysql://" + host + ":" + port + "/Qadbt"; //connect to the database Qadbt
		
		Connection c = DriverManager.getConnection(connectionUrl, "root", "12345"); // input username and password to acces the database
		
		Statement s = c.createStatement();
		
		ResultSet resultSet = s.executeQuery("select * from Employeeinfo where id = 1;"); // execute the Query from the Employeeinfo table and get the table info of items with the "1" id.
		
		resultSet.next();// iterate through the table -- ResultSet stores data like an Array so we need to move from 0th index to 1st index
		
		String username = resultSet.getString("name"); // get the name from the table
		
		String location = resultSet.getString("location"); // get the location from the table
		
		System.out.println(username +" " + location); //we can input these into a login page for example, or any other testing scenarios that need data from a database
		
	}
	
}
 