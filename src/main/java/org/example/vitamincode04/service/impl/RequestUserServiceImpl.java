package org.example.vitamincode04.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.vitamincode04.entity.RequestOfUser;
import org.example.vitamincode04.mapper.RequestOfUserMapper;
import org.example.vitamincode04.service.RequestUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestUserServiceImpl implements RequestUserService {

    private final RequestOfUserMapper reqOfUserMapper;

    @Override
    public List<RequestOfUser> getAllRequestOfUsers() {
        return reqOfUserMapper.selectRequestOfUsers();
    }

    @Override
    public RequestOfUser getRequestUserFindByEmail(String email) {
        return reqOfUserMapper.selectRequestOfUserFindByEmail(email);
    }

    @Override
    public RequestOfUser updateRequestOfUser(RequestOfUser requestEntity) {
        int result = reqOfUserMapper.updateRequestOfUser(requestEntity);
        if(result > 0) return requestEntity;
        throw new RuntimeException("Chỉnh sửa thất bại");
    }

    @Override
    public RequestOfUser insertRequestOfUser(RequestOfUser requestEntity) {
        int result = reqOfUserMapper.insertRequestOfUser(requestEntity);
        if(result > 0) return requestEntity;
        throw new RuntimeException("Thêm mới dữ liệu thất bại");
    }


    public int deleteReqOfUserById(int id){
        int result = reqOfUserMapper.deleteRequestOfUser(id);
        if(result > 0) return result;
        throw new RuntimeException("Xóa dữ liệu thất bại");
    }

}
