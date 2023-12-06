package com.lab.haer.controller;

import com.lab.haer.dto.CategoryDto;
import com.lab.haer.service.CategoryService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Object> createCategory(@RequestBody CategoryDto categoryDto) {
        try {
            final CategoryDto result = categoryService.createCategory(categoryDto);
            return ResponseHandler.generateResponse("Successfully added Category!!", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/category")
    private ResponseEntity<Object> findCategories() {
        try {
            final List<CategoryDto> result = categoryService.getAllCategory();
            return ResponseHandler.generateResponse("Success to get all Category!!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/category/{code}")
    public ResponseEntity<Object> findCategoryByCode(@PathVariable("code") String code) {
        try {
            final CategoryDto result = categoryService.findCategoryByCode(code);
            return ResponseHandler.generateResponse("Successfully added Category!!", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

}
