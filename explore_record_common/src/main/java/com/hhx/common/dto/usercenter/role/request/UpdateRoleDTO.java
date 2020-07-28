package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/4/24 11:13
 */
@Data
public class UpdateRoleDTO {
    /**
     * 角色唯一标识
     */
    @NotNull
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;
}
