package org.example.vitamincode04.service;

import org.example.vitamincode04.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getAllRoleUser();
    RoleEntity getRoleUserByName(String role_name);
    RoleEntity createNewRole(RoleEntity roleEntity);
    RoleEntity updateRole(RoleEntity roleEntity);
    boolean deleteById(Integer id);
    RoleEntity getRoleById(int id);
}
