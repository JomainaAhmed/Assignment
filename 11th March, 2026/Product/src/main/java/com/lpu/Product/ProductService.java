package com.lpu.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductEntity saveProduct(ProductEntity product) {
        return repository.save(product);
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    public ProductEntity getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
    
    public ProductEntity savePro(ProductEntity product) {
    	return repository.save(product);
    }
}