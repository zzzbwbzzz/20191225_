package com.neusoft.dao;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.dao
 * <br><b>ClassName:</b> ProductDao
 * <br><b>Date:</b> 2020年1月2日 下午4:07:56
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.entity.Product;

public interface ProductDao {

    public List<Product> pageQueryPro();

    public List<Product> searchProByPage(Product product);

    public Boolean updateProStatus(Product product);

    public Boolean addOneProduct(Product product);

    // 门户接口
    // 根据类别id和关键字查找商品
    public List<Product> queryProByCIdAndKeyWord(Product product);

    // 根据商品id查询商品信息
    public Product queryProByPId(Integer pId);

    // 根据商品id修改商品库存
    public Boolean updateStockFromProduct(@Param("pId") Integer proId, @Param("stock") Integer stock);

}
