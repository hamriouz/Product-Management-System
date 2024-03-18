package edu.webclass.restapi.Product.Management.System.repository;

import edu.webclass.restapi.Product.Management.System.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductRepository {
    public static ArrayList<Product> products= new ArrayList<>();
    public static int lastIndex=0;

    public ProductRepository() {
        products.add(new Product("Mobile","Samsung", 50000000));
        products.add(new Product("Cacke","TITOP!",10000));
    }

    public boolean createNewProduct(Product product) {
        products.add(product);
        if (ProductRepository.lastIndex == ProductRepository.products.size()) {
            return true;
        } else {
            return false;
        }
    }

    public List<Product> findAllProducts(){
        return products;
    }

    public Product findProduct(String id) {
        return products.stream().filter(p -> Objects.equals(id, p.id)).findAny().orElse(null);
    }

}
