package com.neusoft.service;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.service
 * <br><b>ClassName:</b> CartService
 * <br><b>Date:</b> 2020年1月8日 下午6:14:23
 */

import javax.servlet.http.HttpServletRequest;

import com.neusoft.common.HigherResponse;
import com.neusoft.entity.CartVo;

public interface CartService {

    // 根据用户id查询对应的购物车信息
    public HigherResponse<CartVo> queryCartByUserId(HttpServletRequest request);

    // 添加购物车
    public HigherResponse<CartVo> addOneProductToCart(HttpServletRequest request, Integer proId, Integer count);

    // 从购物车删除某件商品
    public HigherResponse<CartVo> deleteOneProductFromCart(HttpServletRequest request, Integer proId);

    // 修改购物车中某件商品的数量
    public HigherResponse<CartVo> updateProFromCart(HttpServletRequest request, Integer proId, Integer count);

}
