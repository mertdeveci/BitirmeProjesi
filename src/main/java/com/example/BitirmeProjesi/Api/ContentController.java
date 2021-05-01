package com.example.BitirmeProjesi.Api;

import com.example.BitirmeProjesi.Entity.Content;
import com.example.BitirmeProjesi.Service.Implementations.ContentImplementation;
import com.example.BitirmeProjesi.dto.CategoryDto;
import com.example.BitirmeProjesi.dto.ContentDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("content")
public class ContentController {

    private final ContentImplementation contentImplementation;
    private final ModelMapper modelMapper;


    public ContentController(ContentImplementation contentImplementation, ModelMapper modelMapper) {
        this.contentImplementation = contentImplementation;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/getOne/{id}")
    public ResponseEntity<ContentDto> getOneContent(
            @PathVariable(name = "id", required = true) Long id){
        ContentDto contentDto= contentImplementation.getById(id);

        return ResponseEntity.ok(contentDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ContentDto>> getAllContents(){
        return ResponseEntity.ok(contentImplementation.getContents());
    }

    @PostMapping("/create")
    public ResponseEntity<ContentDto> createContent(
            @Valid @RequestBody ContentDto contentDto){
        return ResponseEntity.ok(contentImplementation.create(contentDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteContent(
            @PathVariable(name = "id", required = true) Long id){
        return ResponseEntity.ok(contentImplementation.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContentDto> updateContent(
            @PathVariable(name = "id", required = true) Long id,
            @Valid @RequestBody ContentDto contentDto){

        return ResponseEntity.ok(contentImplementation.update(id, contentDto));
    }



}
