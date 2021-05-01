package com.example.BitirmeProjesi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {

    private Long id;

    private String title;

    private String details;

    private String link;

    private String groupNo;
}
