package com.neusoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.HigherResponse;
import com.neusoft.dao.UserDao;
import com.neusoft.entity.User;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.service <br>
 *       <b>ClassName:</b> UserServiceImpl <br>
 *       <b>Date:</b> 2019年12月26日 下午2:59:18
 */
@Service
public class UserServiceImpl implements UserService {

    // 持有對dao的引用
    @Autowired
    private UserDao userDao;

    @Override
    public HigherResponse queryUser(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        if (null == user)
            return HigherResponse.getResponseFailed("服务器异常，请重新登录");
        User queryUserByUserNameAndPsw = userDao.queryUserByUserNameAndPsw(user);
        if (null == queryUserByUserNameAndPsw)
            return HigherResponse.getResponseFailed("用户名或密码错误,请重新输入");
        session.setAttribute("user", queryUserByUserNameAndPsw);
        if (queryUserByUserNameAndPsw.getRole() == 1) {
            session.setAttribute("isManager", true);
        } else
            session.setAttribute("isManager", false);
        return HigherResponse.getResponseSuccess(queryUserByUserNameAndPsw);
    }

    @Override
    public List<User> queryAllUsers() {
        // TODO Auto-generated method stub
        return userDao.queryAllUser();
    }

    @Override
    public HigherResponse<Object> pageQueryUser(Integer pageNum, Integer pageSize) {
        // 开启分页
        PageHelper.startPage(pageNum, pageSize);
        // 调用查询所有用户方法
        List<User> queryAllUser = userDao.queryAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(queryAllUser);
        if (null == pageInfo)
            return HigherResponse.getResponseFailed("查询数据失败");
        else
            return HigherResponse.getResponseSuccess(pageInfo);
    }

    @Override
    public HigherResponse<User> checkUserNameOrEmailIsExist(String val, String type) {
        if (null == val || "".equals(val))
            return HigherResponse.getResponseFailed("输入的用户名或邮箱为空");
        if (null == type || "".equals(type))
            return HigherResponse.getResponseFailed("服务器异常");
        User user = new User();
        if ("username".equals(type)) {
            user.setUserName(val);
        } else if ("email".equals(type)) {
            user.setEmail(val);
        }
        User queryUser = userDao.checkNameOrEmailIsExist(user);
        if (null != queryUser)
            return HigherResponse.getResponseFailed(type + "已存在");
        return HigherResponse.getResponseSuccess("验证成功");
    }

    @Override
    public HigherResponse<Boolean> register(User user) {
        // 判断用户是否为空
        if (null == user)
            return HigherResponse.getResponseFailed("服务器异常");
        if (null == user.getUserName() || "".equals(user.getUserName()))
            return HigherResponse.getResponseFailed("用户名不能为空");
        if (null == user.getEmail() || "".equals(user.getEmail()))
            return HigherResponse.getResponseFailed("邮箱不能为空");
        if (null == user.getPassWord() || "".equals(user.getPassWord()))
            return HigherResponse.getResponseFailed("密码不能为空");
        Boolean addOneUser = userDao.addOneUser(user);
        if (!addOneUser)
            return HigherResponse.getResponseFailed("注册失败，请重试");
        return HigherResponse.getResponseSuccess("注册成功");
    }
}
