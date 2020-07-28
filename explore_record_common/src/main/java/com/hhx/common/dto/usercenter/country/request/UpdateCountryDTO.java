package com.hhx.common.dto.usercenter.country.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/7/7 14:10
 */
@Data
public class UpdateCountryDTO {
    /**
     * 可注册区域标识
     */
    @NotNull
    private Long id;

    /**
     * 是否可用
     */
    @NotNull
    private Boolean isAvailable;
}
