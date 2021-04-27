import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
    private Customer customer;
    private Date shoppingDate;
    private List<Product> purchasedItems;

    public Bill(Customer customer, Date shoppingDate) {
        this.shoppingDate = shoppingDate;
        this.customer = customer;
        this.purchasedItems = new ArrayList<>();
    }

    public void addPurchasedItem(Product product) {
        this.purchasedItems.add(product);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer; }
    public Date getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(Date shoppingDate) {
        this.shoppingDate = shoppingDate;}

    /*printBill function prints Customer name, purchased products,
     *the price of the products, how many were bought from the products,
     *total price of one product and finally the total bill price on the screen.*/

    public void printBill(){
        System.out.println("---"+customer.getCustomerName()+"---");
        double totalBillPrice = 0;
        for(Product product : purchasedItems){
            double totalProductPrice = product.getPrice() * product.getQuantity();
            totalBillPrice += totalProductPrice;
            System.out.println(product.getProductName()+"\t"+product.getPrice()+"\t"+product.getQuantity()+"\t"+totalProductPrice);
        }
        System.out.println("Total\t"+String.format(java.util.Locale.US,"%.1f",totalBillPrice));
        // Prints only one digit after comma.(Note: if second digit(after comma) is bigger than 5 it rounds to first digit (after comma)).

    }
}