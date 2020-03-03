package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.neusoft.common.HigherResponse;
import com.neusoft.entity.Product;
import com.neusoft.service.ProductService;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.controller <br>
 *       <b>ClassName:</b> ProCon <br>
 *       <b>Date:</b> 2020年1月2日 下午4:14:22
 */
@RestController
@RequestMapping("/manage/product")
public class ProCon {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list.do")
    public HigherResponse<Object> queryProByPage(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(required = true, defaultValue = "8") Integer pageSize) {
        return productService.getPageBeanProduct(pageNum, pageSize);
    }

    @RequestMapping("/search.do")
    public HigherResponse<List<Product>> QueryProByPage(Integer proId, String proName,
            @RequestParam(required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(required = true, defaultValue = "5") Integer pageSize) {
        Product product = new Product();
        product.setId(proId);
        product.setName(proName);
        return productService.searchProByPage(product, pageNum, pageSize);
    }

    @RequestMapping("/set_sale_status.do")
    public HigherResponse<Boolean> updateProStatus(Integer proId, Integer status) {
        Product product = new Product();
        product.setId(proId);
        product.setStatus(status.byteValue());
        return productService.updateProStatus(product);
    }

    @RequestMapping("/save.do")
    public HigherResponse<Boolean> uploadPhoto(Product product, MultipartFile file) {
        return productService.addOneProduct(product, file);
    }

    // 门户接口 根据id和商品名查询商品
    @RequestMapping("/user/list.do")
    public HigherResponse<PageInfo<Product>> queryProByCIdAndProName(
            @RequestParam(required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(required = true, defaultValue = "4") Integer pageSize, Integer cId, String pName) {
        Product product = new Product();
        product.setCategory_id(cId);
        product.setName(pName);
        HigherResponse<PageInfo<Product>> queryProByCIdAndProName = productService.queryProByCIdAndProName(pageNum,
                pageSize, product);
        return queryProByCIdAndProName;

    }

    @RequestMapping("/detail.do")
    public HigherResponse<Product> queryProByPId(Integer pId) {
        return productService.queryProInfoByPId(pId);
    }
}
