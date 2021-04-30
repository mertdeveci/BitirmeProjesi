package com.example.BitirmeProjesi.Service.Implementations;


import com.example.BitirmeProjesi.Entity.Publisher;
import com.example.BitirmeProjesi.Repository.PublisherRepository;
import com.example.BitirmeProjesi.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherImplementation implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherImplementation(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

}
