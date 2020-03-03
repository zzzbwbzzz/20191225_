package com.neusoft.service;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.service
 * <br><b>ClassName:</b> ProductService
 * <br><b>Date:</b> 2020年1月2日 下午4:09:54
 */

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.neusoft.common.HigherResponse;
import com.neusoft.entity.Product;

public interface ProductService {

    public HigherResponse<Object> getPageBeanProduct(Integer pageNum, Integer pageSize);

    public HigherResponse<List<Product>> searchProByPage(Product product, Integer pageNum, Integer pageSize);

    public HigherResponse<Boolean> updateProStatus(Product product);

    public HigherResponse<Boolean> addOneProduct(Product product, MultipartFile file);

    // 根据类别id 商品名 查询
    public HigherResponse<PageInfo<Product>> queryProByCIdAndProName(Integer pageNum, Integer pageSize,
            Product product);

    public HigherResponse<Product> queryProInfoByPId(Integer pId);
}
