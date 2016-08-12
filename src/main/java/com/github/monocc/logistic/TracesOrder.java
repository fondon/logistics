package com.github.monocc.logistic;

/**
 * trace时间排序。
 * ASC 为：1，2，3，4
 * DESC 为： 4，3，2，1
 */
public enum TracesOrder {
    DESC, //最新时间在最上面
    ASC; //最新时间在下面


    public boolean isDesc() {
        return DESC.equals(this);
    }
}
