package com.hhx.common.dto.usercenter.role;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/4/23 15:38
 */
@Data
public class RoleInfoDTO {
    /**
     * 角色唯一标识
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 角色人数
     * 用于华声云用户管理中，显示每个角色的人数
     */
    private int number;
}
