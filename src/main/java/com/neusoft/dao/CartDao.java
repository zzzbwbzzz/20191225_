package com.neusoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.entity.CartProductVo;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.dao <br>
 *       <b>ClassName:</b> CartDao <br>
 *       <b>Date:</b> 2020年1月8日 下午3:34:17
 */
public interface CartDao {

    public Boolean addOneCartProduct(CartProductVo cartProductVo);

    public List<CartProductVo> getCartProductByUserId(Integer userId);

    public Boolean removeOneProduct(@Param("userId") Integer userId, @Param("proId") Integer proId);

    public Boolean updateProFromCart(@Param("userId") Integer userId, @Param("proId") Integer proId,
            @Param("count") Integer count);

}
