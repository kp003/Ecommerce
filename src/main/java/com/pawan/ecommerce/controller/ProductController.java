package com.pawan.ecommerce.controller;


import com.pawan.ecommerce.dto.ProductRequest;
import com.pawan.ecommerce.model.Product;
import com.pawan.ecommerce.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> create_product(@RequestBody ProductRequest productrequest){

        JSONObject jsonObject = new JSONObject();
        productService.createproduct(productrequest);
        jsonObject.put("status",200);
        jsonObject.put("message","successfully created product");

        return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
    }

    @GetMapping("/getAllproducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("getProductbyID/{id}")
    public Product getProductbyID(@PathVariable int id){
        return productService.getproductbyID(id);
    }

    @PutMapping("updateProduct/{id}")
    public  void updateProduct(@PathVariable int id, @RequestBody ProductRequest productRequest){

        Product product = productService.getproductbyID(id);

        productService.updateProduct(product,productRequest);

    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id){

        productService.deleteProduct(id);
    }
}
