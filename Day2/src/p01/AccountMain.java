package p01;

import java.util.ArrayList;
import java.util.Scanner;

import dao.AccountDao;
import dto.Account;

public class AccountMain {

	public static void main(String[] args) {
		int i=0;
		Scanner sc =new Scanner(System.in);
		AccountDao dao=new AccountDao();
		
		while(true)
		{
			System.out.println("0 to exit");
			System.out.println("1 to add Account");
			System.out.println("2 to delete Account");
			System.out.println("3 to update Account's Detail");
			System.out.println("4 to show Account's Detail");
			System.out.println("5 to show All Account Detail");
			System.out.println("6 to Withdraw Balance");
			System.out.println("7 to Deposit Balance");
			System.out.println("8 to Check Balance");
			byte ch = sc.nextByte();
			switch (ch) {
			case 0:
				AccountDao.closeConnection();
				System.exit(0);
				break;
			case 1:
				System.out.println("Enter Account Number");
				int AccNo = sc.nextInt();
				System.out.println("Enter Account Holder Name");
				String AccHolderName=sc.next();
				System.out.println("Enter Account Balance");
				double balance=sc.nextDouble();
				System.out.println("Enter Account Opening Date");
				String OpeningDate = sc.next();
				
				Account acc =new Account(AccNo,AccHolderName,balance,OpeningDate);
				if(balance<1000)
				{
					System.out.println("Aur Paise Daal");
				}
				else
				{
					i=dao.addAccount(acc);
				}
				
				if(i>0)
				{
					System.out.println("Account Added");
				}
				break;
			case 2:
				System.out.println("Enter Account Number");
				AccNo=sc.nextInt();
				acc=new Account(AccNo);
				i=dao.deleteAccount(acc);
				if(i>0) {
					System.out.println("record deleted");
				}
				break;
			case 3:
				System.out.println("Enter Account Number");
				AccNo = sc.nextInt();
				System.out.println("Enter Account Holder Name");
				AccHolderName=sc.next();
				System.out.println("Enter Account Balance");
				balance=sc.nextDouble();
				System.out.println("Enter Account Opening Date");
				OpeningDate = sc.next();
				acc =new Account(AccNo,AccHolderName,balance,OpeningDate);
				i = dao.updateAccount(acc);
				if(i>0) {
					System.out.println("record updated");
				}
				break;
			case 4:
				System.out.println("Enter Account Number");
				AccNo=sc.nextInt();
				acc=new Account(AccNo);
				ArrayList<Account> list = dao.selectAccount(acc);
				for(Account e : list) {
					System.out.println(e);
				}
				break;
			case 5:
				ArrayList<Account> list1 = dao.selectAllAccount();
				for(Account e : list1) {
					System.out.println(e);
				}
				break;
			case 6:
				System.out.println("Enter Account Number");
				AccNo = sc.nextInt();
				System.out.println("Enter Withdrawal Amount");
				double debit=sc.nextDouble();
				acc=new Account(AccNo);
				i = dao.WithdrawAmount(acc,debit);
				if(i>0) {
					System.out.println("record updated");
				}else if(i==-1)
				{
					System.out.println("Insufficient Balance");
				}
				break;
			case 7:
				System.out.println("Enter Account Number");
				AccNo = sc.nextInt();
				System.out.println("Enter Deposit Amount");
				double credit=sc.nextDouble();
				acc=new Account(AccNo);
				i = dao.DepositAmount(acc,credit);
				if(i>0) {
					System.out.println("record updated");
				}
				break;
			case 8:
				System.out.println("Enter Account Number");
				AccNo = sc.nextInt();
				acc=new Account(AccNo);
				list = dao.CheckBalance(acc);
				for(Account e : list) {
					System.out.println(e);
				}
				break;
			default:
				break; 
			}
		}

	}

}
