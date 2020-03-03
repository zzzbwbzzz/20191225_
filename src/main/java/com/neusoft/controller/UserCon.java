package com.neusoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 *       <b>ClassName:</b> UserCon <br>
 *       <b>Date:</b> 2019年12月27日 上午11:01:56
 */
@RestController
@RequestMapping("/manage/user")
public class UserCon {

    @Autowired
    private UserService userService;

    // SpringMVC 动态绑定
    @RequestMapping("/login.do")
    public HigherResponse<User> login(HttpServletRequest request, @RequestParam(required = true) String name,
            @RequestParam(required = true) String psw) {
        User userTemp = new User();
        userTemp.setUserName(name);
        userTemp.setPassWord(psw);
        HigherResponse<User> user = userService.queryUser(request, userTemp);
        return user;
    }

    // 用户分页
    @RequestMapping("/list.do")
    public HigherResponse<Object> pageCon(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(required = true, defaultValue = "3") Integer pageSize) {
        return userService.pageQueryUser(pageNum, pageSize);
    }

}
