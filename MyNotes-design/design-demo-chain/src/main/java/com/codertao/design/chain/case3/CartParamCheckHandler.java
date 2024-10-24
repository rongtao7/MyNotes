package com.codertao.design.chain.case3;

import com.codertao.design.chain.case1.Result;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CartParamCheckHandler extends AbstractHandler<Set<Sku>>{

    @Override
    public Result handle(Set<Sku> s) {
        return null;
    }
}
