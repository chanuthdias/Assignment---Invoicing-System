import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manager {
    ManageProduct mp = new ManageProduct();
    ManageCustomer mc = new ManageCustomer();
    InvoiceGenerator ig = new InvoiceGenerator();

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Customers");
            System.out.println("3. Invoice Generation");
            System.out.println("4. Admin Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ManageProducts();
                case 2:
                    ManageCustomers();
                    break;
                case 3:
                    invoiceGenerate();
                    break;
                case 4:
                    showLogs();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
    public void ManageProducts() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nManage Products");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Search Product");
            System.out.println("5. View all Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    mp.addProduct();
                    break;
                case 2:
                    mp.removeProduct();
                    break;
                case 3:
                    mp.updateProduct();
                    break;
                case 4:
                    mp.searchProduct();
                    break;
                case 5:
                    mp.displayAllProducts();
                    break;
                case 6:
                    System.out.println();
                    start();
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
    public void ManageCustomers() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nManage Customer");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Search Customer");
            System.out.println("5. Display Customer details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    mc.addCustomer();
                    break;
                case 2:
                    mc.removeCustomer();
                    break;
                case 3:
                    mc.updateCustomer();
                    break;
                case 4:
                    mc.searchCustomer();
                    break;
                case 5:
                    mc.displayAllCustomers();
                    break;
                case 6:
                    start();
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
    public void invoiceGenerate() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nInvoice Generator");
            System.out.println("1. Remove an Invoice");
            System.out.println("2. Add a Invoice");
            System.out.println("3. Show all Invoices");
            System.out.println("4. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    ig.removeInvoice();
                    break;
                case 2:
                    ig.addInvoice(mc, mp);
                    break;
                case 3:
                    ig.getAllInvoices();
                    break;
                case 4:
                    start();
                default:
                    System.out.println("Invalid choice\n");
            }
            break;
        }
    }
    public void showLogs() {
        Connection con = null;
        Statement stmt = null;
        String log = null;
        ResultSet rs;

        try {
            con = DatabaseConnector.getConnection();
            String queryString = "select * from logs";
            stmt = con.createStatement();
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                log = rs.getString("logEntry");
                System.out.println(log);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}