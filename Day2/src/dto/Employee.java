package dto;

public class Employee {
	
	private int empId;
	private String empName;
	private float basicSalary;
	private String hireDate;
	
	public Employee() {
		super();
	}

	public Employee(int empId) {
		super();
		this.empId = empId;
	}

	public Employee(int empId, String empName, float basicSalary, String hireDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.basicSalary = basicSalary;
		this.hireDate = hireDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "[" + empId + " " + empName + " " + basicSalary + " " + hireDate + "]";
	}
	
	

}
