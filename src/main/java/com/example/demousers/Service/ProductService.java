package com.example.demousers.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demousers.Repositoy.ProductRepository;
import com.example.demousers.User.Product;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductsId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> allProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product updateProduct(Long id, Product updateProduct) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }

        System.out.println("Before Update: " + product);

        product.setName_product(updateProduct.getName_product());
        product.setDescription(updateProduct.getDescription());
        product.setPrice(updateProduct.getPrice());

        System.out.println("After Update (Before Save): " + product);

        Product updatedProduct = productRepository.save(product);

        System.out.println("After Save: " + updatedProduct);

        return updatedProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}