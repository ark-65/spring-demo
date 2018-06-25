package com.ark.demo.service.impl;

import com.ark.demo.domain.user.UserInfo;
import com.ark.demo.service.IEncryptionService;
import com.ark.demo.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 18/6/14
 * Time: 下午2:34
 **/
@Service
public class RegisterServiceImpl implements IRegisterService {

//    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private IEncryptionService iEncryptionService;

    @Override
    public String userRegister(UserInfo userInfo) {

        String result = "success";

        Map<String, Object> userInfoMap = new HashMap<String, Object>();

        String username = userInfo.getUsername();

        String password = userInfo.getPassword();
        password = iEncryptionService.MD5Util(password);

        String email = userInfo.getEmail();

        String phoneNumber = userInfo.getPhoneNumber();

        String name = userInfo.getName();

        Date today = new Date();

        userInfoMap.put("username", username);
        userInfoMap.put("password", password);
        userInfoMap.put("email", email);
        userInfoMap.put("phone_number", phoneNumber);
        userInfoMap.put("name", name);
        userInfoMap.put("create_time", today);

        String sql = " INSERT INTO user_info "
                + " (create_time, email, name, password, phone_number, username) VALUES"
                + " (:create_time, :email, :name, :password, :phone_number, :username) ";

        namedParameterJdbcTemplate.update(sql, userInfoMap);

        return result;
    }
}
