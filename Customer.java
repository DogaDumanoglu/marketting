public class Customer {
    private String customerName;
    private String typeOfMembership;

    public Customer(String customerName, String typeOfMembership) {
        this.customerName=customerName;
        this.typeOfMembership=typeOfMembership;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public  String getTypeOfMembership() { return typeOfMembership; }
    public void setTypeOfMembership(String typeOfMembership) {
        this.typeOfMembership = typeOfMembership;
    }

}
