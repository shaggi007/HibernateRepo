
	import java.io.Serializable;
	import java.util.Date;

	/**
	 * This is the  superclass for CreditCard,Echequeue,BankTransfer.
	*/
	public class BillingDetails {

		private Long id = null;
	    private String owner;
		

		private Date created = new Date();

		/**
		 * No-arg constructor for JavaBean tools
		 */
		public BillingDetails() {}


	    /**
	     * Full constructor
	     */
	    protected BillingDetails(String owner) {
	        this.owner = owner;
	    
	    }

	    // ********************** Accessor Methods ********************** //

	    public Long getId() { return id; }
	    
	    public String getOwner() { return owner; }
	    public void setOwner(String owner) { this.owner = owner; }

	    

		public Date getCreated() { return created; }

		// ********************** Common Methods ********************** //

	    // TODO: This is not a very good equals() implementation
	    public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof BillingDetails)) return false;

			final BillingDetails billingDetails = (BillingDetails) o;

	        if (! (created.getTime() == billingDetails.created.getTime()) ) return false;
			if (!getOwner().equals(billingDetails.getOwner())) return false;

			return true;
		}

		public int hashCode() {
			int result;
			result = getCreated().hashCode();
			result = 29 * result + getOwner().hashCode();
			return result;
		}

		

		// ********************** Business Methods ********************** //

		

	}


