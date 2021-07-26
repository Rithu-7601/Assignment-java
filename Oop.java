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
	float minbal = 500;
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
      float minbal = 1500;
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


