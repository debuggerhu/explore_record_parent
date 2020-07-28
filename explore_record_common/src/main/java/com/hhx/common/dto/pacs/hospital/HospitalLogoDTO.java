package com.hhx.common.dto.pacs.hospital;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/5/26 14:42
 */
@Data
public class HospitalLogoDTO {
    private Long logoGUID;

    private String loginLogo;

    private String topLeftLogo;

    private Long hospitalGUID;
}
