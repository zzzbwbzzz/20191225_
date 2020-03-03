package com.neusoft.service;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.service
 * <br><b>ClassName:</b> GoodsService
 * <br><b>Date:</b> 2019年12月30日 下午6:59:29
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.common.HigherResponse;
import com.neusoft.entity.Category;
import com.neusoft.entity.RCategory;

public interface GoodsService {

    // 查询所有类别的接口
    HigherResponse<Category> queryAllCategory(HttpServletRequest request);

    // 添加一个类别
    HigherResponse<Object> addOneCategory(Category c);

    // 根据id查询类别名字
    HigherResponse<String> getCnameByCid(Integer cId);

    HigherResponse<List<RCategory>> getChildCategoryByCid(Integer cId);

    HigherResponse<List<Category>> getLeafCategory();

    // 门户查询类别
    HigherResponse<List<Category>> getCategory(Integer pId);
}
