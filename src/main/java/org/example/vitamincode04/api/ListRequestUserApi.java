package org.example.vitamincode04.api;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.RequestOfUser;
import org.example.vitamincode04.service.RequestUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ListRequestUserApi {
    private final RequestUserService reqUserSer;

    @GetMapping("/requests")
    public ResponseEntity<List<RequestOfUser>> doGetUserListRequest(){
        return ResponseEntity.ok(reqUserSer.getAllRequestOfUsers());
    }

    @GetMapping("/requests/search-by-email")
    public Map<Object, RequestOfUser> doGetRequestOfUserFindByEmail(@RequestParam String email) {
        HashMap result = new HashMap();
        try{
            result.put("message", "Tìm kiếm thành công Request với email là: " + email);
            result.put("data", reqUserSer.getRequestUserFindByEmail(email));
            result.put("stats", 200);
        }catch (Exception e){
            result.put("message", e.getMessage());
            result.put("data", null);
            result.put("status", 500);
        }
        return result;
    }

    @GetMapping("/requests/search-by-question")
    public Map<Object, RequestOfUser> doGetRequestOfUserFindByQuestion(@RequestParam String question){
        HashMap result = new HashMap();
        try {
            result.put("message", "Tìm kiếm thành công Request với question là: " + question);
            result.put("data", reqUserSer.getRequestOfUserFindByQuestion(question));
            result.put("status", 200);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            result.put("data", null);
            result.put("status", 500);
        }
        return result;
    }

    @PostMapping("/requests")
    public ResponseEntity<RequestOfUser> doPostRequestOfUser(@RequestBody RequestOfUser reqOfUser){
        return ResponseEntity.ok(reqUserSer.insertRequestOfUser(reqOfUser));
    }

    @PutMapping("/requests")
    public ResponseEntity<RequestOfUser> doPutRequestOfUser(@RequestBody RequestOfUser reqOfUser){
        return ResponseEntity.ok(reqUserSer.updateRequestOfUser(reqOfUser));
    }

    @DeleteMapping("/requests/{id}")
    public Map<Object, RequestOfUser> doDeleteRequestOfUser(@PathVariable int id){
        HashMap result = new HashMap();
        try{
            result.put("message", "Xóa thành công yêu cầu của user id = " + id);
            result.put("data", reqUserSer.deleteReqOfUserById(id));
            result.put("status", 200);
        }catch (Exception e){
            result.put("message", "Xóa yêu cầu của user id = " + id + " thất bại.");
            result.put("data", null);
            result.put("status", 500);
        }
        return result;
    }
}
