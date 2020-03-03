package com.neusoft.entity;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.entity
 * <br><b>ClassName:</b> User
 * <br><b>Date:</b> 2019年12月26日 上午10:30:34
 */

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User {

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(Integer id, String userName, String passWord, String email, String phone, String question,
            String answer, Integer role, Date createTime, Date updateTime) {
        super();
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // ORM
    // 封裝原則
    private Integer id;

    private String userName;

    private String passWord;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
