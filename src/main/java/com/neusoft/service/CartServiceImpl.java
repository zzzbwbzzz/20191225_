package com.neusoft.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.common.CheckLogin;
import com.neusoft.common.HigherResponse;
import com.neusoft.common.StatusUtil;
import com.neusoft.dao.CartDao;
import com.neusoft.dao.ProductDao;
import com.neusoft.entity.CartProductVo;
import com.neusoft.entity.CartVo;
import com.neusoft.entity.User;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.service <br>
 *       <b>ClassName:</b> CartServiceImpl <br>
 *       <b>Date:</b> 2020年1月8日 下午6:14:40
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public HigherResponse<CartVo> queryCartByUserId(HttpServletRequest request) {
        User user = CheckLogin.CheckLoginUser(request);
        if (null == user)
            return HigherResponse.noLogin();
        Integer userId = user.getId();
        if (null == userId)
            return HigherResponse.getResponseFailed("请登录！");
        List<CartProductVo> cartProductByUserId = cartDao.getCartProductByUserId(userId);
        if (null == cartProductByUserId) {
            return HigherResponse.getResponseFailed("购物车为空");
        }
        CartVo cartVo = new CartVo();
        cartVo.setCartProductList(cartProductByUserId);
        BigDecimal sumTotalCartPrice = new BigDecimal(0.00);
        boolean flag = true;
        for (int i = 0; i < cartProductByUserId.size(); i++) {
            CartProductVo cartProductVo = cartProductByUserId.get(i);
            if (cartProductVo.getProductChecked() == 1) {
                sumTotalCartPrice = sumTotalCartPrice.add(cartProductVo.getProductTotalPrice());
            } else
                flag = false;
        }
        cartVo.setCartTotalPrice(sumTotalCartPrice);
        cartVo.setAllChecked(flag);
        cartVo.setImageHost(StatusUtil.IMG_HOST);
        return HigherResponse.getResponseSuccess(cartVo);
    }

    @Override
    public HigherResponse<CartVo> addOneProductToCart(HttpServletRequest request, Integer proId, Integer count) {
        User user = CheckLogin.CheckLoginUser(request);
        if (null == user)
            return HigherResponse.noLogin();
        Integer userId = user.getId();
        CartProductVo cartProductVo = new CartProductVo();
        cartProductVo.setUserId(userId);
        cartProductVo.setProductId(proId);
        cartProductVo.setQuantity(count);
        Boolean addOneCartProduct = cartDao.addOneCartProduct(cartProductVo);
        if (!addOneCartProduct)
            return HigherResponse.getResponseFailed("添加失败");
        Boolean updateStockFromProduct = productDao.updateStockFromProduct(proId, count);
        if (!updateStockFromProduct) {
            return HigherResponse.getResponseFailed("库存修改失败，请重试");
        }
        return queryCartByUserId(request);
    }

    @Override
    public HigherResponse<CartVo> deleteOneProductFromCart(HttpServletRequest request, Integer proId) {
        if (null == proId)
            return HigherResponse.getResponseFailed("服务器异常");
        User user = CheckLogin.CheckLoginUser(request);
        if (null == user)
            return HigherResponse.noLogin();
        Integer id = user.getId();
        Boolean removeOneProduct = cartDao.removeOneProduct(id, proId);
        if (!removeOneProduct) {
            return HigherResponse.getResponseFailed("删除失败，请重试");
        }
        return queryCartByUserId(request);
    }

    @Override
    public HigherResponse<CartVo> updateProFromCart(HttpServletRequest request, Integer proId, Integer count) {
        if (null == proId || null == count)
            return HigherResponse.getResponseFailed("服务器异常");
        User user = CheckLogin.CheckLoginUser(request);
        if (null == user)
            return HigherResponse.getResponseFailed("用户未登录");
        if (!cartDao.updateProFromCart(user.getId(), proId, count))
            return HigherResponse.getResponseFailed("修改失败，请重试");

        return queryCartByUserId(request);
    }

}
