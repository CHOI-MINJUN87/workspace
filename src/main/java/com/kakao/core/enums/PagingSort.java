package com.kakao.core.enums;

public enum PagingSort {

    ACCURACY("accuracy", "정확도순"),
    RECENCY("recency", "최신순")
    ;

    PagingSort(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private final String code;
    private final String name;


    public String c() {
        return code;
    }
    public String n() {
        return name;
    }
}
