//Write classes to hold Account, SB-Account and Current-Account details.
// [Here implement the concept of inheritance.]
// The common properties of the account are Account number, name and amount.
// Specifics of SB account is 4% interest to be paid per month.
// Implement the run-time polymorphism by creating base class variable and
//derived class object.
// Ask the user for which type of account to be created then create the corresponding account (Note: Use scanner class).
// Implement function overriding by having deposit and withdraw functions and perform the required action accordingly.
// Ensure base class can’t be instantiated. (Note: Abstract keyword canbe used).
// 2.Define the minimum balance for the both the type of accounts. Use final keyword to create constants.
// Ensure sb account class and current account class will cannot
// be used as base classes (Note: You can use final classes).

import java.util.Scanner;

abstract class Acc{
	long accno;
	String name;
	double balance;	
	
     public Acc() {
		
	}

	public Acc(long accno, String name, float balance) {
	
	this.accno = accno;
	this.name = name;
	this.balance = balance;
}

	//	deposit method defenition
	void deposit(float amt) {
		this.balance +=	amt;
		System.out.println("Rs."+amt+ "Credited | Balance: "+this.balance);
		}
	
	//withdraw method function
	void withdraw(float amt) {
		if(this.balance >= amt) {
			this.balance -= amt;
			System.out.println("Rs. "+amt+"debited | Balance: "+this.balance);
		}
		else {
			System.out.println("error: insufficient balance");
		}	
	}
	
	//to show account details
	void getDetails() {
		
		System.out.println("accno: "+this.accno+ " name "+this.name+" Balance "+this.balance);
		
	}
	
}

final class SB_Acc extends Acc{
	final float minbal = 500;
	void interest(int months) {
		balance = balance+ (months * 0.04);
	}
    void deposit(float amt) {
    	super.deposit(amt);
    }
	void withdraw(float amt) {
		super.withdraw(amt);
	}
}

final class CurrentAcc extends Acc{
     final float minbal = 1500;
	void deposit(float amt) {
    	super.deposit(amt);
    }
	void withdraw(float amt) {
		super.withdraw(amt);
	}
	
}

public class Oop {

	public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter the type of account you want to create :");
		String account_type = sc.next();
		
		
		Acc ac;	
		
		if (account_type.equalsIgnoreCase("SB"))
			ac = new SB_Acc();
		else
			ac = new CurrentAcc();
		
		
		
		System.out.println("Enter account number...");
		ac.accno = sc.nextLong();
		
		
		System.out.println("Enter Name...");
		ac.name = sc.next ();
	
		System.out.println("Enter Deposit...");
		float amount = sc.nextFloat();
		
		ac.getDetails();
		
		ac.deposit(amount);
		ac.deposit(1060);
		ac.withdraw(60);
		
		
		
		ac.getDetails();
		
			
					}

	}


