
public class current extends Account {

	current(){
		this.minimumBalance = 0f;
		this.accountId = 1001;
		this.description="Current account";
	}

	@Override
	public void display() {
		System.out.println("current [accountId=" + accountId + ", description=" + description + ", minimumBalance=" + minimumBalance
				+ "]");
	}
	
	
}
