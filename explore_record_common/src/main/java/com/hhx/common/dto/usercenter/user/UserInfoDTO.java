package com.hhx.common.dto.usercenter.user;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/4/23 14:30
 */
@Data
public class UserInfoDTO {
    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 角色标识
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;
}
