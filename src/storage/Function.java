package storage;

import model.Product;
import product_manager.ProductManager;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Function {
    private Scanner scanner;
    private ProductManager productManager;
    public Function(Scanner scanner,ProductManager productManager ){
       this.scanner=scanner;
       this.productManager=productManager;

    }
    public static void writeListProduct(List<Product> products){
        File file = new File("list.txt");

        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(products);
            System.out.println("Dữ liệu đã được ghi vào tệp thành công.");

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi ghi dữ liệu vào tệp tin.");
            e.printStackTrace();
        }

    }
    public static List<Product> readListProduct(){
        File file=new File("list.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInputStream= null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            return (List<Product>) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public  void addProduct(){
        String id;
        String name;
        double cost=0.0;
        String brand;

        do{
            System.out.println(" Nhap ten san pham:" );
            id=scanner.nextLine();
            if(id.trim().isEmpty()){
                System.out.println("ma san pham khong duoc de trong.");
            }
        }while (id.trim().isEmpty());

        do{
            System.out.println("Nhap ten san pham:");
            name=scanner.nextLine();
            if(name.trim().isEmpty()){
                System.out.println("Ten san pham khong duoc de trong.");
            }
        }while (name.trim().isEmpty());

        boolean isCost=true;
        do{
            System.out.println("Nhap gia san pham:");
            String inputCost=scanner.nextLine();
            try{
                cost=Double.parseDouble(inputCost);
                isCost=false;
            }catch (NumberFormatException e){
                System.out.println("gia ban nhap khong hop le.");
            }
        }while (isCost);

        do{
            System.out.println("Nhap hang san xuat.");
            brand=scanner.nextLine();
            if(brand.trim().isEmpty()){
                System.out.println("Ten hang khong duoc dee trong.");
            }
        }while (brand.trim().isEmpty());
        Product product= new Product(id,name,cost,brand);
       productManager.addProduct(product);
       System.out.println("San pham da them thanh cong.");

    }
    public void searchProduct(){
        List<Product> products = this.productManager.getAll();
        System.out.println("nhap ma san pham can tim ");
        String id=scanner.nextLine();
        boolean check= true;
        for(Product product:products){
            if(product.getId().equals(id)){
                System.out.println(product.toString());
                check=false;
                break;
            }

        }
        if(check){
            System.out.println("ma ban nhap khong dung.");
        }

    }
    public void showProduct(){
        List<Product> products = this.productManager.getAll();
        for(Product product:products){
            System.out.println(product.getId()+", "+product.getName()+", "+product.getCost()+", "+product.getBrand());
        }

    }

//    public void initialList() {
//        this.productManager.init();
//    }
}
