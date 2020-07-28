package com.hhx.common.dto.usercenter.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/6/1 16:58
 */
@Data
public class DisableHospitalUserDTO {
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
}
