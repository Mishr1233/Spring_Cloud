package com.cg.ProductSpringWeb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDB extends JpaRepository<Product,Integer> {
Product findByName(String name);
}
