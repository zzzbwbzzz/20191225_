package com.neusoft.entity;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.entity
 * <br><b>ClassName:</b> RCategory
 * <br><b>Date:</b> 2020年1月2日 上午10:37:38
 */

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class RCategory extends Category {

    public RCategory() {
        // TODO Auto-generated constructor stub
    }

    public RCategory(Integer id, Integer parent_id, String name, Boolean status, Date create_time, Date update_time,
            Boolean is_leaf, List<RCategory> categories) {
        super(id, parent_id, name, status, create_time, update_time, is_leaf);
        this.categories = categories;
    }

    private List<RCategory> categories;
}
