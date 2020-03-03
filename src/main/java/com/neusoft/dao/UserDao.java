package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.User;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.dao <br>
 *       <b>ClassName:</b> UserDao <br>
 *       <b>Date:</b> 2019年12月26日 上午10:28:38
 */
public interface UserDao {

    // 抽象方法，沒有行为
    /**
     * 查询所有用户
     */
    List<User> queryAllUser();

    /**
     * 根据用户名和密码查询用户
     */
    User queryUserByUserNameAndPsw(User user);

    Boolean addOneUser(User user);

    // 检查用户名或邮箱是否存在
    User checkNameOrEmailIsExist(User user);
}
