package com.lab.haer.controller;

import com.lab.haer.dto.CategoryDto;
import com.lab.haer.entity.Category;
import com.lab.haer.service.CategoryService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Object> createCategory(@RequestBody CategoryDto categoryDto) {
        try {
            final String result = categoryService.createCategory(categoryDto);
            return ResponseHandler.generateResponse("Successfully added Category!!", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

}
