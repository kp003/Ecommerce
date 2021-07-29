package com.pawan.ecommerce.controller;

import com.pawan.ecommerce.dto.CategoryRequest;
import com.pawan.ecommerce.model.Category;
import com.pawan.ecommerce.service.CategoryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public  ResponseEntity<?> create_product(@RequestBody CategoryRequest categoryrequest){

        JSONObject jsonObject= new JSONObject();
        categoryService.createCategory(categoryrequest);
        jsonObject.put("Status",200);
        jsonObject.put("message","Sucessfully added category");
        return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());

    }

    @GetMapping("/getallCategory")
    public List<Category> getallCategory(){

       return categoryService.getallCategory();
    }

    @GetMapping("/getCategory/{id}")
    public Category getCategory(@PathVariable int id){

        return categoryService.getCategory(id).get();
    }

    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

    @PutMapping("/updateCategory/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody CategoryRequest categoryRequest){

        Category category = categoryService.getCategory(id).get();
        categoryService.updateCategory(category,categoryRequest);


    }





    }



