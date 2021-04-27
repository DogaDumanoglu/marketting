import java.util.Date;
import java.util.List;

public class PriceOfProducts {
    private String productName;
    private String typeOfMembershipOfProduct;
    private Date startDate;
    private Date endDate;
    private Double price;
    public PriceOfProducts(String productName, String typeOfMembershipOfProduct,Date startDate,Date endDate,Double price) {
        this.productName=productName;
        this.typeOfMembershipOfProduct=typeOfMembershipOfProduct;
        this.startDate=startDate;
        this.endDate=endDate;
        this.price=price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTypeOfMembershipOfProduct() { return typeOfMembershipOfProduct; }

    public void setTypeOfMembershipOfProduct(String typeOfMembershipOfProduct) { this.typeOfMembershipOfProduct = typeOfMembershipOfProduct; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    /* FindPriceForDate function finds the price of the products by using the customers
    information and the date of shopping. It finds the price of purchsed products from the  product price list*/

    public static Double FindPriceForDate(List<PriceOfProducts> productPrices, String  productName, String typeOfMembership, Date shoppingDate) throws Exception {
        for (PriceOfProducts productPrice : productPrices) {
            if (productPrice.getProductName().equals(productName) && typeOfMembership.equals(productPrice.typeOfMembershipOfProduct) &&
                    (shoppingDate.after(productPrice.startDate) || shoppingDate.equals(productPrice.startDate)) && (shoppingDate.before(productPrice.endDate) || shoppingDate.equals(productPrice.endDate))) {
                return productPrice.getPrice();
            }
        }

        throw new Exception("Not Found");
    }
}
