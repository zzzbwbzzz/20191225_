package com.neusoft.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.HigherResponse;
import com.neusoft.dao.ProductDao;
import com.neusoft.entity.Product;
import com.neusoft.util.UUIDUtils;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.service <br>
 *       <b>ClassName:</b> ProductServiceImpl <br>
 *       <b>Date:</b> 2020年1月2日 下午4:11:19
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public HigherResponse<Object> getPageBeanProduct(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> pageQueryPro = productDao.pageQueryPro();
        if (null == pageQueryPro)
            return HigherResponse.getResponseFailed("没有查到任何数据，请重试");
        PageInfo<Product> pageInfo = new PageInfo<Product>(pageQueryPro);
        return HigherResponse.getResponseSuccess(pageInfo);
    }

    @Override
    public HigherResponse<List<Product>> searchProByPage(Product product, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> searchProByPage = productDao.searchProByPage(product);
        if (null == searchProByPage)
            return HigherResponse.getResponseFailed("没有查询到数据");
        PageInfo<Product> pageInfo = new PageInfo<>(searchProByPage);
        return HigherResponse.getResponseSuccess(pageInfo);
    }

    @Override
    public HigherResponse<Boolean> updateProStatus(Product product) {
        if (null == product.getId())
            return HigherResponse.getResponseFailed("服务器异常");
        if (null == product.getStatus())
            return HigherResponse.getResponseFailed("服务器异常");
        Boolean updateProStatus = productDao.updateProStatus(product);
        if (false == updateProStatus) {
            return HigherResponse.getResponseFailed("修改失败，请重新尝试");
        }
        return HigherResponse.getResponseSuccess(updateProStatus);
    }

    @Override
    public HigherResponse<Boolean> addOneProduct(Product product, MultipartFile file) {

        if (null == product) {
            return HigherResponse.getResponseFailed("服务器异常");
        }
        if (null == file) {
            return HigherResponse.getResponseFailed("请上传图片");
        }
        // 生成图片名
        // UUID
        String imgName = UUIDUtils.getUUID();
        // 获取到文件名
        String originalFilename = file.getOriginalFilename();
        int suffix = originalFilename.lastIndexOf(".");
        String suffixName = originalFilename.substring(suffix);
        // 判断后缀名
        if ((!".jpg".equals(suffixName)) && (!".png".equals(suffixName))) {
            return HigherResponse.getResponseFailed("图片格式错误");
        }
        imgName += suffixName;
        System.out.println(imgName);
        // 构建商品类
        product.setMain_image(suffixName);
        // 上传图片到指定目录
        try {
            file.transferTo(new File("F:\\imgs\\" + imgName));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        Boolean addOneProduct = productDao.addOneProduct(product);
        if (false == addOneProduct) {
            return HigherResponse.getResponseFailed("未添加成功，请重试");
        }
        return HigherResponse.getResponseSuccess("添加成功");
    }

    @Override
    public HigherResponse<PageInfo<Product>> queryProByCIdAndProName(Integer pageNum, Integer pageSize,
            Product product) {
        if (null == product) {
            return HigherResponse.getResponseFailed("服务器异常");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Product> queryProByCIdAndKeyWord = productDao.queryProByCIdAndKeyWord(product);
        if (null == queryProByCIdAndKeyWord)
            return HigherResponse.getResponseFailed("未查询到相关商品");
        PageInfo<Product> pageInfo = new PageInfo<>(queryProByCIdAndKeyWord);
        return HigherResponse.getResponseSuccess(pageInfo);
    }

    @Override
    public HigherResponse<Product> queryProInfoByPId(Integer pId) {
        if (null == pId)
            return HigherResponse.getResponseFailed("服务器异常");
        Product queryProInfoByPId = productDao.queryProByPId(pId);
        if (null == queryProInfoByPId)
            return HigherResponse.getResponseFailed("服务器异常");
        return HigherResponse.getResponseSuccess(queryProInfoByPId);
    }

}
