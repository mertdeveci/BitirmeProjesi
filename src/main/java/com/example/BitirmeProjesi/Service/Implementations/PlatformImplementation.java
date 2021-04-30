package com.example.BitirmeProjesi.Service.Implementations;

import com.example.BitirmeProjesi.Entity.Broadcast;
import com.example.BitirmeProjesi.Entity.Platform;
import com.example.BitirmeProjesi.Repository.PlatformRepository;
import com.example.BitirmeProjesi.Service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformImplementation implements PlatformService {
    private final PlatformRepository platformRepository;

    @Autowired
    public PlatformImplementation(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

}
