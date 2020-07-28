package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/4/24 11:13
 */
@Data
public class UpdateHospitalRoleDTO {
    /**
     * 角色唯一标识
     */
    @NotNull
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;
}
