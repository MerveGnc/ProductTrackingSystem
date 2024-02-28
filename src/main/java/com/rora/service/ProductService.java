package com.rora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rora.model.Product;
import com.rora.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public Optional<Product> getProductById2(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product saveProduct(Product product) {
    	return productRepository.save(product);  	
    	
    }
    
    public Product findProductById(Long id) {
    	return productRepository.findById(id).orElse(null);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    
    public void deleteProductByName(String productName) {
        Product product = productRepository.findByName(productName);
        if (product != null) {
            productRepository.delete(product);
        }
    }
    
    public void updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStockQuantity(updatedProduct.getStockQuantity());
            productRepository.save(product); // Güncelleme işlemini kaydedin
        } else {
            // Hata işlemleri veya yönlendirme yapılabilir
        }
    }
    
    




}
