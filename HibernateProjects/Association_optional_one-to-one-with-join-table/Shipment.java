
public class Shipment {
	private Item auction;//nullable
	private Long id = null;
    private int version = 0;

    private Address deliveryAddress;

	public Item getAuction() {
		return auction;
	}

	public void setAuction(Item auction) {
		this.auction = auction;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

    

}
