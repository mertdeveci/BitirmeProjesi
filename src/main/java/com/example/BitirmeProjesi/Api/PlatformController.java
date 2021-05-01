package com.example.BitirmeProjesi.Api;

import com.example.BitirmeProjesi.Service.Implementations.PlatformImplementation;
import com.example.BitirmeProjesi.dto.CategoryDto;
import com.example.BitirmeProjesi.dto.PlatformDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/platform")
public class PlatformController {
    private final PlatformImplementation platformImplementation;
    private final ModelMapper modelMapper;


    public PlatformController(PlatformImplementation platformImplementation, ModelMapper modelMapper) {
        this.platformImplementation = platformImplementation;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<PlatformDto> getOnePlatform(@PathVariable(name = "id", required = true) Long id){
        PlatformDto platformDto= platformImplementation.getById(id);

        return ResponseEntity.ok(platformDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PlatformDto>> getAllPlatforms(){
        return ResponseEntity.ok(platformImplementation.getPlatforms());
    }

    @PostMapping("/create")
    public ResponseEntity<PlatformDto> createPlatform(
            @Valid @RequestBody PlatformDto platformDto){
        return ResponseEntity.ok(platformImplementation.create(platformDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePlatform(@PathVariable(name = "id", required = true) Long id){
        return ResponseEntity.ok(platformImplementation.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlatformDto> updatePlatform(
            @PathVariable(name = "id", required = true) Long id,
            @Valid @RequestBody PlatformDto platformDto){

        return ResponseEntity.ok(platformImplementation.update(id, platformDto));
    }
}
