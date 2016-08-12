package com.github.monocc.logistic;

/**
 * 查询结果状态
 * 	查询结果状态：
 * 0：物流单暂无结果，
 * 1：查询成功，
 * 2：接口出现异常
 */
public enum Status {

    NO_RESULT(0, "物流单暂无结果"), SUCCESS(1, "查询成功"), ERROR(2, "接口出现异常");

    private int code;
    private String name;

    Status(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
