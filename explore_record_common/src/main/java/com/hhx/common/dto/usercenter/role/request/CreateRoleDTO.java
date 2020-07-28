package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author su Lichen
 * @Date 2020/4/24 10:59
 */
@Data
public class CreateRoleDTO {
    /**
     * 角色名称
     */
    @NotBlank
    private String name;

    /**
     * 角色描述
     */
    private String description;
}
