package com.example.BitirmeProjesi.Service.Implementations;

import com.example.BitirmeProjesi.Entity.Platform;
import com.example.BitirmeProjesi.Repository.PlatformRepository;
import com.example.BitirmeProjesi.Service.PlatformService;
import com.example.BitirmeProjesi.dto.PlatformDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlatformImplementation implements PlatformService {
    private final PlatformRepository platformRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlatformImplementation(PlatformRepository platformRepository, ModelMapper modelMapper) {
        this.platformRepository = platformRepository;
        this.modelMapper = modelMapper;
    }

    public PlatformDto getById(Long id) {
        Platform platform= platformRepository.getOne(id);
        return modelMapper.map(platform, PlatformDto.class);
    }

    public List<PlatformDto> getPlatforms() {
        List<Platform> platformList = platformRepository.findAll();
        List<PlatformDto> platformDtos = new ArrayList<>();
        platformList.forEach(platform -> platformDtos.add(modelMapper.map(platform, PlatformDto.class)));

        return platformDtos;
    }

    public PlatformDto create(PlatformDto platformDto) {
        Platform platform= modelMapper.map(platformDto, Platform.class);
        System.out.println("******\n"+platform+"*****\n");
        platform = platformRepository.save(platform);

        return modelMapper.map(platform, PlatformDto.class);
    }

    public Boolean delete(Long id) {
        platformRepository.deleteById(id);
        return true;
    }

    public PlatformDto update(Long id, PlatformDto platformDto) {
        Platform platform = platformRepository.getOne(id);

        if (platform==null)
            throw new NoSuchElementException("PLATFORM CANNOT BE FOUND !");

        platform.setPlatform_name(platformDto.getPlatform_name());
        platformRepository.save(platform);
        platform = platformRepository.getOne(id);
        return  modelMapper.map(platform, PlatformDto.class);
    }
}
