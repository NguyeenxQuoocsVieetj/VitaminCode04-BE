package org.example.vitamincode04.entity;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Integer id;
    private String username;
    private String email;
    private RoleEntity role;
}
