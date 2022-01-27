package com.codertao.design.chain;

import com.codertao.design.chain.case1.ProductService;
import com.codertao.design.chain.case1.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class DesignDemoChainApplicationTests {
    @Resource
    ProductService productService;

    @Test
    void contextLoads() {
        ProductVO param = ProductVO.builder()
                .skuId(123L)
                .skuName("测试商品")
                .imgPath("http://..")
                .price(new BigDecimal(1))
                .stock(1)
                .build();
        productService.createProduct(param);
    }

}
