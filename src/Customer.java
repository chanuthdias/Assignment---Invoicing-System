public class Customer {
    private String customerName;
    private String customerID;
    private String email;
    private String address;
    private String contactNumber;
    private String dateOfBirth;
    private String gender;

    //constructor
    public Customer(String customerName, String customerID, String email, String address, String contactNumber, String dateOfBirth, String customerGender) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = customerGender;
    }

    //getters
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerID() {
        return customerID;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getGender() {
        return gender;
    }

    //setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    //Methods
    public void addCustomer() {}
    public void updateCustomer(){}
    public void removeCustomer() {}
    public Customer searchCustomer(String CustomerId) {return this;}

}