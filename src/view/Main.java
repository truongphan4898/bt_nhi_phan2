package view;

import model.Product;
import product_manager.ProductManager;
import storage.Function;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager=new ProductManager();
        Scanner scanner=new Scanner(System.in);
        Function  function=new Function(scanner,productManager);
        while (true){

                System.out.println("1. Add product");
                System.out.println("2. Display products");
                System.out.println("3. Search product by ID");
                System.out.println("4. Exit");
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
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
//                    case 5:
//                        function.initialList();
//                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

    }

