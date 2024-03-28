package product_manager;

import model.Product;
import storage.Function;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    public void addProduct(Product product) {
        List<Product> products = Function.readListProduct();
        products.add(product);
        Function.writeListProduct(products);
    }


    public List<Product> getAll() {
        List<Product> products = Function.readListProduct();
        return products;
    }

//    public void init() {
//        List<Product> products = Function.readListProduct();
//        products.add(new Product("123", "Iphone", 10000, "Apple"));
//        Function.writeListProduct(products);
//    }
}
