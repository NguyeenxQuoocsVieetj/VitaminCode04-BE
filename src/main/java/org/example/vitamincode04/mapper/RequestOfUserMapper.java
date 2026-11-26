package org.example.vitamincode04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.vitamincode04.entity.RequestOfUser;

import java.util.List;

@Mapper
public interface RequestOfUserMapper {
    List<RequestOfUser> selectRequestOfUsers();
    List<RequestOfUser> selectRequestOfUserFindByEmail(@Param("email") String email);
    List<RequestOfUser> selectRequestOfUserFindByQuestion(@Param("question") String question);
    int insertRequestOfUser(RequestOfUser requestEntity);
    int updateRequestOfUser(RequestOfUser requestEntity);
    int deleteRequestOfUser(@Param("userId") int id);
}
