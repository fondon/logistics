package com.github.monocc.logistic;

/**
 * 快递跟踪，跟踪快递的状态
 */
public interface Trace {
    /**
     * 跟踪时间
     * @return
     */
    String getTime();

    /**
     * 跟踪时间的内容
     * @return
     */
    String getContent();

    /**
     * 备注
     * @return
     */
    String getRemark();
}
