package com.hejia.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: hj
 * @Date: 2021/6/30 16:09
 */
@Data
public class ExcelModel {
    /**
     * 第一列的数据
     */
    @ExcelProperty(index = 9)
    private String column1;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 10)
    private String column2;

    @ExcelProperty(index = 12)
    private String column3;
}
