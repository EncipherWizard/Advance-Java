package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {

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
			String q = "select * from student";
			boolean b = s.execute(q);
			System.out.println(b);
			
			ResultSet rs = s.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
			}
			
			// closing connection
			con.close();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}




	}

}
