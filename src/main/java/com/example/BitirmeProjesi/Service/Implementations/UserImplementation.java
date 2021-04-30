package com.example.BitirmeProjesi.Service.Implementations;

import com.example.BitirmeProjesi.Entity.Users;
import com.example.BitirmeProjesi.Repository.UserRepository;
import com.example.BitirmeProjesi.Service.UserService;
import com.example.BitirmeProjesi.dto.UsersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserImplementation implements UserService {

    private final UserRepository usersRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserImplementation(UserRepository userRepository, ModelMapper modelMapper) {
        this.usersRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public UsersDto getByUsername(String username) {
        Users user = usersRepository.getOne( username );
        return modelMapper.map(user, UsersDto.class);
    }

    public List<UsersDto> getUsers() {
        List<Users> users = usersRepository.findAll();
        List<UsersDto> usersDtos = new ArrayList<>();

        users.forEach(user -> usersDtos.add(modelMapper.map(user, UsersDto.class)));
        return usersDtos;
    }


    public UsersDto create(UsersDto usersDto) {
        Users user = modelMapper.map(usersDto, Users.class);
        user = usersRepository.save(user);
        return  modelMapper.map(user, UsersDto.class);
    }

    public Boolean delete(UsersDto user) {
        usersRepository.deleteById(user.getUsername());
        return true;
    }

    public UsersDto update(UsersDto usersDto) {
        Users user = usersRepository.getOne(usersDto.getUsername());
        if (user==null)
            throw new NoSuchElementException("USER CANNOT BE FOUND ");

        user.setFirstName(usersDto.getFirstName());
        user.setLastName(usersDto.getLastName());
        user.setMail(usersDto.getMail());
        user.setPhone(usersDto.getPhone());

        user = usersRepository.save(user);
        return  modelMapper.map(user, UsersDto.class);
    }
}
