package com.example.BitirmeProjesi.Api;

import com.example.BitirmeProjesi.Service.Implementations.BroadcastImplementation;
import com.example.BitirmeProjesi.dto.BroadcastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/broadcast")
public class BroadcastController {

    private final BroadcastImplementation broadcastImplementation;

    @Autowired
    public BroadcastController(BroadcastImplementation broadcastImplementation) {
        this.broadcastImplementation = broadcastImplementation;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BroadcastDto>> getAllBroadcasts(){
        return ResponseEntity.ok(broadcastImplementation.getAllBroadcasts());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<BroadcastDto> getOneBroadcast(@PathVariable(name = "id", required = true) Long id){
        BroadcastDto broadcastDto= broadcastImplementation.getById(id);

        return ResponseEntity.ok(broadcastDto);
    }

   @PostMapping("/create")
   public ResponseEntity<BroadcastDto> createBroadCast(
           @Valid @RequestBody BroadcastDto broadcastDto){
        return ResponseEntity.ok(broadcastImplementation.create(broadcastDto));
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Boolean> deleteBroadcast(@PathVariable(name = "id", required = true) Long id){
        return ResponseEntity.ok(broadcastImplementation.delete(id));
   }


   @PutMapping("/update/{id}")
    public ResponseEntity<BroadcastDto> updateBroadcast(
            @PathVariable(name = "id", required = true) Long id,
            @Valid @RequestBody BroadcastDto broadcastDto){

        return ResponseEntity.ok(broadcastImplementation.update(id, broadcastDto));
   }

}
