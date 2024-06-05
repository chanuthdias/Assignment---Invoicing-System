import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceGenerator {
    public void invoiceGenerate(ManageCustomer mc, ManageProduct mp) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> invoiceProducts = new ArrayList<>();

        Customer c;

        System.out.println("Invoice Generator");
        System.out.print("Enter Invoice Number: ");
        String invoiceNumber = input.next();
        System.out.print("Enter Invoice Date: ");
        String invoiceDate = input.next();
        while (true) {
            System.out.print("Enter Customer ID: ");
            String customerID = input.next();
            c = mc.getCustomerByID(customerID);
            if (c == null) {
                System.out.println("Customer Not Found");
            } else {
                mc.displayCustomer(c);
                break;
            }
        }

        Invoice iInvoiceNumber = new Invoice(invoiceNumber, invoiceDate, c.getCustomerName(), c.getCustomerID());

        mp.displayAllProducts();
        while (true) {
            Product p;
            System.out.print("Enter Product ID: ");
            String productID = input.next();
            System.out.print("Enter How many products you want to buy: ");
            int numberOfProducts = input.nextInt();
            System.out.print("Enter Discount Amount: ");
            int discountAmount = input.nextInt();

            p = mp.getProductByID(productID);

            if (p == null) {
                System.out.println("Product Not Found please enter another product ID");
            }
            else {
                if (p.getQuantity() >= numberOfProducts) {
                    iInvoiceNumber.addProduct(p.getProductName(), p.getProductId(), p.getQuantity(), numberOfProducts, discountAmount);
                    System.out.print("Do you want to add this to the list? If so, please enter yes else no here: ");
                    mp.updateQuantity(p.getProductId(), p.getQuantity() - numberOfProducts);
                }
                else {
                    System.out.println("No quantity");
                    System.out.print("Do you want to add more quantity? If so, please enter yes else no here: ");
                }
            }
            String choice = input.next();

            if (choice != "yes" || choice != "YES") {

                break;
            }
        }
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnector.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String queryString = "INSERT INTO Invoice (invoiceNumber, invoiceDate, customerName, customerID, productIDList, productNameList, unitsPerProductList, unitPriceList, discountList) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(queryString);
            pstmt.setString(1, iInvoiceNumber.getInvoiceNumber());
            pstmt.setString(2, iInvoiceNumber.getInvoiceDate());
            pstmt.setString(3, iInvoiceNumber.getCustomerName());
            pstmt.setString(4, iInvoiceNumber.getCustomerID());

            // Convert lists to comma-separated strings
            pstmt.setString(5, String.join("\n", iInvoiceNumber.getProductIDList()));
            pstmt.setString(6, String.join("\n", iInvoiceNumber.getProductNameList()));
            pstmt.setString(7, convertListToString(iInvoiceNumber.getUnitsPerProductList()));
            pstmt.setString(8, convertListToString(iInvoiceNumber.getUnitPriceList()));
            pstmt.setString(9, convertListToString(iInvoiceNumber.getDiscountList()));

            int i = pstmt.executeUpdate();
            System.out.println("Invoice successfully inserted!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getAllInvoices() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;

        try {
            con = DatabaseConnector.getConnection();
            String queryString = "SELECT * FROM Invoice";
            stmt = con.createStatement();
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                String invoiceNumber = rs.getString("invoiceNumber");
                String invoiceDate = rs.getString("invoiceDate");
                String customerName = rs.getString("customerName");
                String customerID = rs.getString("customerID");
                String productIDList = rs.getString("productIDList");
                String productNameList = rs.getString("productNameList");
                String unitsPerProductList = rs.getString("unitsPerProductList");
                String unitPriceList = rs.getString("unitPriceList");
                String discountList = rs.getString("discountList");

                System.out.println("Invoice Number: " + invoiceNumber);
                System.out.println("Invoice Date: " + invoiceDate);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Customer ID: " + customerID);
                System.out.println("Product ID List: " + productIDList);
                System.out.println("Product Name List: " + productNameList);
                System.out.println("Units Per Product List: " + unitsPerProductList);
                System.out.println("Unit Price List: " + unitPriceList);
                System.out.println("Discount List: " + discountList);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String convertListToString(ArrayList<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object item : list) {
            sb.append(item.toString()).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);  // Remove the last comma
        }
        return sb.toString();
    }
}