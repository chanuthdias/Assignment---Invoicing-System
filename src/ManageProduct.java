import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageProduct {

    public void addProduct(){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnector.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        String productID = input.next();
        System.out.println("Enter product name: ");
        String productName = input.next();
        System.out.println("Enter description: ");
        String productDescription = input.next();
        System.out.println("Enter purchase price: ");
        double productPurchasePrice = input.nextDouble();
        System.out.println("Enter selling price: ");
        double productSellingPrice = input.nextDouble();
        System.out.println("Enter quantity: ");
        int productQuantity = input.nextInt();

        String queryString = "INSERT INTO Product (productId, productName, description, purchasePrice, sellingPrice, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(queryString);
        try {
            pstmt = conn.prepareStatement(queryString);
            pstmt.setString(1, productID);
            pstmt.setString(2, productName);
            pstmt.setString(3, productDescription);
            pstmt.setDouble(4, productPurchasePrice);
            pstmt.setDouble(5, productSellingPrice);
            pstmt.setInt(6, productQuantity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            int i = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayAllProducts() {
        ArrayList<Product> products = getAllProducts();
        System.out.println("\nPRODUCTS : ");
        for (int i = 0; i < products.size(); i++) {
            Product tempProduct = products.get(i);
            System.out.println(i+1);
            System.out.println("----------------------------------");
            System.out.print("Product ID : ");
            System.out.println(tempProduct.getProductId());
            System.out.print("Product Name : ");
            System.out.println(tempProduct.getProductName());
            System.out.print("Product Description : ");
            System.out.println(tempProduct.getDescription());
            System.out.print("Product Purchase Price : ");
            System.out.println(tempProduct.getPurchasePrice());
            System.out.print("Product Selling Price : ");
            System.out.println(tempProduct.getSellingPrice());
            System.out.print("Product Quantity : ");
            System.out.println(tempProduct.getQuantity());
            System.out.println();
        }
    }
    public void updateProduct(){

    }
    public void removeProduct() {

    }
    //public Product searchProduct(String productId) {}
    public ArrayList getAllProducts() {
        Connection con = null;
        Statement stmt = null;

        String productId = null;
        String productName = null;
        String description = null;
        double purchasePrice = 0.0;
        double sellingPrice = 0.0;
        int quantity = 0;
        ArrayList products = new ArrayList();
        ResultSet rs;

        try {
            con = DatabaseConnector.getConnection();
            String queryString = "select * from product";
            stmt = con.createStatement();
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                productId = rs.getString("productId");
                productName = rs.getString("productName");
                description = rs.getString("description");
                purchasePrice = Double.parseDouble(rs.getString("purchasePrice"));
                sellingPrice = Double.parseDouble(rs.getString("sellingPrice"));
                quantity = Integer.parseInt(rs.getString("quantity"));

                Product p = new Product(productId, productName, description,purchasePrice,sellingPrice,quantity);
                products.add(p);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}