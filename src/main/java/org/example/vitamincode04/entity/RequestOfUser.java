package org.example.vitamincode04.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestOfUser {
    private Integer id;
    private String username;
    private String email;
    private String question;
    private UserEntity users;
    private String status;
}