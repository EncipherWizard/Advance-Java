package p01;

import java.util.ArrayList;
import java.util.Scanner;

import dao.EmployeeDao;
import dto.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmployeeDao dao = new EmployeeDao();
		
		while(true)
		{
			System.out.println("Enter 0 for Exit");
			System.out.println("Enter 1 for Add Employee");
			System.out.println("Enter 2 for Delete Employee");
			System.out.println("Enter 3 for Update Employee");
			System.out.println("Enter 4 for Display Employee");
			
			byte ch= sc.nextByte();
			
			switch (ch) {
			case 0:
				EmployeeDao.closeConnection();
				System.exit(0);
				break;
			case 1:
				// Add Employee
				System.out.println("Enter Employee Id");
				int empId = sc.nextInt();
				System.out.println("Enter Employee Name");
				String Name = sc.next();
				System.out.println("Enter Employee Basic Salary");
				float basicSal = sc.nextFloat();
				System.out.println("Enter Employee Hire Date");
				String hireDate = sc.next();
				
				Employee emp = new Employee(empId,Name,basicSal,hireDate);
				int i = dao.addEmployee(emp);
				
				if(i>0)
				{
					System.out.println(i+" Record Inserted");
				}
				break;
			case 2:
				// Delete Employee
				System.out.println("Enter Employee Id");
				empId=sc.nextInt();
				emp=new Employee(empId);
				i=dao.deleteEmployee(emp);
				if(i>0)
				{
					System.out.println(i+" Record Inserted");
				}
				break;
			case 3:
				// Update Employee 
				
				System.out.println("Enter Employee Id");
				 empId = sc.nextInt();
				System.out.println("Enter Employee Name");
				 Name = sc.next();
				System.out.println("Enter Employee Basic Salary");
				 basicSal = sc.nextFloat();
				System.out.println("Enter Employee Hire Date");
				 hireDate = sc.next();
				
				 emp = new Employee(empId,Name,basicSal,hireDate);
				i = dao.updateEmployee(emp);
				
				if(i>0)
				{
					System.out.println(i+" Record Updated");
				}
				break;
			case 4:
				ArrayList<Employee> list = dao.selectEmployee();
				for(Employee e : list)
				{
					System.out.println(e);
				}
				break;
			default:
				break;
			}
		}

	}

}
