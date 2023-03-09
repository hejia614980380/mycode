package com.hejia.generate;

import lombok.Data;

import java.util.List;

/**
 * @Author: hj
 * @Date: 2021/5/27 10:53
 */

@Data
public class GenerateVO {
    private String mainType;

    private String mainTypeText;

    private String subType;

    private String subTypeText;

    private List<Inner> fields;

    private List<Inner> pageFields;

    @Data
    public static class Inner {
        private String name;

        private String text;

        private Boolean showFlag;
    }



}
