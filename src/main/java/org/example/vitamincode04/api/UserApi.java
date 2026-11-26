package org.example.vitamincode04.api;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.UserEntity;
import org.example.vitamincode04.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserApi {

    private final UserService userSer;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> doGetAllUserProfile(){
        return ResponseEntity.ok(userSer.getAllUser());
    }

    @GetMapping("/users/search")
    public ResponseEntity<UserEntity> doGetUserProfileByUserName(@RequestParam String username){
        return ResponseEntity.ok(userSer.getUserByUserName(username));
    }

    @GetMapping("/users/three-table")
    public ResponseEntity<List<Map<String, Object>>> doGetAllThreeTable(){
        return ResponseEntity.ok(userSer.getAllThreeTable());
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> doPostUserProfile(@RequestBody UserEntity entity){
        UserEntity result = userSer.createUser(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/users")
    public ResponseEntity<UserEntity> doPutUserProfile(@RequestBody UserEntity entity){
        return ResponseEntity.ok(userSer.updateUser(entity));
    }

    @DeleteMapping("/users/{id}")
    public Map<Object, UserEntity> doDeleteUserProfile(@PathVariable Integer id){
        HashMap result = new HashMap();
        try{
            result.put("message", "Xóa thành công yêu cầu của user id = " + id);
            result.put("data", userSer.deleteUserById(id));
            result.put("status", 200);
        }catch (Exception e){
            result.put("message", "Xóa yêu cầu của user id = " + id + " thất bại.");
            result.put("data", null);
            result.put("status", 500);
        }
        return result;
    }

}
