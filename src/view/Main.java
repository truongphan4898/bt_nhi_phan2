package view;

import product_manager.ProductManager;
import storage.Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager=new ProductManager();
        Scanner scanner=new Scanner(System.in);
        Manager function=new Manager(scanner,productManager);
        while (true){

                System.out.println("1. Add product");
                System.out.println("2. Display products");
                System.out.println("3. Search product by ID");
                System.out.println("4. Update Product");
                System.out.println("5. Delete Product");
                System.out.println("6. Arrage List Product By Cost");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        function.addProduct();
                        break;
                    case 2:
                        function.showProduct();
                        break;
                    case 3:
                        function.searchProduct();
                        break;
                    case 4:
                        function.updateProduct();
                        break;
                    case 5:
                        function.deleteProduct();
                        break;
                    case 6:
                        function.arrageList();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

    }

