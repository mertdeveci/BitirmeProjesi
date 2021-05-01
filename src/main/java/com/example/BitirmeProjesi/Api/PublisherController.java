package com.example.BitirmeProjesi.Api;


import com.example.BitirmeProjesi.Service.Implementations.PublisherImplementation;
import com.example.BitirmeProjesi.dto.CategoryDto;
import com.example.BitirmeProjesi.dto.PublisherDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherImplementation publisherImplementation;
    private final ModelMapper modelMapper;

    public PublisherController(PublisherImplementation publisherImplementation, ModelMapper modelMapper) {
        this.publisherImplementation = publisherImplementation;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<PublisherDto> getOnePublisher(
            @PathVariable(name = "id", required = true) Long id){
        PublisherDto publisherDto= publisherImplementation.getById(id);

        return ResponseEntity.ok(publisherDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PublisherDto>> getAllPublishers(){
        return ResponseEntity.ok(publisherImplementation.getPublishers());
    }

    @PostMapping("/create")
    public ResponseEntity<PublisherDto> createPublisher(
            @Valid @RequestBody PublisherDto publisherDto){
        return ResponseEntity.ok(publisherImplementation.create(publisherDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePublisher(@PathVariable(name = "id", required = true) Long id){
        return ResponseEntity.ok(publisherImplementation.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PublisherDto> updatePublisher(
            @PathVariable(name = "id", required = true) Long id,
            @Valid @RequestBody PublisherDto publisherDto){

        return ResponseEntity.ok(publisherImplementation.update(id, publisherDto));
    }
}
