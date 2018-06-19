package com.ark.demo.controller;

import com.ark.demo.domain.user.UserInfo;
import com.ark.demo.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 18/6/14
 * Time: 下午2:13
 **/

@RestController
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "v1/api/isUser",method = RequestMethod.POST)
    public Map<String,String> isUserName(@RequestBody UserInfo userLogin) {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
        Map<String, String> userInfo = new HashMap<String,String>();
        userInfo.put("username", username +"6");
        userInfo.put("password", password + "7");
        logger.info("username:"+username+", password:"+ password);
        return userInfo;
    }
}
