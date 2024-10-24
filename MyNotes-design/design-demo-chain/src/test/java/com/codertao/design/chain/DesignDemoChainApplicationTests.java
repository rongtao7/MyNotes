package com.codertao.design.chain;

import com.codertao.design.chain.case1.ProductService;
import com.codertao.design.chain.case1.ProductVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DesignDemoChainApplicationTests {
    @Resource
    ProductService productService;
    @Resource
    TestController testController;

    @Test
    void contextLoads() {
        testController.countData();
        //testController.testImport();
    }

    void testDate () {
        //Calendar instance = Calendar.getInstance();
        //instance.set(Calendar.DAY_OF_MONTH, instance.getActualMaximum(Calendar.DAY_OF_MONTH));

        //Date lastDayOfMonth1 = getLastDayOfMonth1(2022, 1);
        //
        //int difDay = getDifDay(new Date(), lastDayOfMonth1);
        //System.out.println(difDay);

        String abc = "175810020032";
        Map<String, String> map = new HashMap<>();
        map.put("abc", abc);
        Long aLong = MapUtils.getLong(map, "abc");
        System.out.println(aLong);


    }

    @Data
    class Cat {
        private Long id;
        private Integer cat3Id;
    }

    /**
     * 获取指定年月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        return cal.getTime();
    }

    /**
     * 获取两个时间相差几天
     */
    public static int getDifDay(Date start, Date end) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(start);
            Long startTime = calendar.getTimeInMillis();
            calendar.setTime(end);
            Long endTime = calendar.getTimeInMillis();
            double endTimeD = new Double(endTime);
            Double difDay = Math.ceil((endTimeD - startTime) / (1000 * 3600 * 24));
            return difDay.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * 责任链模式
     */
    void testChain() {
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
