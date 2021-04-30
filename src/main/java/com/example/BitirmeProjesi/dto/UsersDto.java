package com.example.BitirmeProjesi.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
        private String username;
        private String firstName;
        private String lastName;
        private String mail;
        private String phone;
}
