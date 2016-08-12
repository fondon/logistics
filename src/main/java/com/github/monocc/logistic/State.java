package com.github.monocc.logistic;

/**
 * 物流状态
 */
public enum State {
    UNKOWN(-1, "未知状态"), //物流接口返回未知状态。
    WAY(0, "在途"), //即货物处于运输过程中
    EMBRACE(1, "揽件"), //货物已由快递公司揽收并且产生了第一条跟踪信息；
    DIFFICULT(2, "疑难"), //货物寄送过程出了问题；
    SIGNIN(3, "签收"), //收件人已签收；
    SIGNOUT(4, "退签"), // 即货物由于用户拒签、超区等原因退回，而且发件人已经签收；
    SENDING(5, "派件"), //即快递正在进行同城派件；
    RETURNED(6, "退回"); //货物正处于退回发件人的途中；
    private int code;
    private String name;

    State(int code, String name) {
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
