package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		try {
			// load driver class
			Class.forName("com.mysql.jdbc.Driver");
			// creating connection
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/cdac_db", "cdac", "cdac");
			// creating query statement
			Statement s = con.createStatement();
			// execute query
			String q = "insert into student values(103,'hari',99.50,'2018-11-19')";
			boolean b = s.execute(q);
			System.out.println(b);
			// closing connection
			con.close();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
