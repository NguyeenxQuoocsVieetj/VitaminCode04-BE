package org.example.vitamincode04.controller;

import org.example.vitamincode04.entity.RequestOfUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String doGet(){
        return "index";
    }

    @GetMapping("/listRequest")
    public String list(Model model){

        List<RequestOfUser> users = Arrays.asList(
                new RequestOfUser(1, "Nguyễn Việt", "nguyenviet@gmail.com", "Tôi muốn lấy 1000 phòng", null, "PENDING"),
                new RequestOfUser(2, "Trần Quang", "tranquang@gmail.com", "Tôi muốn mua toàn bộ hệ thống", null, "PENDING"),
                new RequestOfUser(3, "Nguyễn Hưng", "nguyenhung@gmail.com", "Chỉ lấy 1 cái", null, "APPROVED")
        );

        model.addAttribute("listUsers", users);

        return "listrequest";
    }

}
