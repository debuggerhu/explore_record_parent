package com.hhx.common.dto.usercenter.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author su Lichen
 * @Date 2020/4/23 9:57
 */
@Data
public class UpdateWisonicUserPasswordDTO {
    /**
     * 用户唯一标识
     */
    @NotBlank
    private String id;

    /**
     * 账户新密码
     */
    @NotBlank
    private String newPassword;
}
