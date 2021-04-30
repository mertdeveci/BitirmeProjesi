package com.example.BitirmeProjesi.Api;

import com.example.BitirmeProjesi.Service.Implementations.CategoryImpelementation;
import com.example.BitirmeProjesi.dto.CategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryImpelementation categoryImpelementation;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryImpelementation categoryImpelementation, ModelMapper modelMapper) {
        this.categoryImpelementation = categoryImpelementation;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<CategoryDto> getOneBroadcast(@PathVariable(name = "id", required = true) Long id){
        CategoryDto categoryDto= categoryImpelementation.getById(id);

        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryImpelementation.getCategories());
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryImpelementation.create(categoryDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteBroadcast(@PathVariable(name = "id", required = true) Long id){
        return ResponseEntity.ok(categoryImpelementation.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable(name = "id", required = true) Long id,
            @Valid @RequestBody CategoryDto categoryDto){

        return ResponseEntity.ok(categoryImpelementation.update(id, categoryDto));
    }




}
