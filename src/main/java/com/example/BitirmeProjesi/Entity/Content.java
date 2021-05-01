package com.example.BitirmeProjesi.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column
    private Date date;

    @Column(length = 200)
    private String details;

    @Column(length = 1000)
    private String link;

    @Column(length = 100)
    private String groupNo;



}
