package com.hhx.common.dto.hospital.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/27 11:46
 */
@Data
public class CheckUniqueValueDTO {
    /**
     * 医疗机构编码
     */
    private String code;

    /**
     * 医院名称
     */
    private String name;

    /**
     * dicom标识
     */
    private String stationName;

    /**
     * 医院唯一标识（修改时，传入当前修改医院的标识）
     */
    private Long hospitalId;
}
