import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		customer obj = new customer();
		ArrayList<customer> custArr= new ArrayList();
		int fl=0;
		while(fl!=1)
			fl = obj.signUp();
		
		custArr.add(obj);
		
		Scanner sc = new Scanner(System.in);
		String flag = "Yes";
		while(flag.toLowerCase().equals("yes")) {
			System.out.println("Select option: ");
			System.out.println("1.Deposit\n"+"2.Withdrawal\n"+"3.Check balance\n"+"4.Change password\n"+"5.Edit profile\n"+"6.Display Profile details\n");
			int cs = sc.nextInt();
			switch (cs){
			case 1:
				obj.deposit();
				break;
			case 2:
				obj.withdrawal();
				break;
			case 3:
				obj.checkBal();
				break;
			case 4:
				obj.passkey();
				break;
			case 5:
				obj.editProfile();
				break;
			case 6:
				System.out.println(obj);
				break;
			default:
				System.out.println("Invalid Input");
			}
			System.out.println("Do you want to continue?");
			flag = sc.next();
			if(flag.toLowerCase().equals("no"))
			{
				int check = 0;
				while(check == 0) {
				check = obj.login();
				if(check==0)
					System.out.println("User does not exist...Try again");
				else {
						obj.acct.display();
						flag = "Yes";
						break;
					}
				}
			}
		}
	}
}
