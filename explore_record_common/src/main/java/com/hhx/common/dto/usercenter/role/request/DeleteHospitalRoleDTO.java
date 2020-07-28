package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/28 14:13
 */
@Data
public class DeleteHospitalRoleDTO {
    /**
     * 角色唯一标识
     */
    @NotNull
    private Long roleId;

    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;
}
