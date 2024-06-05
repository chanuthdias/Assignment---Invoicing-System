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
    public void updateProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter product ID to update: ");
        String productID = input.next();
        String newProductID = "";
        String productName = "";
        String productDescription = "";
        double productPurchasePrice = 0.0;
        double productSellingPrice = 0.0;
        int productQuantity = 0;
        String updateQuery = null;

        while (true) {
            System.out.println("\nChange Menu");
            System.out.println("1. Product ID");
            System.out.println("2. Product Name");
            System.out.println("3. description");
            System.out.println("4. purchase price");
            System.out.println("5. selling price");
            System.out.println("6. quantity");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new product ID: ");
                    newProductID = input.next();
                    updateQuery = "UPDATE Product SET productId = ? WHERE productId = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, newProductID);
                        pstmt.setString(2, productID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Enter new product name: ");
                    productName = input.next();
                    updateQuery = "UPDATE Product SET productName = ? WHERE productId = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, productName);
                        pstmt.setString(2, productID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Enter new description: ");
                    productDescription = input.next();
                    updateQuery = "UPDATE Product SET description = ? WHERE productId = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, productDescription);
                        pstmt.setString(2, productID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Enter new purchase price: ");
                    productPurchasePrice = input.nextDouble();
                    updateQuery = "UPDATE Product SET purchasePrice = ? WHERE productId = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setDouble(1, productPurchasePrice);
                        pstmt.setString(2, productID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Enter new selling price: ");
                    productSellingPrice = input.nextDouble();
                    updateQuery = "UPDATE Product SET sellingPrice = ? WHERE productId = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setDouble(1, productSellingPrice);
                        pstmt.setString(2, productID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Enter new quantity: ");
                    productQuantity = input.nextInt();
                    updateQuery = "UPDATE Product SET quantity = ? WHERE productId = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setInt(1, productQuantity);
                        pstmt.setString(2, productID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
    public void removeProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter product ID to remove: ");
        String productID = input.next();

        String deleteQuery = "DELETE FROM Product WHERE productId = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            pstmt.setString(1, productID);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product removed successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void searchProduct() {
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        while (true) {
            System.out.println("\nSearch Menu");
            System.out.println("1. Search by Product ID");
            System.out.println("2. Search by Product Name");
            System.out.println("3. Search by Purchase Price");
            System.out.println("4. Search by Selling Price");
            System.out.println("5. Search by Quantity");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();  // Consume newline left-over
            String query = "";
            String searchValue = "";

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Product WHERE productId = ?";
                    break;
                case 2:
                    System.out.print("Enter Product Name: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Product WHERE productName = ?";
                    break;
                case 3:
                    System.out.print("Enter Purchase Price: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Product WHERE purchasePrice = ?";
                    break;
                case 4:
                    System.out.print("Enter Selling Price: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Product WHERE sellingPrice = ?";
                    break;
                case 5:
                    System.out.print("Enter Quantity: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Product WHERE quantity = ?";
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice\n");
                    continue;
            }

            try {
                conn = DatabaseConnector.getConnection();
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, searchValue);
                rs = pstmt.executeQuery();

                ArrayList<Product> products = new ArrayList<>();
                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    double purchasePrice = rs.getDouble("purchasePrice");
                    double sellingPrice = rs.getDouble("sellingPrice");
                    int quantity = rs.getInt("quantity");

                    Product product = new Product(productId, productName, description, purchasePrice, sellingPrice, quantity);
                    products.add(product);
                }

                if (products.isEmpty()) {
                    System.out.println("No products found.");
                } else {
                    for (Product product : products) {
                        displayProductDetails(product);
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void displayProductDetails(Product product) {
        System.out.println("\nProduct ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Purchase Price: " + product.getPurchasePrice());
        System.out.println("Selling Price: " + product.getSellingPrice());
        System.out.println("Quantity: " + product.getQuantity());
        System.out.println("----------------------------------");
    }
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

    public Product getProductByID(String productID) {
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Product product = null;

        String query = "SELECT * FROM Product WHERE productId = ?";

        try {
            conn = DatabaseConnector.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, productID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                double purchasePrice = rs.getDouble("purchasePrice");
                double sellingPrice = rs.getDouble("sellingPrice");
                int quantity = rs.getInt("quantity");

                product = new Product(productId, productName, description, purchasePrice, sellingPrice, quantity);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }
    public void updateQuantity(String prductID, double quantity) {
        String updateQuery = null;
        updateQuery = "UPDATE Product SET quantity = ? WHERE productId = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setInt(1, (int) quantity);
            pstmt.setString(2, prductID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}