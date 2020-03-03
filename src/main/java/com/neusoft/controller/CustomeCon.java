package com.neusoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.common.HigherResponse;
import com.neusoft.entity.User;
import com.neusoft.service.UserService;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.controller <br>
 *       <b>ClassName:</b> CustomeCon <br>
 *       <b>Date:</b> 2019年12月29日 下午2:37:39
 */
@RestController
@RequestMapping("/portal/user")
public class CustomeCon {

    @Autowired
    private UserService userService;

    // 检测用户名是否存在
    @RequestMapping("/check_vaild.do")
    public HigherResponse<User> checkNameOrEmailIsExist(String val, String type) {
        return userService.checkUserNameOrEmailIsExist(val, type);
    }

    // 用户注册接口
    @RequestMapping("/register.do")
    public HigherResponse<Boolean> register(User user) {
        return userService.register(user);
    }
}
