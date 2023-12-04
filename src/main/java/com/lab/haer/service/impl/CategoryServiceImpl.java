package com.lab.haer.service.impl;

import com.lab.haer.dto.CategoryDto;
import com.lab.haer.entity.Category;
import com.lab.haer.repository.CategoryRepository;
import com.lab.haer.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CategoryServiceImpl.class);

    private CategoryRepository categoryRepository;
    @SneakyThrows
    @Override
    public String createCategory(CategoryDto categoryDto) {

        final List<Category> categories = findCategories(List.of(categoryDto.getCode()));
        if (!categories.isEmpty()) throw new BadRequestException("Category Already Exists");

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setCode(categoryDto.getCode());

        LocalDateTime dateTime = LocalDateTime.now();
        category.setCreatedAt(dateTime);
        category.setUpdatedAt(dateTime);

        final Category save = categoryRepository.save(category);
        LOGGER.info(category.toString());

        return save.getName();
    }

    @Override
    public List<Category> findCategories(List<String> categoryCodeList) {
        List<Category> categories = categoryRepository.findByCodeIn(categoryCodeList);
        return categories;
    }
}
