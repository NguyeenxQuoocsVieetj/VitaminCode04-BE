package org.example.vitamincode04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.vitamincode04.entity.RoleEntity;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<RoleEntity> selectAllRoleUser();
    RoleEntity selectRoleUserByName(@Param("role_name") String role_name);
    int createRole(RoleEntity roleEntity);
    int updateRole(RoleEntity roleEntity);
    int deleteById(@Param("idRole") int id);
}