package org.example.vitamincode04.service;

import org.example.vitamincode04.entity.RequestOfUser;

import java.util.List;

public interface RequestUserService {
    List<RequestOfUser> getAllRequestOfUsers();
    RequestOfUser getRequestUserFindByEmail(String email);
    RequestOfUser updateRequestOfUser(RequestOfUser requestEntity);
    RequestOfUser insertRequestOfUser(RequestOfUser requestEntity);
    int deleteReqOfUserById(int id);
}
