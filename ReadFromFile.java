import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadFromFile {

    /*ReadFromFile function reads the lines from the file. Returns the list.
     *if a problem is encountered throws IOException.*/
    public static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /*readPriceOfProducts function takes the Product List as parameter
     * and calls the readFile function to read the pricelist.txt.
     * Separate the lines according to the tab.It sets type of products,
     * membership, start and end date in which the price is valid,
     * its price to the class PriceOfProducts.
     *Finally it returns an ArrayList for PriceOfProducts.*/


    public static ArrayList<PriceOfProducts> readPriceOfProducts(String priceListPath) throws ParseException {
        List<String> lines = readFile(priceListPath);
        ArrayList<PriceOfProducts>  priceOfProductsArrayList= new ArrayList<>();
        for (String line : Objects.requireNonNull(lines)) {
            String[] productInfosArray = line.split("\t");
            String typeOfProduct=productInfosArray[0];
            String typeOfMembershipOfProduct=productInfosArray[1];
            Date startDate=new SimpleDateFormat("d.M.y").parse(productInfosArray[2]);
            Date endDate=new SimpleDateFormat("d.M.y").parse(productInfosArray[3]);
            Double price=Double.parseDouble(productInfosArray[4]);
            PriceOfProducts priceOfProducts= new PriceOfProducts(typeOfProduct,typeOfMembershipOfProduct,startDate,endDate,price);
            priceOfProductsArrayList.add(priceOfProducts);
        }
        return priceOfProductsArrayList;
    }
    /* readBills takes the Shopping List and priceOfProductsArrayList
     * (which is created by readPriceOfProducts Function)as a parameter,
     * and calls the readFile function to read shoppingList.txt.
     * Separate the lines according to the tab.Then sets the properties Product Class.
     * Sets products to the list called PurchasedItem in the bill class.Then it sets the
     * PurchasedItem Array list to named bill Array list and returns that list. */

    public static ArrayList<Bill> readBills(String shoppingListPath, ArrayList<PriceOfProducts> priceOfProducts) throws Exception {
        List<String> lines = readFile(shoppingListPath);
        ArrayList<Bill> bills = new ArrayList<>();
        for (String line : Objects.requireNonNull(lines)) {
            String[] customerInfosArray = line.split("\t");
            String customerName = customerInfosArray[0];

            String typeOfMembership = customerInfosArray[1];
            Date shoppingDate = new SimpleDateFormat("d.M.y").parse(customerInfosArray[2]);
            Customer customer = new Customer(customerName, typeOfMembership);
            Bill bill = new Bill(customer, shoppingDate);
            for (int i = 3; i < customerInfosArray.length; i++) {
                String productName = customerInfosArray[i];
                int quantity = Integer.parseInt(customerInfosArray[++i]);
                Double price = PriceOfProducts.FindPriceForDate(priceOfProducts, productName, typeOfMembership, shoppingDate);
                Product product = new Product(productName, price, quantity);

                bill.addPurchasedItem(product);
            }
            bills.add(bill);
        }
        return bills;
    }
}
