package com.neusoft.service;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.service
 * <br><b>ClassName:</b> UserService
 * <br><b>Date:</b> 2019年12月26日 下午2:57:20
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.common.HigherResponse;
import com.neusoft.entity.User;

public interface UserService {

    // ===============管理员用户=====================
    // 查询所有用户的接口
    public List<User> queryAllUsers();

    // 根据用户名和密码查询用户
    public HigherResponse<User> queryUser(HttpServletRequest request, User user);

    // 分页查询用户列表
    HigherResponse<Object> pageQueryUser(Integer pageNum, Integer pageSize);

    // ===============普通用户=====================

    // 注册用户
    HigherResponse<Boolean> register(User user);

    // 检查用户名是否有效
    HigherResponse<User> checkUserNameOrEmailIsExist(String val, String type);
}
