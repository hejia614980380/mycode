package com.hejia.demo;

public enum Gender {
    Male("1", "男"),
    Female("2", "女"),
    UnKnown("3", "未知")
    ;

    private String value;

    private String text;

    Gender(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
