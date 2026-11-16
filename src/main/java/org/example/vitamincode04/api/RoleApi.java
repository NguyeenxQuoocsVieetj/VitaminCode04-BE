package org.example.vitamincode04.api;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.RoleEntity;
import org.example.vitamincode04.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> doDeleteRoleEntity(@PathVariable Integer id){
        if(roleUserSer.deleteById(id)) return ResponseEntity.ok("xóa thành công role với id = " + id);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không Tìm thấy Role với Id = " + id);
    }

    @DeleteMapping("/roles")
    public ResponseEntity<String> doDeleteRoleEntityByName(@RequestParam String roleName){
        RoleEntity result = roleUserSer.getRoleUserByName(roleName);

        if(result == null )
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Không tìm thấy role " + roleName);
        if(roleUserSer.deleteById(result.getId()))
            return ResponseEntity.ok("Xóa thành công role " + roleName);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Xóa " + roleName + " thất bại.");
    }

}
