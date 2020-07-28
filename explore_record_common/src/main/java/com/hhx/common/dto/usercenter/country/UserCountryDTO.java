package com.hhx.common.dto.usercenter.country;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/7/7 11:21
 */
@Data
public class UserCountryDTO {
    /**
     * 用户注册区域标识
     */
    private Long id;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域中文名称
     */
    private String cnName;

    /**
     * 电话号码code
     */
    private String phoneCode;

    /**
     * 地区代码
     */
    private String regionCode;

    /**
     * 区域是否可用
     */
    private Boolean available;
}
