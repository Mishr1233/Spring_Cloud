package com.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products=new ArrayList<>();
 ProductDB db=new ProductDB();
    public void addProduct(Product p) {
       db.save(p);
    }

    public List<Product> getAllProducts() {
        return db.getAll();
    }


    public Product getProduct(String name) {
        for (Product product : db.getAll()) {
            if (product.name.equals(name) ) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductWithText(String txt) {
        List<Product> prods = new ArrayList<>();
        String str = txt.toLowerCase();
        for (Product p : products) {
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();

            if (name.contains(str) || type.contains(str) || place.contains(str)) {
                prods.add(p);
            }
        }

        return prods;
    }
}

