package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

/**
 * @Author su Lichen
 * @Date 2020/4/24 11:13
 */
@Data
@NoArgsConstructor
public class UpdateDefaultRoleDTO {
    /**
     * 角色唯一标识
     */
    @NonNull
    private Long id;

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
