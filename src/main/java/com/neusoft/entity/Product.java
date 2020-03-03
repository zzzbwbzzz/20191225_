package com.neusoft.entity;
/** * <b>Description:</b><br>
 * @author 李帆
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> 20191225_
 * <br><b>PackageName:</b> com.neusoft.entity
 * <br><b>ClassName:</b> Product
 * <br><b>Date:</b> 2020年1月2日 下午4:01:58
 */

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Product {

    public Product() {
        // TODO Auto-generated constructor stub
    }

    public Product(Integer id, Integer category_id, String name, String detail, String subtitle, String main_image,
            String sub_images, BigDecimal price, Integer stock, Byte status, Date create_time, Date update_time) {
        super();
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.detail = detail;
        this.subtitle = subtitle;
        this.main_image = main_image;
        this.sub_images = sub_images;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    private Integer id;

    private Integer category_id;

    private String name;

    private String detail;

    private String subtitle;

    private String main_image;

    private String sub_images;

    private BigDecimal price;

    private Integer stock;

    private Byte status;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date create_time;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date update_time;
}
