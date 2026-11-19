package org.example.vitamincode04.api;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.RoleEntity;
import org.example.vitamincode04.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RoleApi {
    private final RoleService roleUserSer;

    @GetMapping("/roles")
    public ResponseEntity<List<RoleEntity>> doGetAllRoleUser(){
        return ResponseEntity.ok(roleUserSer.getAllRoleUser());
    }

    @GetMapping("/roles/search")
    public ResponseEntity<RoleEntity> doGetRoleUserByName(@RequestParam String roleName){
        return ResponseEntity.ok(roleUserSer.getRoleUserByName(roleName));
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleEntity> doGetRoleById(@PathVariable("id") int id){
        return ResponseEntity.ok(roleUserSer.getRoleById(id));
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleEntity> doPostRoleEntity(@RequestBody RoleEntity roleEntity){
        RoleEntity saveRole = roleUserSer.createNewRole(roleEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRole);
    }

    @PutMapping("/roles")
    public ResponseEntity<RoleEntity> doPutRoleEntity(@RequestBody RoleEntity roleEntity){
        return ResponseEntity.ok(roleUserSer.updateRole(roleEntity));
    }

    @DeleteMapping("/roles/{id}")
    public Map<Object, RoleEntity> doDeleteRoleEntity(@PathVariable Integer id){
        HashMap result = new HashMap();
        try{
            result.put("message", "Xóa thành công yêu cầu của user id = " + id);
            result.put("data", roleUserSer.deleteById(id));
            result.put("status", 200);
        }catch (Exception e){
            result.put("message", "Xóa yêu cầu của user id = " + id + " thất bại.");
            result.put("data", null);
            result.put("status", 500);
        }
        return result;
    }


}
