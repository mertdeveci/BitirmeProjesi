package com.example.BitirmeProjesi.Service.Implementations;

import com.example.BitirmeProjesi.Entity.Category;
import com.example.BitirmeProjesi.Repository.CategoryRepository;
import com.example.BitirmeProjesi.Service.CategoryService;
import com.example.BitirmeProjesi.dto.CategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryImpelementation implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryImpelementation(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDto> getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryList.forEach(category -> categoryDtos.add(modelMapper.map(category, CategoryDto.class)));
        return categoryDtos;
    }

    public CategoryDto create(CategoryDto categoryDto) {
        Category category= modelMapper.map(categoryDto, Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category, CategoryDto.class);
    }

    public CategoryDto getById(Long id) {
        Category category= categoryRepository.getOne(id);
        return modelMapper.map(category, CategoryDto.class);
    }


    public Boolean delete(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.getOne(id);

        if (category==null)
            throw new NoSuchElementException("BROADCAST CANNOT BE FOUND !");

        category.setCategory_name(categoryDto.getCategory_name());
        categoryRepository.save(category);
        category= categoryRepository.getOne(id);
        return  modelMapper.map(category, CategoryDto.class);
    }
}
