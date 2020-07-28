package com.hhx.common.dto.usercenter.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/14 14:41
 */
@Data
public class CreateHospitalUserInfoDTO {
    /**
     * 用户标识
     */
    @NotBlank
    private String userId;

    /**
     * 用户姓名
     */
    @NotBlank
    private String name;

    /**
     * 账户密码
     */
    @NotBlank
    private String password;

    /**
     * 电话号码
     */
    @NotBlank
    private String phone;

    /**
     * 角色唯一标识
     */
    @NotNull
    private Long roleId;
}
