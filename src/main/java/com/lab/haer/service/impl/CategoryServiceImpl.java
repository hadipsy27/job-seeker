package com.lab.haer.service.impl;

import com.lab.haer.config.ModelMapperConfig;
import com.lab.haer.dto.CategoryDto;
import com.lab.haer.entity.Category;
import com.lab.haer.repository.CategoryRepository;
import com.lab.haer.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CategoryServiceImpl.class);

    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapperConfig modelMapper;

    @SneakyThrows
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        final List<Category> categories = findCategories(List.of(categoryDto.getCode()));
        if (!categories.isEmpty()) throw new BadRequestException("Category Already Exists");

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setCode(categoryDto.getCode());

        LocalDateTime dateTime = LocalDateTime.now();

        category.setCreatedAt(dateTime);
        category.setUpdatedAt(dateTime);

        final Category categorySave = categoryRepository.save(category);
        LOGGER.info(category.toString());

        CategoryDto result = modelMapper.modelMapper().map(categorySave, CategoryDto.class);
        LOGGER.info(result.toString());

        return result;
    }

    @Override
    public List<Category> findCategories(List<String> categoryCodeList) {
        List<Category> categories = categoryRepository.findByCodeIn(categoryCodeList);
        return categories;
    }
}
