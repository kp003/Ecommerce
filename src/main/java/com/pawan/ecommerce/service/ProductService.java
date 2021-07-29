package com.pawan.ecommerce.service;

import com.pawan.ecommerce.dto.ProductRequest;
import com.pawan.ecommerce.model.Product;
import com.pawan.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public void createproduct(ProductRequest productrequest) {

        Product product = new Product();
        product.setName(productrequest.getName());
        product.setDescription(productrequest.getDescription());
        product.setCategory(productrequest.getCategory());
        product.setPrice(productrequest.getPrice());
        product.setQuantity(productrequest.getQuantity());
        product.setCreated_by(productrequest.getCreated_by());

        productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getproductbyID(int id) {

        return productRepo.findById(id).get();
    }

    public void updateProduct(Product product, ProductRequest productRequest) {
        product.setCreated_by(productRequest.getCreated_by());
        product.setCategory(productRequest.getCategory());
        product.setQuantity(productRequest.getQuantity());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());

        productRepo.save(product);
    }

    public void deleteProduct(int id) {

        productRepo.deleteById(id);
    }
}
