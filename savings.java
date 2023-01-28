
public class savings extends Account {
	
	savings(){
		this.minimumBalance = 500f;
		this.accountId = 1001;
		this.description="Savings account";
	}
	@Override
	public void display() {
		System.out.println("savings [accountId=" + accountId + ", description=" + description + ", minimumBalance=" + minimumBalance
				+ "]");
	}
}
