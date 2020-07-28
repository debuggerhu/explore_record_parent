package com.hhx.common.dto.pacs.hospital.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/26 16:44
 */
@Data
public class CreateHospitalDTO {
    /**
     * 医疗机构编码
     */
    @NotBlank
    private String code;

    /**
     * 医院名称
     */
    @NotBlank
    private String name;

    /**
     * 医院英文名称
     */
    private String enName;

    /**
     * 医院等级名称
     */
    @NotBlank
    private String levelName;

    /**
     * 医院类型名称
     */
    private String typeName;

    /**
     * 医院分类管理名称
     */
    private String manageName;

    /**
     * 行政区域标识
     */
    private List<Long> areaGuid;

    /**
     * dicom标识
     */
    private String stationName;

    /**
     * 是否是基础医院
     */
    private Boolean isDataProvider = false;

    /**
     * 数据源医院标识
     */
    private Long dataProviderId;

    /**
     * 登陆界面logo
     */
    private String loginLogo;

    /**
     * 主界面logo
     */
    private String topLeftLogo;
}
