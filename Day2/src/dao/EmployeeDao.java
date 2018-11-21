package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Employee;

public class EmployeeDao {
	
	private static Connection con;
	
	static{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_db","cdac","cdac");
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
	
	public int addEmployee(Employee emp)
	{
		int i=0;
		try {
			
			PreparedStatement s = con.prepareStatement("insert into Employee values(?,?,?,?)");
			s.setInt(1,emp.getEmpId());
			s.setString(2,emp.getEmpName());
			s.setFloat(3, emp.getBasicSalary());
			s.setString(4,emp.getHireDate());
			i=s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int deleteEmployee(Employee emp)
	{
		int i=0;
		try {
			
			PreparedStatement s = con.prepareStatement("delete from Employee where empId = ?");
			s.setInt(1,emp.getEmpId());
			i=s.executeUpdate();
			s.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateEmployee(Employee emp)
	{
		int i=0;
		try {
			PreparedStatement s = con.prepareStatement("update Employee set EmpName = ?, BasicSalary = ? , HireDate = ? where EmpId = ?");
			s.setString(1,emp.getEmpName());
			s.setFloat(2,emp.getBasicSalary());
			s.setString(3,emp.getHireDate());
			s.setInt(4,emp.getEmpId());
			
			i=s.executeUpdate();
			s.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public ArrayList<Employee> selectEmployee()
	{
		ArrayList<Employee> l=new ArrayList<>();
		
		try {
			
			PreparedStatement s = con.prepareStatement("select * from Employee");
			ResultSet rs=s.executeQuery();
			while(rs.next())
			{
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setBasicSalary(rs.getFloat(3));
				emp.setHireDate(rs.getString(4));
				l.add(emp);
			}
			s.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return l;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
