package storage;

import model.Product;
import product_manager.ProductManager;

import java.io.*;
import java.util.*;

public class Manager implements ReadWritile{
    private Scanner scanner;
    private ProductManager productManager;
    public Manager(Scanner scanner, ProductManager productManager ){
       this.scanner=scanner;
       this.productManager=productManager;

    }

    public Manager() {
    }

    public  void writeListProduct(List<Product> products){
        File file = new File("list.txt");

        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(products);
            System.out.println("Dữ liệu đã được ghi vào tệp thành công.");

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin.");
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi ghi dữ liệu vào tệp tin.");
            e.printStackTrace();
        }

    }
    public  List<Product> readListProduct() {
        File file = new File("list.txt");
        List<Product>productList=null;
        try {
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            productList= (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;

    }
    public  void addProduct(){
        String id;
        String name;
        double cost=0.0;
        String brand;

        do{
            System.out.println("Nhap ma san pham:" );
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
    public void updateProduct(){
        List<Product> products=this.productManager.getAll();
        System.out.println("Nhap ma san pham muon chỉnh sua.");
        String id=scanner.nextLine();
        boolean check=false;
        for(Product product:products){
            if(product.getId().equals(id)){
                String newId;
                String newName;
                double newCost=0.0;
                String newBrand;

                do{
                System.out.println("Nhap ma moi cho san pham: "+ product.getId());
                newId=scanner.nextLine();
                if(newId.trim().isEmpty()){
                    System.out.println("ma san pham khong duoc de trong");
                }
                }while (newId.trim().isEmpty());

                do {
                    System.out.println("Nhap ten moi cho san pham: "+ product.getName());
                    newName=scanner.nextLine();
                    if(newName.trim().isEmpty()){
                        System.out.println("Ten san pham khong duoc de trong.");
                    }
                }while (newName.trim().isEmpty());

                boolean isNewCost=false;
                do {
                    System.out.println("Nhap gia moi cho san pham: "+product.getCost());
                    String cost=scanner.nextLine();
                    try{
                        newCost=Double.parseDouble(cost);
                        isNewCost=true;
                    }
                    catch (NumberFormatException e){
                        System.out.println("gia ban nhap khonh hop le.");
                    }
                }while (!isNewCost);

                do {
                    System.out.println("Nhap ten hang san xuat: "+product.getBrand());
                    newBrand=scanner.nextLine();
                    if (newBrand.trim().isEmpty()){
                        System.out.println("ten hang san xuat khong duoc de trong.");
                    }
                }while (newBrand.trim().isEmpty());

                product.setId(newId);
                product.setName(newName);
                product.setCost(newCost);
                product.setBrand(newBrand);
                writeListProduct(products);
                check=true;
            }
        }
        if (!check){
            System.out.println("Ma ban nhap khong dung.");
        }


    }
    public void deleteProduct(){
        List<Product> products=this.productManager.getAll();
        System.out.println("nhap ma san pham muon xoa.");
        String id=scanner.nextLine();
        boolean check=false;
        for(Product product:products){
            if(product.getId().equals(id)){
                products.remove(product);
                System.out.println("da xoa thanh cong");
                writeListProduct(products);
                check=true;
            }

        }
        if (!check){
            System.out.println("ma san pham khong dung");
        }
    }
    public void arrageList(){
        List<Product>products=this.productManager.getAll();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product1) {
                return Double.compare(product.getCost(), product1.getCost());
            }
        });
        writeListProduct(products);

    }

}
