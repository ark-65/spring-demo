package com.ark.demo.service.impl;

import com.ark.demo.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 18/6/13
 * Time: 上午11:48
 **/
@Service
public class LoginServiceImpl implements ILoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String login(String username,String password) {
        return null;
    }

    /**
     * 是否存在用户名
     * @return ture or false
     */
    public boolean isUserName(String username) {
        Boolean isUser;
        String sql = "SELECT username FROM user_info WHERE username = ?";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, username);
        logger.info("result: >>>>>>>>>>>>>>>>>>>>>>>>>" + result);
        if (username.equals(result.get("username"))) {
            isUser = true;
        } else {
            isUser = false;
        }

        return isUser;
    }

    

}
