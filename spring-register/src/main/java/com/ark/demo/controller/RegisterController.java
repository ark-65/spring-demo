package com.ark.demo.controller;

import com.ark.demo.domain.user.UserInfo;
import com.ark.demo.service.IEncryptionService;
import com.ark.demo.service.IRegisterService;
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
 * Date: 18/6/25
 * Time: 上午11:26
 **/
@RestController
public class RegisterController {

    @Autowired
    private IRegisterService iRegisterService;

    @RequestMapping(value = "v1/api/test",method = RequestMethod.POST)
    public Map<String, String> test(@RequestBody UserInfo userRegisterInfo) {

        String password = userRegisterInfo.getPassword();

//        password = iEncryptionService.MD5Util(password);

        Map<String, String> resultMap = new HashMap<String, String>();

        resultMap.put("password", password);

        return resultMap;
    }

    @RequestMapping(value = "v1/api/register", method = RequestMethod.POST)
    public String register(@RequestBody UserInfo userInfo) {
        String result = "success";

        iRegisterService.userRegister(userInfo);

        return result;
    }

}
