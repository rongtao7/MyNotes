package com.codertao.design.chain.case3;

import com.codertao.design.chain.case1.ProductCheckHandlerConfig;
import com.codertao.design.chain.case1.Result;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public abstract class AbstractHandler<T> {

    /**
     * 当前处理器持有下一个处理器的引用
     */
    @Getter
    @Setter
    private AbstractHandler nextHandler;

    /**
     * 处理器配置
     */
    @Setter
    @Getter
    protected ProductCheckHandlerConfig config;

    /**
     * 处理器执行方法
     * @param param
     * @return
     */
    public abstract Result handle(T param);

    /**
     * 链路传递
     * @param param
     * @return
     */
    protected Result next(T param) {
        //下一个链路没有处理器了，直接返回
        if (Objects.isNull(nextHandler)) {
            return Result.success();
        }

        //执行下一个处理器
        return nextHandler.handle(param);
    }
}
