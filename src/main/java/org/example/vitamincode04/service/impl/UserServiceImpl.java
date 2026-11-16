package org.example.vitamincode04.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.UserEntity;
import org.example.vitamincode04.mapper.UserMapper;
import org.example.vitamincode04.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    @Override
    public List<UserEntity> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public UserEntity getUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }

    @Override
    public UserEntity createUser(UserEntity userProfile) {
        int result = userMapper.insertUser(userProfile);
        if(result > 0) return userProfile;
        throw new RuntimeException("Tạo mới thất bại");
    }

    @Override
    public UserEntity updateUser(UserEntity userProfile) {
        int result = userMapper.updateUser(userProfile);
        if (result > 0) return userProfile;
        throw new RuntimeException("Chỉnh thất bại");
    }

    @Override
    public boolean deleteUserById(Integer id) {
        int result = userMapper.deleteUserById(id);
        if(result > 0) return true;
        throw new RuntimeException("Xóa Dữ liệu thất bại.");
    }

    @Override
    public List<Map<String, Object>> getAllThreeTable() {
        return userMapper.selectJoinThreeTable();
    }
}
