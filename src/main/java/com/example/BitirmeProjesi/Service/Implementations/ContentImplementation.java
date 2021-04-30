package com.example.BitirmeProjesi.Service.Implementations;

import com.example.BitirmeProjesi.Entity.Content;
import com.example.BitirmeProjesi.Repository.ContentRepository;
import com.example.BitirmeProjesi.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentImplementation implements ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    public ContentImplementation(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }


}
