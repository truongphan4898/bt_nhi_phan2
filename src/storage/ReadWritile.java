package storage;

import model.Product;

import java.util.List;

public interface ReadWritile {
   void writeListProduct(List<Product> products);
    List<Product> readListProduct();
}
