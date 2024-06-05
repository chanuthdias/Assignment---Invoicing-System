public class Product {
    private String productId;
    private String productName;
    private String description;
    private double purchasePrice;
    private double sellingPrice;
    private int quantity;

    //invoice
    private double unitPrice;
    private int availableQuantity;

    // Constructor
    public Product(String productId, String productName, String description, double purchasePrice, double sellingPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    //getters
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getDescription() {
        return description;
    }
    public double getPurchasePrice() {
        return purchasePrice;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
    public int getQuantity() {
        return quantity;
    }

    //invoice
    public double getUnitPrice() {
        return unitPrice;
    }
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    //setters
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //invoice
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}