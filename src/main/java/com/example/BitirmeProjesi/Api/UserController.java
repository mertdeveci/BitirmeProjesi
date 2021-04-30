package com.example.BitirmeProjesi.Api;

import com.example.BitirmeProjesi.Service.Implementations.UserImplementation;
import com.example.BitirmeProjesi.dto.UsersDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserImplementation usersImplementation;
    private final ModelMapper modelMapper;


    public UserController(UserImplementation userImplementation, ModelMapper modelMapper) {
        this.usersImplementation = userImplementation;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<UsersDto> getOneUser(
            @PathVariable(name = "id", required = true) String username){
        UsersDto usersDto= usersImplementation.getByUsername(username);

        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        return ResponseEntity.ok(usersImplementation.getUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<UsersDto> createUser(
            @Valid @RequestBody UsersDto usersDto){
        return ResponseEntity.ok(usersImplementation.create(usersDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteUser(@Valid @RequestBody UsersDto user){
        return ResponseEntity.ok(usersImplementation.delete(user));
    }


    @PutMapping("/update")
    public ResponseEntity<UsersDto> updateUser(
            @Valid @RequestBody UsersDto usersDto){

        return ResponseEntity.ok(usersImplementation.update(usersDto));
    }




}
