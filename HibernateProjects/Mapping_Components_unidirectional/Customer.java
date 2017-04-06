




import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Customer implements Serializable, Comparable {
    public static final long serialVersionUID = 1;
    private Long id = null;
    private int version = 0;

    private String firstname;
    private String lastname;
    private String customerName; // Unique and immutable
    private String password;
    private String email;
    private int ranking = 0;

   

    private Address homeAddress;
    private Address billingAddress;
   

    private Date created = new Date();

    /**
     * No-arg constructor for JavaBean tools
     */
    public Customer() {}

    /**
     * Full constructor
     */
    public Customer(String firstname, String lastname, String customerName, String password, String email,
                 Address homeAddress, Address billingAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
        this.homeAddress = homeAddress;
        this.billingAddress = billingAddress;
        

   }

    /**
     * Simple constructor.
     */
    public Customer(String firstname, String lastname,
                String customerName, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
    }

    // ********************** Accessor Methods ********************** //

    public Long getId() { return id; }
    private void setId(Long id) { this.id=id; }
    public int getVersion() { return version; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getCustomerName() { return customerName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }


    public Address getHomeAddress() { return homeAddress; }
    public void setHomeAddress(Address homeAddress) { this.homeAddress = homeAddress; }

    public Address getBillingAddress() { return billingAddress; }
    public void setBillingAddress(Address billingAddress) { this.billingAddress = billingAddress; }

    
    public Date getCreated() { return created; }

    // ********************** Common Methods ********************** //

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        final Customer user = (Customer) o;
        return getCustomerName().equals(user.getCustomerName());
    }

    public int hashCode() {
        return getCustomerName().hashCode();
    }

    public String toString() {
        return  "User ('" + getId() + "'), " +
                "customerName: '" + getCustomerName() + "'";
    }

    public int compareTo(Object o) {
        if (o instanceof Customer)
            // Don't compare Date objects! Use the time in milliseconds!
            return Long.valueOf(this.getCreated().getTime()).compareTo(
                    Long.valueOf( ((Customer)o).getCreated().getTime())
                   );
        return 0;
    }

    // ********************** Business Methods ********************** //


}

