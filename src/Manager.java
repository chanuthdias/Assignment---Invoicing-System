import java.util.Scanner;

public class Manager {
    ManageProduct pm = new ManageProduct();
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
                    System.out.println("2. Manage Customers");
                    break;
                case 3:
                    System.out.println("3. Invoice Generation");
                    break;
                case 4:
                    System.out.println("4. Admin Tasks");
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
                    pm.addProduct();
                    break;
                case 2:
                    pm.removeProduct();
                    break;
                case 3:
                    pm.updateProduct();
                    break;
                case 4:
                    //pm.searchProduct();
                    break;
                case 5:
                    pm.displayAllProducts();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
}
