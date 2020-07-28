package com.hhx.common.dto.usercenter.role.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author su Lichen
 * @Date 2020/4/24 10:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDefaultRoleDTO {
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
