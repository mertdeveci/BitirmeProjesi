package com.example.BitirmeProjesi.Service.Implementations;

import com.example.BitirmeProjesi.Entity.Broadcast;
import com.example.BitirmeProjesi.Repository.BroadcastRepository;
import com.example.BitirmeProjesi.Service.BroadcastService;
import com.example.BitirmeProjesi.dto.BroadcastDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BroadcastImplementation implements BroadcastService {
    private final BroadcastRepository broadcastRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BroadcastImplementation(BroadcastRepository broadcastRepository, ModelMapper modelMapper) {
        this.broadcastRepository = broadcastRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BroadcastDto> getAllBroadcasts() {
        List<Broadcast> broadcastList = broadcastRepository.findAll();
        List<BroadcastDto> broadcastDtos = new ArrayList<>();

        broadcastList.forEach(broadcast -> broadcastDtos.add(modelMapper.map(broadcast, BroadcastDto.class)));
        return broadcastDtos;
    }


    public BroadcastDto getById(Long id){
        Broadcast broadcast = broadcastRepository.getOne(id);
        return modelMapper.map(broadcast, BroadcastDto.class);
    }

    public BroadcastDto create(BroadcastDto broadcastDto) {
        Broadcast broadcast= modelMapper.map(broadcastDto, Broadcast.class);
        broadcast=broadcastRepository.save(broadcast);
        return modelMapper.map(broadcast, BroadcastDto.class);
    }

    public Boolean delete(Long id) {
        broadcastRepository.deleteById(id);
        return true;
    }

    public BroadcastDto update(Long id, BroadcastDto broadcastDto) {
        Broadcast broadcast= broadcastRepository.getOne(id);
        if (broadcast==null)
            throw new NoSuchElementException("BROADCAST CANNOT BE FOUND !");

        broadcast.setBroadcast_name(broadcastDto.getBroadcast_name());
        broadcastRepository.save(broadcast);
        broadcast= broadcastRepository.getOne(id);
        return modelMapper.map(broadcast, BroadcastDto.class);
    }
}
