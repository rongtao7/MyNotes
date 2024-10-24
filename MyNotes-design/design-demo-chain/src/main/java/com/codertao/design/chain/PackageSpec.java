package com.codertao.design.chain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: rongtao7
 * @date: 2023/3/21 11:45 上午
 */
@Data
public class PackageSpec implements Serializable {

    @ExcelProperty(value = "package_spec_id")
    private String packageSpecId;

    @ExcelProperty(value = "package_spec")
    private String packageSpec;
}
