package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Account;

public class AccountDao {
	
	private static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/cdac_db","cdac","cdac");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
	}
	
	public int addAccount(Account acc)
	{
		int i=0;
		try {
			PreparedStatement s=con.prepareStatement("insert into Account values(?,?,?,?)");
			s.setInt(1,acc.getAccNo());
			s.setString(2,acc.getAccHolderName());
			s.setDouble(3,acc.getBalance());
			s.setString(4,acc.getOpeningDate());
			
			i = s.executeUpdate();
			s.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public int deleteAccount(Account acc)
	{
		int i=0;
		
		try {
			PreparedStatement s = con.prepareStatement("delete from Account where AccNo = ?");
			s.setInt(1,acc.getAccNo());
			i = s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int updateAccount(Account acc) 
	{
		int i = 0;
		try {
			PreparedStatement s= con.prepareStatement("update Account set AccHolderName = ? where AccNo = ?");
			
			s.setString(1,acc.getAccHolderName());
			s.setInt(2,acc.getAccNo());
			i = s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public ArrayList<Account> selectAccount(Account acc)
	{
		ArrayList<Account> l = new ArrayList<>();
		
		try {
			
			PreparedStatement s = con.prepareStatement("Select * from Account where AccNo=?");
			s.setInt(1,acc.getAccNo());
			ResultSet rs = s.executeQuery();
			while(rs.next())
			{
				Account acc1=new Account();
				acc1.setAccNo(rs.getInt(1));
				acc1.setAccHolderName(rs.getString(2));
				acc1.setBalance(rs.getDouble(3));
				acc1.setOpeningDate(rs.getString(4));
				l.add(acc1);
			}
			s.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return l;
	}
	public ArrayList<Account> selectAllAccount()
	{
		ArrayList<Account> l = new ArrayList<>();
		
		try {
			
			PreparedStatement s = con.prepareStatement("Select * from Account");
			ResultSet rs = s.executeQuery();
			while(rs.next())
			{
				Account acc1=new Account();
				acc1.setAccNo(rs.getInt(1));
				acc1.setAccHolderName(rs.getString(2));
				acc1.setBalance(rs.getDouble(3));
				acc1.setOpeningDate(rs.getString(4));
				l.add(acc1);
			}
			s.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return l;
	}
	
	public int WithdrawAmount(Account acc,double wAmount) 
	{
		int i = 0;
		try {
				//double bal=acc.getBalance()-wAmount;
			//if((bal)<1000)
			//{
			//	return -1;
			//}
			PreparedStatement s= con.prepareStatement("update Account set Balance = Balance-? where AccNo = ?");
			
			s.setDouble(1,wAmount);
			s.setInt(2,acc.getAccNo());
			i = s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public int DepositAmount(Account acc,double dAmount) 
	{
		int i = 0;
		try {
		
			PreparedStatement s= con.prepareStatement("update Account set Balance = Balance+? where AccNo = ?");
			
			s.setDouble(1,dAmount);
			s.setInt(2,acc.getAccNo());
			i = s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public ArrayList<Account> CheckBalance(Account acc)
	{
		ArrayList<Account> l = new ArrayList<>();
		try {
			
			PreparedStatement s = con.prepareStatement("Select Balance from Account where AccNo=?");
			s.setInt(1,acc.getAccNo());
			ResultSet rs = s.executeQuery();
			while(rs.next())
			{
				Account acc1=new Account();
				acc1.setBalance(rs.getDouble(1));
				l.add(acc1);
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
			System.out.println(e);
		}
	}
	
}


