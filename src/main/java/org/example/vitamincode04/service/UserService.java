package org.example.vitamincode04.service;

import org.example.vitamincode04.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserEntity> getAllUser();
    UserEntity getUserByUserName(String username);
    UserEntity createUser(UserEntity userProfile);
    UserEntity updateUser(UserEntity userProfile);
    boolean deleteUserById(Integer id);

    List<Map<String, Object>> getAllThreeTable();
}
