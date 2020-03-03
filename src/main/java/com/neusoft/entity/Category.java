package com.neusoft.entity;

import java.util.Date;

import lombok.Data;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.entity <br>
 *       <b>ClassName:</b> Category <br>
 *       <b>Date:</b> 2019年12月30日 下午6:38:52
 */
@Data
public class Category {
    private Integer id;
    private Integer parent_id;
    private String name;
    private Boolean status;
    private Date create_time;
    private Date update_time;
    private Boolean is_leaf;

    public Category() {

    }

    public Category(Integer id, Integer parent_id, String name, Boolean status, Date create_time, Date update_time,
            Boolean is_leaf) {
        super();
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
        this.is_leaf = is_leaf;
    }

}
