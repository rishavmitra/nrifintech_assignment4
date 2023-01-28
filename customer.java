import java.util.Scanner;
public class customer implements Validation {
	
	Scanner in = new Scanner(System.in);
	String custName,userName,passCode,ssNumber,emAddr,addr;
	int age;
	Account acct;
	
	long phNum;
	float balAcc;
	
	int login()
	{
		System.out.print("Enter user name for login: ");
		String usr = in.next();
		System.out.print("Enter password: ");
		String pass = in.next();
		
		if(usr.equals(this.userName)&&pass.equals(passCode))
		{
			return 1;
		}
		else
			return 0;
	}
	int signUp() {
		System.out.println("Sign up first\n\n");
		System.out.print("Enter name: ");
		this.custName = in.nextLine();
		System.out.print("Enter user name for login: ");
		this.userName = in.nextLine();
		System.out.print("Enter password: ");
		this.passCode = in.nextLine();
		System.out.print("Enter SSN: ");
		this.ssNumber = in.nextLine();
		int fl = validateSSN();
		if(fl==0)
			return 0;
		System.out.print("Enter address: ");
		this.addr = in.nextLine();
		System.out.print("Enter email address: ");
		this.emAddr = in.nextLine();
		System.out.print("Enter age: ");
		this.age = in.nextInt();
		fl = validateAge();
		if(fl==0)
			return 0;
		System.out.print("Enter phone number: ");
		this.phNum = in.nextLong();
		
		System.out.println("Choose your account\n1.Savings\n(Any Key)Current\n");
		int op = in.nextInt();
		if(op==1)
			acct = new savings();
		else
			acct = new current();
		
		this.balAcc = 0;
		return 1;
	}
	void deposit() {
		System.out.println("Enter the amount to be deposited: ");
		float dep = in.nextFloat();
		
		this.balAcc = this.balAcc + dep;
	}
	void withdrawal(){
		System.out.println("Enter the amount to be withdrawn: ");
		float wid = in.nextFloat();
		
		if((this.balAcc-wid) <= acct.minimumBalance) {
			System.out.println("Insufficient Fund or reached minimum limit");
		}
		else {
			this.balAcc = this.balAcc - wid;
		}
	}
	void checkBal() {
		System.out.println("Balance: "+this.balAcc);
	}

	void passkey() {
		System.out.print("Enter old password:");
		String pas = in.next();
		if(pas.equals(this.passCode)) {
			System.out.print("Enter new password");
			this.passCode = in.next();
		}
		else {
			System.out.println("You Intruder...You not allowed");
		}
	}
	void editProfile() {
		System.out.print("Enter the field you would like to edit: ");
		String cs = in.next();
		switch (cs){
		case "name":
			System.out.print("Enter new "+cs+": ");
			in.nextLine();
			 this.custName= in.nextLine();
			 break;
		case "user name":
			System.out.print("Enter new "+cs+": ");
			in.nextLine();
			 this.userName= in.nextLine();
			 break;
		case "address":
			System.out.print("Enter new "+cs+": ");
			in.nextLine();
			this.addr= in.nextLine();
			break;
		case "SSN":
			System.out.print("Enter new "+cs+": ");
			in.nextLine();
			this.ssNumber= in.nextLine();
			break;
		case "email":
			System.out.print("Enter new "+cs+": ");
			in.nextLine();
			this.emAddr= in.nextLine();
			break;
		case "password":
			passkey();
			break;
		default:
			System.out.println("No such options");
			break;
		}
	}
	@Override
	public String toString() {
		return "customer [custName=" + custName + ", ssNumber=" + ssNumber + ", emAddr=" + emAddr + ", addr=" + addr
				+ ", age=" + age + ", phNum=" + phNum + "]";
	}
	@Override
	public int validateSSN() {
		if(this.ssNumber.toString().length()!=9)
		{
			System.out.println("SSN not valid");
			return 0;
		}
		return 1;
	}
	
	@Override
	public int validateAge() {
		if(this.age<=18)
		{
			System.out.println("Not valid age (Should be more than 18 years old)");
			in.nextLine();
			return 0;
		}
		return 1;
	}
	
}
