package com.example.BitirmeProjesi.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Users implements Serializable {
    @Id
    @Column(length = 50, unique = true)
    private String username;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50)
    private String mail;

    @Column(length = 50)
    private String phone;

    @Column(length = 50)
    private String password;


}
