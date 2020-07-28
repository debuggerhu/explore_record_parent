package com.hhx.common.constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author su Lichen
 * @Date 2020/6/9 17:33
 */
@AllArgsConstructor
@NoArgsConstructor
public enum  Application {
    //华声云
    WISONIC(1L, "wisonic"),

    //云pacs
    PACS(2L, "pacs"),

    //云客服
    CLOUD_CUSTOMER_SERVICE(3L, "cloud_customer_service"),

    //后台管理
    BACKGROUND_MANAGER(4L, "background_manager");

    private Long code;

    private String remake;

    public Long getCode() {
        return code;
    }

    public String getRemake() {
        return remake;
    }
}
