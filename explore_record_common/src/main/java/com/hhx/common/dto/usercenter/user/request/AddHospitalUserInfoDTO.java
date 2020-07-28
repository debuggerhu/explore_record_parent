package com.hhx.common.dto.usercenter.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/14 14:41
 */
@Data
public class AddHospitalUserInfoDTO {
    /**
     * 用户唯一标识
     */
    @NotBlank
    private String userId;

    /**
     * 角色唯一标识
     */
    @NotNull
    private Long roleId;
}
