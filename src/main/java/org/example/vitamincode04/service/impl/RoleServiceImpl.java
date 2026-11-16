package org.example.vitamincode04.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.RoleEntity;
import org.example.vitamincode04.mapper.RoleMapper;
import org.example.vitamincode04.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleUserMapper;

    @Override
    public List<RoleEntity> getAllRoleUser() {
        return roleUserMapper.selectAllRoleUser();
    }

    @Override
    public RoleEntity getRoleUserByName(String role_name) {
        return roleUserMapper.selectRoleUserByName(role_name);
    }

    @Override
    public RoleEntity createNewRole(RoleEntity roleEntity) {
        int result = roleUserMapper.createRole(roleEntity);
        if(result > 0) return roleEntity;
        throw new RuntimeException("Tạo Role mới thất bại");
    }

    @Override
    public RoleEntity updateRole(RoleEntity roleEntity) {
        int result = roleUserMapper.updateRole(roleEntity);
        if(result > 0) return roleEntity;
        throw new RuntimeException("Chỉnh sửa thất bại");
    }

    @Override
    public boolean deleteById(Integer id) {
        int result = roleUserMapper.deleteById(id);
        if(result != 0) return true;
        throw new RuntimeException("Xóa thất bại");
    }
}
