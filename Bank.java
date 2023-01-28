/*Output
Sign up first


Enter name: Rishav Mitra
Enter user name for login: rishav23
Enter password: rishav23
Enter SSN: 12345678
SSN not valid
Sign up first


Enter name: Rishav Mitra
Enter user name for login: rishav23
Enter password: rishav23
Enter SSN: 123456789
Enter address: Sikkim
Enter email address: rishavm@trainee.nrifintech.com
Enter age: 17
Not valid age (Should be more than 18 years old)
Sign up first


Enter name: Rishav Mitra
Enter user name for login: rishav23
Enter password: rishav23
Enter SSN: 123456789
Enter address: Sikkim
Enter email address: rishavm@trainee.nrifintech.com
Enter age: 23
Enter phone number: 9382699226
Choose your account
1.Savings
(Any Key)Current

1
Select option: 
1.Deposit
2.Withdrawal
3.Check balance
4.Change password
5.Edit profile
6.Display Profile details

6
customer [custName=Rishav Mitra, ssNumber=123456789, emAddr=rishavm@trainee.nrifintech.com, addr=Sikkim, age=23, phNum=9382699226]
Do you want to continue?
no
Enter user name for login: 
**/
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
