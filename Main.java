import java.util.ArrayList;
public class Main{
    public static void main(String[] args) throws Exception {
        String shoppingListPath = args[0];
        String priceListPath = args[1];
        ArrayList<PriceOfProducts>  pricesOfProduct = ReadFromFile.readPriceOfProducts(priceListPath);
        ArrayList<Bill> customerBills = ReadFromFile.readBills(shoppingListPath, pricesOfProduct);
        for (Bill bill : customerBills) {
            //Prints the bills using the information in the customerBills Array List.
            bill.printBill();
        }
    }
}


