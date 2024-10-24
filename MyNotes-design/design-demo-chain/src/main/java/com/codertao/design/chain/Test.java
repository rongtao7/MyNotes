package com.codertao.design.chain;

import cn.hutool.Hutool;
import cn.hutool.core.util.HashUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: rongtao7
 * @date: 2023/3/15 12:00 下午
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> has = new HashMap<>();
        has.put(1466308379, "(10g：0.2g)x25g 支");
        System.out.println("autoHash-i:" +has.toString());

        int s = "(10g：0.2g)x25g\\支".trim().hashCode() & 0x7FFFFFFF;
        System.out.println("s="+s);
        //int i = "0.25g*40片".hashCode() & 0x7FFFFFFF;
        //int j = "250mg*40片".hashCode() & 0x7FFFFFFF;
        //System.out.println("defaultHash-i:" + (spec1.trim().hashCode() & 0x7FFFFFFF));
        //System.out.println("defaultHash-j:" + (spec2.trim().hashCode() & 0x7FFFFFFF));
        //System.out.println("-------------------");
        //System.out.println("fnvHash-i:" + HashUtil.fnvHash(spec1));
        //System.out.println("fnvHash-j:" + HashUtil.fnvHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("rsHash-i:" + HashUtil.rsHash(spec1));
        //System.out.println("rsHash-j:" + HashUtil.rsHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("jsHash-i:" + HashUtil.jsHash(spec1));
        //System.out.println("jsHash-j:" + HashUtil.jsHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("pjwHash-i:" + HashUtil.pjwHash(spec1));
        //System.out.println("pjwHash-j:" + HashUtil.pjwHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("elfHash-i:" + HashUtil.elfHash(spec1));
        //System.out.println("elfHash-j:" + HashUtil.elfHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("bkdrHash-i:" + HashUtil.bkdrHash(spec1));
        //System.out.println("bkdrHash-j:" + HashUtil.bkdrHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("sdbmHash-i:" + HashUtil.sdbmHash(spec1));
        //System.out.println("sdbmHash-j:" + HashUtil.sdbmHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("djbHash-i:" + HashUtil.djbHash(spec1));
        //System.out.println("djbHash-j:" + HashUtil.djbHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("dekHash-i:" + HashUtil.dekHash(spec1));
        //System.out.println("dekHash-j:" + HashUtil.dekHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("apHash-i:" + HashUtil.apHash(spec1));
        //System.out.println("apHash-j:" + HashUtil.apHash(spec2));
        //System.out.println("-------------------");
        //System.out.println("tianlHash-i:" + HashUtil.tianlHash(spec1));
        //System.out.println("tianlHash-j:" + HashUtil.tianlHash(spec2));
        //System.out.println("-------------------");


    }


}




