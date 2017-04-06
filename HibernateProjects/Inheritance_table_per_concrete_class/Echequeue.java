
public class Echequeue extends BillingDetails {


		private String chequeue_number;
		private String routing_number;
		private static int account_number;
        static{
        	account_number=10;
        }
		/**
		 * No-arg constructor for JavaBean tools
		 */
		public Echequeue() { super(); }

		/**
		 * Full constructor.
		 *
		 * 
		 */
		public Echequeue(String owner, String number, String routing) 
		{
			super(owner);
			this.chequeue_number = number;
			this.routing_number = routing;
			
		}

		// ********************** Accessor Methods ********************** //

		

		public String getChequeue_number() { return chequeue_number; }

		public String getRouting_number() { return routing_number; }

	
		// ********************** Common Methods ********************** //

		public String toString() {
			return  "CreditCard ('" + getId() + "'), " +
					"Check No : '" + getChequeue_number() + ": Routing No "+getRouting_number();
		}
}
		

		
	


