package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

//        service.addProduct(new Product("Ashush", "laptop", "table", 2023));
//        service.addProduct(new Product("Apple keyboard", "keyboard", "table", 2023));
//        service.addProduct(new Product("mouse", "mouse", "black drower", 2021));
//        service.addProduct(new Product("black pen", "pen", "table", 2029));
//        service.addProduct(new Product("macbook", "laptop", "drower", 2020));
//        service.addProduct(new Product("apple mouse", "mouse", "black table", 2024));


//         List<Product> products = service.getAllProducts();
//         for (Product product : products) {
//             System.out.println(product);
//         }

        System.out.println("=====================================================");

        System.out.println("a particular product");

        Product p=   service.getProduct("apple mouse");

        System.out.println(p);
//
//        System.out.println("=====================================================");
//        System.out.println("a particular txt");
//
//        List<Product>prods =service.getProductWithText("black");
//        for (Product p1 : prods) {
//            System.out.println(p1);
//        }
      }
}
