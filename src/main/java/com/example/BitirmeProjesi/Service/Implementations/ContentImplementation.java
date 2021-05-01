package com.example.BitirmeProjesi.Service.Implementations;

import com.example.BitirmeProjesi.Entity.Broadcast;
import com.example.BitirmeProjesi.Entity.Category;
import com.example.BitirmeProjesi.Entity.Content;
import com.example.BitirmeProjesi.Repository.ContentRepository;
import com.example.BitirmeProjesi.Service.ContentService;
import com.example.BitirmeProjesi.dto.BroadcastDto;
import com.example.BitirmeProjesi.dto.ContentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContentImplementation implements ContentService {

    private final ContentRepository contentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ContentImplementation(ContentRepository contentRepository, ModelMapper modelMapper) {

        this.contentRepository = contentRepository;
        this.modelMapper = modelMapper;
    }


    public ContentDto getById(Long id) {
        Content content = contentRepository.getOne(id);
        return modelMapper.map(content, ContentDto.class);
    }


    public List<ContentDto> getContents() {
        List<Content> contentList = contentRepository.findAll();
        List<ContentDto> contentDtos = new ArrayList<>();

        contentList.forEach(content -> contentDtos.add(modelMapper.map(content, ContentDto.class)));
        return contentDtos;
    }

    public ContentDto create(ContentDto contentDto) {
        Content content= modelMapper.map(contentDto, Content.class);
        contentRepository.save(content);
        return modelMapper.map(content, ContentDto.class);
    }

    public Boolean delete(Long id) {
        contentRepository.deleteById(id);
        return true;
    }


    public ContentDto update(Long id, ContentDto contentDto) {
        Content content= contentRepository.getOne(id);
        if (content==null)
            throw new NoSuchElementException("BROADCAST CANNOT BE FOUND !");
        content.setTitle(contentDto.getTitle());
        content.setLink(contentDto.getLink());
        content.setDetails(contentDto.getDetails());
        content.setGroupNo(contentDto.getGroupNo());

        contentRepository.save(content);
        content= contentRepository.getOne(id);
        return modelMapper.map(content, ContentDto.class);
    }
}
