package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

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
			String q = "delete from student where rno = 103";
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
