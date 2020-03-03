package com.neusoft.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.User;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.common <br>
 *       <b>ClassName:</b> CheckLogin <br>
 *       <b>Date:</b> 2020年1月9日 上午11:04:51
 */
public class CheckLogin {

    /**
     * <p>
     * Title: CheckLoginPackage
     * </p>
     * <b>Description:</b>登录返回NO_LOGIN，登录返回IS_LOGIN<br>
     * 
     * @param request
     * @return
     * @Note <b>Author:</b> 李帆 <br>
     *       <b>Date:</b> 2020年1月9日 上午11:15:10 <br>
     *       <b>Version:</b> 1.0
     */

    public static HigherResponse<Boolean> CheckLoginPackage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (null == user)
            return HigherResponse.noLogin();
        return HigherResponse.hasLogin();
    }

    /**
     * <p>
     * Title: CheckLogin
     * </p>
     * <b>Description:</b>登录返回true，未登录返回false<br>
     * 
     * @param request
     * @return
     * @Note <b>Author:</b> 李帆 <br>
     *       <b>Date:</b> 2020年1月9日 上午11:14:35 <br>
     *       <b>Version:</b> 1.0
     */

    public static Boolean CheckLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (null == user)
            return false;
        return true;
    }

    /**
     * <p>
     * Title: CheckLoginUser
     * </p>
     * <b>Description:</b>登录返回该用户，未登录返回null<br>
     * 
     * @param request
     * @return
     * @Note <b>Author:</b> 李帆 <br>
     *       <b>Date:</b> 2020年1月9日 上午11:18:58 <br>
     *       <b>Version:</b> 1.0
     */

    public static User CheckLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }
}
