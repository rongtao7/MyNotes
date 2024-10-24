package com.codertao.design.chain.case3;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Sku {

    /**
     * 商品SKU，唯一
     */
    private Long skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品图片路径
     */
    private String imgPath;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 库存
     */
    private Integer stock;
}
