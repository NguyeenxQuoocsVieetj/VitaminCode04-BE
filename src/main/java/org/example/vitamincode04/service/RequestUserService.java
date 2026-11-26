package org.example.vitamincode04.service;

import org.example.vitamincode04.entity.RequestOfUser;

import java.util.List;

public interface RequestUserService {
    List<RequestOfUser> getAllRequestOfUsers();
    List<RequestOfUser> getRequestUserFindByEmail(String email);
    List<RequestOfUser> getRequestOfUserFindByQuestion(String question);
    RequestOfUser updateRequestOfUser(RequestOfUser requestEntity);
    RequestOfUser insertRequestOfUser(RequestOfUser requestEntity);
    int deleteReqOfUserById(int id);
}
