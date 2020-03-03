package com.neusoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.common.CheckLogin;
import com.neusoft.common.HigherResponse;
import com.neusoft.dao.GoodsDao;
import com.neusoft.entity.Category;
import com.neusoft.entity.RCategory;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.service <br>
 *       <b>ClassName:</b> GoodsServiceImpl <br>
 *       <b>Date:</b> 2019年12月30日 下午7:01:10
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    // 持有對dao的引用
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public HigherResponse<Category> queryAllCategory(HttpServletRequest request) {
        if (!CheckLogin.CheckLogin(request))
            return HigherResponse.noLogin();
        List<Category> category = goodsDao.getAllCategory();
        if (category.isEmpty())
            return HigherResponse.getResponseSuccess("没有类别");
        else
            return HigherResponse.getResponseSuccess(category);
    }

    @Override
    public HigherResponse<Object> addOneCategory(Category c) {
        if (null == c) {
            return HigherResponse.getResponseFailed("添加失败，请重试");
        }
        Boolean addCategory = goodsDao.addCategory(c);
        if (false == addCategory)
            return HigherResponse.getResponseFailed("添加失败，请重试");
        return HigherResponse.getResponseSuccess("添加成功");
    }

    @Override
    public HigherResponse<String> getCnameByCid(Integer cId) {
        if (null == cId) {
            return HigherResponse.getResponseFailed("服务器异常");
        }
        String cateName = goodsDao.getCateNameByCid(cId);
        if (null == cateName)
            return HigherResponse.getResponseFailed("服务器异常，请重新查询");
        return HigherResponse.getResponseSuccess(cateName);
    }

    @Override
    public HigherResponse<List<RCategory>> getChildCategoryByCid(Integer cId) {
        if (null == cId) {
            return HigherResponse.getResponseFailed("服务器异常");
        }
        List<RCategory> childCateByCid = goodsDao.getChildCateByCid(cId);
        if (null == childCateByCid) {
            return HigherResponse.getResponseFailed("未查询到子类别");
        }
        return HigherResponse.getResponseSuccess(childCateByCid);
    }

    @Override
    public HigherResponse<List<Category>> getLeafCategory() {
        List<Category> leafCate = goodsDao.getLeafCart();
        if (null == leafCate)
            return HigherResponse.getResponseFailed("查询失败，请重试");
        return HigherResponse.getResponseSuccess(leafCate);
    }

    @Override
    public HigherResponse<List<Category>> getCategory(Integer pId) {
        if (null == pId)
            return HigherResponse.getResponseFailed("服务器异常");
        List<Category> rootCate = goodsDao.getRootCate(pId);
        if (null == rootCate)
            return HigherResponse.getResponseFailed("未获取到类别信息");
        return HigherResponse.getResponseSuccess(rootCate);
    }

}
