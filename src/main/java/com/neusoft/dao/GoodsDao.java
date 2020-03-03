package com.neusoft.dao;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.dao
 * <br><b>ClassName:</b> GoodDao
 * <br><b>Date:</b> 2019年12月30日 下午6:49:52
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.entity.Category;
import com.neusoft.entity.RCategory;

public interface GoodsDao {

    // 获取所有商品类别
    List<Category> getAllCategory();

    // 添加子节点
    Boolean addCategory(Category category);

    // 根据cid查询cname
    String getCateNameByCid(Integer cId);

    // 根据类别的cId查询子节点
    List<RCategory> getChildCateByCid(Integer id);

    // 查询所有的叶子节点
    List<Category> getLeafCart();

    // 复用查询类别接口
    List<Category> getRootCate(@Param("pid") int pId);
}
