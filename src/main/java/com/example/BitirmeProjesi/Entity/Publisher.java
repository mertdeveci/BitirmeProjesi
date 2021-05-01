package com.example.BitirmeProjesi.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Publisher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, unique = true)
    private String publisher_username;

    @Column(length = 100)
    private String mail;

    @Column(length = 100)
    private String phone;

    @Column(length = 100)
    private String webAdres;

    @Column(length = 100)
    private String logo;
}
