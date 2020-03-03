package com.neusoft.entity;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.entity
 * <br><b>ClassName:</b> CartVo
 * <br><b>Date:</b> 2020年1月8日 下午3:22:43
 */

import java.math.BigDecimal;
import java.util.List;

import com.neusoft.common.StatusUtil;

import lombok.Data;

@Data
public class CartVo {

    public CartVo() {
        super();
    }

    public CartVo(List<CartProductVo> cartProductList, BigDecimal cartTotalPrice, Boolean allChecked) {
        super();
        this.cartProductList = cartProductList;
        this.cartTotalPrice = cartTotalPrice;
        this.allChecked = allChecked;
        this.imageHost = StatusUtil.IMG_HOST;
    }

    private List<CartProductVo> cartProductList;

    private BigDecimal cartTotalPrice;

    private Boolean allChecked;

    private String imageHost;
}
