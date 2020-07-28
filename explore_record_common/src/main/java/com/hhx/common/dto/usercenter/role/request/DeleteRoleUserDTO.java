package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/7/7 9:44
 */
@Data
public class DeleteRoleUserDTO {
    /**
     * 用户标识
     */
    @NotBlank
    private String userId;

    /**
     * 角色标识
     */
    @NotNull
    private Long roleId;
}
