package org.example.vitamincode04.api;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.UserEntity;
import org.example.vitamincode04.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> doDeleteUserProfile(@PathVariable Integer id){
        if(userSer.deleteUserById(id)) return ResponseEntity.ok("Xóa thành công User id = " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Xóa User id = " + id + " thất bại");
    }

}
