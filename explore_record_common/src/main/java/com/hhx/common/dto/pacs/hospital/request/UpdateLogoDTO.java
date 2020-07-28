package com.hhx.common.dto.pacs.hospital.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/26 14:37
 */
@Data
public class UpdateLogoDTO {
    /**
     * 医院唯一标识
     */
    @NotNull
    private Long id;

    /**
     * 登陆界面logo
     */
    private String loginLogo;

    /**
     * 主界面左上方logo
     */
    private String topLeftLogo;
}
