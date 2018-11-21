package dto;

public class Account {
	
	private int accNo;
	private String accHolderName;
	private double balance;
	private String openingDate;
	
	public Account() {
		super();
	}

	public Account(int accNo) {
		super();
		this.accNo = accNo;
	}

	

	public Account(int accNo, String accHolderName, double balance, String openingDate) {
		super();
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.openingDate = openingDate;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	@Override
	public String toString() {
		return "[" + accNo + " " + accHolderName + " " + balance+ " " + openingDate + "]";
	}
	
	

}
