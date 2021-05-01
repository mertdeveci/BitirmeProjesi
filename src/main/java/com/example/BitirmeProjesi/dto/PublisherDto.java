package com.example.BitirmeProjesi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {
    private String publisher_username;
    private String mail;
    private String webAdres;
}
