package org.example.vitamincode04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.vitamincode04.entity.UserEntity;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<UserEntity> selectAllUser();
    UserEntity selectUserByUserName(@Param("username") String username);
    int insertUser(UserEntity userProfile);
    int updateUser(UserEntity userProfile);
    int deleteUserById(@Param("userId") Integer id);

    List<Map<String, Object>> selectJoinThreeTable();
}
