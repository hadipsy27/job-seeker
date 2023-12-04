package com.lab.haer.service;

import com.lab.haer.dto.CategoryDto;
import com.lab.haer.entity.Category;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CategoryService {

    public String createCategory(CategoryDto categoryDto);

    public List<Category> findCategories(List<String> categoryCodeList) throws BadRequestException;

}
