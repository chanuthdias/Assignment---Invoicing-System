import java.util.ArrayList;

public class Invoice {
    private String invoiceNumber;
    private String invoiceDate;
    private String customerName;
    private String customerID;
    private ArrayList<String> productIDList;
    private ArrayList<String> productNameList;
    private ArrayList<Double> unitsPerProductList;
    private ArrayList<Double> unitPriceList;
    private ArrayList<Double> discountList;

    //constructor
    public Invoice(String invoiceNumber, String invoiceDate, String customerName, String customerID) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.customerID = customerID;

        this.productIDList = new ArrayList<>();
        this.productNameList = new ArrayList<>();
        this.unitsPerProductList = new ArrayList<>();
        this.unitPriceList = new ArrayList<>();
        this.discountList = new ArrayList<>();
    }

    //getters
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public String getInvoiceDate() {
        return invoiceDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerID() {
        return customerID;
    }
    public ArrayList<String> getProductIDList() {
        return productIDList;
    }
    public ArrayList<String> getProductNameList() {
        return productNameList;
    }
    public ArrayList<Double> getUnitsPerProductList() {
        return unitsPerProductList;
    }
    public ArrayList<Double> getUnitPriceList() {
        return unitPriceList;
    }
    public ArrayList<Double> getDiscountList() {
        return discountList;
    }

    //setters
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void addProduct(String name, String id, double numUnits, double unitPrice, double discount) {
        productNameList.add(name);
        productIDList.add(id);
        unitsPerProductList.add(numUnits);
        unitPriceList.add(unitPrice);
        discountList.add(discount);
    }
}
