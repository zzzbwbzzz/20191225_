package com.neusoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.common.HigherResponse;
import com.neusoft.entity.CartVo;
import com.neusoft.service.CartService;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.controller <br>
 *       <b>ClassName:</b> CartCon <br>
 *       <b>Date:</b> 2020年1月8日 下午6:37:09
 */
@RestController
@RequestMapping("/portal/cart")
public class CartCon {

    @Autowired
    private CartService cartService;

    @RequestMapping("/list.do")
    public HigherResponse<CartVo> queryCartByUserId(HttpServletRequest request) {
        return cartService.queryCartByUserId(request);
    }

    // 添加购物车商品
    @RequestMapping("/add.do")
    public HigherResponse<CartVo> addOneProductToCart(HttpServletRequest request, Integer proId, Integer count) {
        return cartService.addOneProductToCart(request, proId, count);
    }

    // 移除购物车商品
    @RequestMapping("/delete_product.do")
    public HigherResponse<CartVo> deleteProductFromCart(HttpServletRequest request, Integer proId) {
        return cartService.deleteOneProductFromCart(request, proId);
    }

    // 修改购物车商品数量
    @RequestMapping("/update_product.do")
    public HigherResponse<CartVo> updateProductFromCart(HttpServletRequest request, Integer proId, Integer count) {
        return cartService.updateProFromCart(request, proId, count);
    }

}
