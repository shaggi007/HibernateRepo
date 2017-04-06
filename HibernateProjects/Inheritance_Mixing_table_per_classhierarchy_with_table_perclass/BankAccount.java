
public class BankAccount extends BillingDetails {

	private String account;
	private String bankname;
	private String swift;

	/**
	 * No-arg constructor for JavaBean tools
	 */
	public BankAccount() { super(); }


	public BankAccount(String owner, String account, String bankname, String swift) {
		super(owner);
		this.account = account;
		this.bankname = bankname;
		this.swift = swift;
	}

	// ********************** Accessor Methods ********************** //

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getBankname() { return bankname; }
    public void setBankname(String bankname) { this.bankname = bankname; }

    public String getSwift() { return swift; }
	public void setSwift(String swift) { this.swift = swift; }

	// ********************** Common Methods ********************** //

	public String toString() {
		return  "BankAccount ('" + getId() + "'), " +
				"Account: '" + getAccount() + "'";
	}

	

}


