import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageCustomer {
    public void addCustomer(){
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
        System.out.println("Enter Customer ID: ");
        String customerID = input.next();
        System.out.println("Enter Customer name: ");
        String customerName = input.next();
        System.out.println("Enter Customer Email: ");
        String customerEmail = input.next();
        System.out.println("Enter Customer address: ");
        String customerAddress = input.next();
        System.out.println("Enter Customer Contact Number: ");
        String customerContactNumber = input.next();
        System.out.println("Enter Customer Date of Birth: ");
        String CustomerDOB = input.next();
        System.out.println("Enter Customers Gender: ");
        String customerGender = input.next();

        String queryString = "INSERT INTO Customer (customerID,customerName,email,address,contactNumber,dateOfBirth,gender) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(queryString);
            pstmt.setString(1, customerID);
            pstmt.setString(2, customerName);
            pstmt.setString(3, customerEmail);
            pstmt.setString(4, customerAddress);
            pstmt.setString(5, customerContactNumber);
            pstmt.setString(6, CustomerDOB);
            pstmt.setString(7, customerGender);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            int i = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer ID to update: ");
        String customerID = input.next();
        String newCustomerID = "";
        String customerName = "";
        String customerEmail = "";
        String customerAddress = "";
        String customerContactNumber = "";
        String customerDOB = "";
        String customerGender = "";
        String updateQuery = null;

        while (true) {
            System.out.println("\nChange Menu");
            System.out.println("1. Customer ID");
            System.out.println("2. Customer Name");
            System.out.println("3. Customer Email Address");
            System.out.println("4. Customer Address");
            System.out.println("5. Customer Contact Number");
            System.out.println("6. Customer Date of Birth");
            System.out.println("7. Customer Gender");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new Customer ID: ");
                    newCustomerID = input.next();
                    updateQuery = "UPDATE Customer SET customerID = ? WHERE customerID = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, newCustomerID);
                        pstmt.setString(2, customerID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("CustomerID updated successfully.");
                        } else {
                            System.out.println("CustomerID not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Enter new Customer name: ");
                    customerName = input.next();
                    updateQuery = "UPDATE Customer SET customerName = ? WHERE customerID = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, customerName);
                        pstmt.setString(2, customerID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Customer Name updated successfully.");
                        } else {
                            System.out.println("Customer Name not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Enter Customer Email: ");
                    customerEmail = input.next();
                    updateQuery = "UPDATE Customer SET email = ? WHERE customerID = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, customerEmail);
                        pstmt.setString(2, customerID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Customer Email updated successfully.");
                        } else {
                            System.out.println("Customer Email not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Enter Customer Address: ");
                    customerAddress = input.next();
                    updateQuery = "UPDATE Customer SET address = ? WHERE customerID = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, customerAddress);
                        pstmt.setString(2, customerID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Customer Address updated successfully.");
                        } else {
                            System.out.println("Customer Address not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Enter Customer Contact Number: ");
                    customerContactNumber = input.next();
                    updateQuery = "UPDATE Customer SET contactNumber = ? WHERE customerID = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, customerContactNumber);
                        pstmt.setString(2, customerID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Customer Contact Number updated successfully.");
                        } else {
                            System.out.println("Customer Contact Number not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Enter Customer Date of birth: ");
                    customerDOB = input.next();
                    updateQuery = "UPDATE Customer SET dateOfBirth = ? WHERE customerID = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, customerDOB);
                        pstmt.setString(2, customerID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Customer Date of birth updated successfully.");
                        } else {
                            System.out.println("Customer Date of birth not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Enter Customer Gender: ");
                    customerDOB = input.next();
                    updateQuery = "UPDATE Customer SET gender = ? WHERE customerID = ?";
                    try (Connection conn = DatabaseConnector.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setString(1, customerGender);
                        pstmt.setString(2, customerID);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Customer Gender updated successfully.");
                        } else {
                            System.out.println("Customer Gender not found.");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
    public void removeCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer ID to remove: ");
        String customerID = input.next();

        String deleteQuery = "DELETE FROM Customer WHERE customerID = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            pstmt.setString(1, customerID);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer removed successfully.");
            } else {
                System.out.println("Customer not found.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void searchCustomer() {
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        while (true) {
            System.out.println("\nSearch Menu");
            System.out.println("1. Search by Customer ID");
            System.out.println("2. Search by Customer Name");
            System.out.println("3. Search by Customer Email");
            System.out.println("4. Search by Customer Address");
            System.out.println("5. Search by Customer Contact Number");
            System.out.println("6. Search by Customer Date of Birth");
            System.out.println("7. Search by Customer Gender");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();  // Consume newline left-over
            String query = "";
            String searchValue = "";

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Customer WHERE customerID = ?";
                    break;
                case 2:
                    System.out.print("Enter Customer Name: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Customer WHERE customerName = ?";
                    break;
                case 3:
                    System.out.print("Enter Customer Email: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Customer WHERE email = ?";
                    break;
                case 4:
                    System.out.print("Enter Customer Address: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Customer WHERE address = ?";
                    break;
                case 5:
                    System.out.print("Enter Customer Contact Number: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Customer WHERE contactNumber = ?";
                    break;
                case 6:
                    System.out.print("Enter Customer Date of birth: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Customer WHERE dateOfBirth = ?";
                    break;
                case 7:
                    System.out.print("Enter Customer Gender: ");
                    searchValue = input.nextLine();
                    query = "SELECT * FROM Customer WHERE gender = ?";
                    break;
                case 8:
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

                ArrayList<Customer> customers = new ArrayList<>();
                while (rs.next()) {
                    String customerID = rs.getString("customerID");
                    String customerName = rs.getString("customerName");
                    String customerEmail = rs.getString("email");
                    String customerAddress = rs.getString("address");
                    String customerContactNumber = rs.getString("contactNumber");
                    String CustomerDOB = rs.getString("dateOfBirth");
                    String CustomerGender = rs.getString("gender");

                    Customer customer = new Customer(customerID, customerName, customerEmail, customerAddress, customerContactNumber, CustomerDOB,CustomerGender);
                    customers.add(customer);
                }

                if (customers.isEmpty()) {
                    System.out.println("No products found.");
                } else {
                    for (Customer customer : customers) {
                        displayCustomerDetails();
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
    public void displayCustomerDetails() {
        ArrayList<Customer> customers = getAllCustomers();
        System.out.println("\nCUSTOMER DETAILS : ");
        for (int i = 0; i < customers.size(); i++) {
            Customer tempCustomer = customers.get(i);
            System.out.println(i+1);
            System.out.println("----------------------------------");
            System.out.print("Customer ID : ");
            System.out.println(tempCustomer.getCustomerID());
            System.out.print("Customer Name : ");
            System.out.println(tempCustomer.getCustomerName());
            System.out.print("Customer Email address : ");
            System.out.println(tempCustomer.getEmail());
            System.out.print("Customer Address : ");
            System.out.println(tempCustomer.getAddress());
            System.out.print("Customer Contact Number : ");
            System.out.println(tempCustomer.getContactNumber());
            System.out.print("Customer date of Birth : ");
            System.out.println(tempCustomer.getDateOfBirth());
            System.out.print("Customer Gender : ");
            System.out.println(tempCustomer.getGender());
            System.out.println();
        }
    }
    public ArrayList getAllCustomers() {
        Connection con = null;
        Statement stmt = null;

        String customerName = null;
        String customerID = null;
        String customerEmail = null;
        String customerAddress = null;
        String customerContactNumber = null;
        String CustomerDOB = null;
        String CustomerGender = null;
        ArrayList customers = new ArrayList();
        ResultSet rs;

        try {
            con = DatabaseConnector.getConnection();
            String queryString = "select * from customer";
            stmt = con.createStatement();
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                customerID = rs.getString("customerID");
                customerName = rs.getString("customerName");
                customerEmail = rs.getString("email");
                customerAddress = rs.getString("address");
                customerContactNumber = rs.getString("contactNumber");
                CustomerDOB = rs.getString("dateOfBirth");
                CustomerGender = rs.getString("gender");

                Customer c = new Customer(customerID,customerName,customerEmail,customerAddress,customerContactNumber,CustomerDOB,CustomerGender);
                customers.add(c);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public Customer getCustomerByID(String customerID) {
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Customer customer = null;

        String query = "SELECT * FROM Customer WHERE customerID = ?";

        try {
            conn = DatabaseConnector.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, customerID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String invoiceCustomerID = rs.getString("customerID");
                String customerName = rs.getString("customerName");
                String customerEmail = rs.getString("email");
                String customerAddress = rs.getString("address");
                String customerContactNumber = rs.getString("contactNumber");
                String CustomerDOB = rs.getString("dateOfBirth");
                String CustomerGender = rs.getString("gender");

                customer = new Customer(invoiceCustomerID, customerName, customerEmail, customerAddress, customerContactNumber, CustomerDOB, CustomerGender);

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
        return customer;
    }
    public void displayCustomer(Customer customer) {
        // Implement the display logic here
        System.out.println("\nCustomer Details:");
        System.out.println("Customer ID: " + customer.getCustomerID());
        System.out.println("Name: " + customer.getCustomerName());
        System.out.println();
    }
}