package org.talent.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talent.todolist.domain.HttpResponse;
import org.talent.todolist.dto.NewCategoryRequest;
import org.talent.todolist.entity.Category;
import org.talent.todolist.service.CategoryService;

import java.util.List;

@RestController  // By using this, every methods will returns a domain object instead of a view. shorthand for @Controller and @ResponseBody
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/categories")
    public ResponseEntity<HttpResponse> saveNewCategory(@RequestBody NewCategoryRequest request) {  // @RequestBody annotation is used to bind the parameter with the body of the HTTP request
        Category category = categoryService.saveNewCategory(request);
//        categoryService.saveNewCategory(request);
        HttpResponse httpResponse = new HttpResponse(category, HttpStatus.CREATED);
        return new ResponseEntity<>(httpResponse, HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = categoryService.findAll();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

//    @DeleteMapping("/categories/{id}")
//    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
//        categoryService.delete(id);
//
//        return new ResponseEntity<>("Author Deleted By Id " + id, HttpStatus.NO_CONTENT);
//    }


}
