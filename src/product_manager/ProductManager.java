package product_manager;

import model.Product;
import storage.Manager;
import storage.ReadWritile;

import java.util.List;

public class ProductManager {
    public static ReadWritile readWritile=new Manager();



    public void addProduct(Product product) {
        List<Product> products = readWritile.readListProduct();
        products.add(product);
        readWritile.writeListProduct(products);
    }


    public List<Product> getAll() {
        List<Product> products = readWritile.readListProduct();
        return products;
    }

}
