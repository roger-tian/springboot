package com.demo.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.springboot.model.IgrsUser;
import com.demo.springboot.service.IgrsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/control")
public class UserController {
    @Autowired
    private IgrsUserService igrsUserService;

    @RequestMapping("/user/login")
    JSONObject UserLogin(String userName, String password) {
        JSONObject jsonResult = new JSONObject();

        IgrsUser igrsUser = igrsUserService.getUserByName(userName);
        if (igrsUser != null) {
            logger.debug("user: {}, password: {}", igrsUser.getUser(), igrsUser.getPassword());
        }
        if (igrsUser != null) {
            if (userName.equals(igrsUser.getUser()) && password.equals(igrsUser.getPassword())) {
                jsonResult.put("result", "SUCCESS");
            }
            else {
                jsonResult.put("result", "FAIL");
            }
        }
        else {
            jsonResult.put("result", "FAIL");
        }

        return jsonResult;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
}
