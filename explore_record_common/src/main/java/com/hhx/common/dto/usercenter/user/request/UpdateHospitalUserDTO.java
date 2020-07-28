package com.hhx.common.dto.usercenter.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/4/27 14:19
 */
@Data
public class UpdateHospitalUserDTO {
    /**
     * 用户唯一标识
     */
    @NotBlank
    private String userId;

    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;

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
}
