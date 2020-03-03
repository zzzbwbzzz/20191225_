package com.neusoft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.common.HigherResponse;
import com.neusoft.entity.Category;
import com.neusoft.entity.RCategory;
import com.neusoft.service.GoodsService;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.controller <br>
 *       <b>ClassName:</b> CategoryCon <br>
 *       <b>Date:</b> 2019年12月30日 下午6:35:42
 */
@RestController
@RequestMapping("/manage/category")
public class CategoryCon {
    @Autowired
    private GoodsService goodsService;

    // 获取所有类别
    @RequestMapping("/get_category.do")
    public HigherResponse GetAllCategory(HttpServletRequest request) {
        return goodsService.queryAllCategory(request);
    }

    @RequestMapping("/add_category.do")
    public HigherResponse<Object> addOneCategory(@RequestParam(required = true) String cName,
            @RequestParam(required = true) Integer pId) {
        Category category = new Category(null, pId, cName, true, null, null, false);
        return goodsService.addOneCategory(category);
    }

    @RequestMapping("/get_Cname.do")
    public HigherResponse<String> getCName(@RequestParam(required = true) Integer cId) {
        return goodsService.getCnameByCid(cId);
    }

    @RequestMapping("/get_deep_category.do")
    public HigherResponse<List<RCategory>> getChildCate(@RequestParam(required = true) Integer cId) {
        return goodsService.getChildCategoryByCid(cId);
    }

    @RequestMapping("/get_leaf_category.do")
    public HigherResponse<List<Category>> getLeafCate() {
        return goodsService.getLeafCategory();
    }

    // 门户查询类别
    @RequestMapping("/get_index_category.do")
    public HigherResponse<List<Category>> getCate(@RequestParam(required = true, defaultValue = "0") Integer pId) {
        return goodsService.getCategory(pId);
    }
}
