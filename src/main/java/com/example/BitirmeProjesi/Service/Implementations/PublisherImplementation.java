package com.example.BitirmeProjesi.Service.Implementations;


import com.example.BitirmeProjesi.Entity.Category;
import com.example.BitirmeProjesi.Entity.Publisher;
import com.example.BitirmeProjesi.Repository.PublisherRepository;
import com.example.BitirmeProjesi.Service.PublisherService;
import com.example.BitirmeProjesi.dto.CategoryDto;
import com.example.BitirmeProjesi.dto.PublisherDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PublisherImplementation implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PublisherImplementation(PublisherRepository publisherRepository, ModelMapper modelMapper) {
        this.publisherRepository = publisherRepository;
        this.modelMapper = modelMapper;
    }

    public PublisherDto getById(Long id) {
        Publisher publisher= publisherRepository.getOne(id);
        return modelMapper.map(publisher, PublisherDto.class);
    }

    public List<PublisherDto> getPublishers() {
        List<Publisher> publisherList = publisherRepository.findAll();
        List<PublisherDto> publisherDtos = new ArrayList<>();
        publisherList.forEach(publisher -> publisherDtos.add(modelMapper.map(publisher, PublisherDto.class)));
        return publisherDtos;
    }

    public PublisherDto create(PublisherDto publisherDto) {
        Publisher publisher= modelMapper.map(publisherDto, Publisher.class);
        publisher = publisherRepository.save(publisher);
        return modelMapper.map(publisher, PublisherDto.class);
    }


    public Boolean delete(Long id) {
        publisherRepository.deleteById(id);
        return true;
    }

    public PublisherDto update(Long id, PublisherDto publisherDto) {
        Publisher publisher = publisherRepository.getOne(id);

        if (publisher==null)
            throw new NoSuchElementException("BROADCAST CANNOT BE FOUND !");

        publisher.setPublisher_username(publisherDto.getPublisher_username());
        publisher.setWebAdres(publisherDto.getWebAdres());
        publisher.setMail(publisherDto.getMail());
        publisherRepository.save(publisher);
        publisher = publisherRepository.getOne(id);
        return  modelMapper.map(publisher, PublisherDto.class);
    }
}
