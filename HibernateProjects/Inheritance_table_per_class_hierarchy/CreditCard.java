public class CreditCard extends BillingDetails {


	private String card_number;
	private String expMonth;
	private String expYear;

	/**
	 * No-arg constructor for JavaBean tools
	 */
	public CreditCard() { super(); }

	/**
	 * Full constructor.
	 *
	 * @param owner
	 * @param user
	 * @param expMonth
	 * @param expYear
	 */
	public CreditCard(String owner, String number, String expMonth, String expYear) 
	{
		super(owner);
		this.card_number = number;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}

	// ********************** Accessor Methods ********************** //

	

	public String getNumber() { return card_number; }

	public String getExpMonth() { return expMonth; }

	public String getExpYear() { return expYear; }

	// ********************** Common Methods ********************** //

	public String toString() {
		return  "CreditCard ('" + getId() + "'), " +
				"Expiry: '" + getExpMonth() + ":"+getExpYear();
	}

	

	
}
