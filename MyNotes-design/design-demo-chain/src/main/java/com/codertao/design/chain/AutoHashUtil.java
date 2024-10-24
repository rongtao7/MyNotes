package com.codertao.design.chain;

import cn.hutool.core.util.HashUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @description:
 * @author: rongtao7
 * @date: 2023/3/21 9:27 上午
 */
public class AutoHashUtil {

    public static ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<>(306579);
    public static ConcurrentHashMap<Integer, String> rehashMap = new ConcurrentHashMap<>(2000);

    public static Set<Integer> 现有的池子 = new HashSet<>(310000);
    public static Set<Integer> 没有的池子 = new HashSet<>(10000);
    //public static final Map<Integer, String> hashMap = new HashMap<>();

    public static final List<Function<String, Integer>> functionList = new ArrayList<>();

    static {

        hashMap.put(745739175, "0.25g*40片");

        //默认的Hash规则
        functionList.add(packageSpec -> packageSpec.trim().hashCode() & 0x7FFFFFFF);

        functionList.add(packageSpec -> {
            System.out.println("rsHash -> key" + packageSpec);
            int hash = HashUtil.rsHash(packageSpec);
            System.out.println("rsHash -> hash" + hash);
            return hash;
        });

        //FNV Hash
        functionList.add(packageSpec -> {
            System.out.println("fnvHash -> key" + packageSpec);
            int hash = HashUtil.fnvHash(packageSpec);
            System.out.println("fnvHash -> hash" + hash);
            return hash;
        });


        functionList.add(packageSpec -> HashUtil.jsHash(packageSpec));
        functionList.add(packageSpec -> HashUtil.pjwHash(packageSpec));
        functionList.add(packageSpec -> HashUtil.elfHash(packageSpec));
        functionList.add(packageSpec -> HashUtil.bkdrHash(packageSpec));
        functionList.add(packageSpec -> HashUtil.sdbmHash(packageSpec));
        functionList.add(packageSpec -> HashUtil.djbHash(packageSpec));
        functionList.add(packageSpec -> HashUtil.dekHash(packageSpec));
        functionList.add(packageSpec -> HashUtil.apHash(packageSpec));

    }

    public static int multistepHashSet(String spec) {
        String trim = spec.trim();
        for (Function<String, Integer> hashFunction : functionList) {
            int hashValue = hashFunction.apply(trim);
            boolean add = 现有的池子.add(hashValue);
            if (add) {
                hashMap.put(hashValue, spec);
                return hashValue;
            }

        }
        return 0;
    }


    /**
     * 多级Hash规则
     * @param spec
     * @return
     */
    public static int multistepHash(String spec) {
        String trim = spec;
        for (Function<String, Integer> hashFunction : functionList) {
            //Hash算法
            int hashValue = hashFunction.apply(trim);
            String hashSpec = hashMap.get(hashValue);

            //缓存中无值，则放入缓存中
            if (StringUtils.isBlank(hashSpec)) {
                hashMap.put(hashValue, trim);
                rehashMap.put(hashValue, trim);
                System.out.println("缓存中没有的值是，hash = " + hashValue + ", value = " + trim);
                return hashValue;
            }

            //缓存中有值，判断是否冲突，如果不冲突返回；冲突需要再Hash
            boolean eq = Objects.equals(trim, hashSpec);
            if (eq) {
                return hashValue;
            }
            System.out.println("哈希冲突，进入多级哈希逻辑，目标spec =" + trim + "，缓存中的值为 hash=" + hashValue + ", value=" + hashSpec);
        }
        return 0;
    }

}
