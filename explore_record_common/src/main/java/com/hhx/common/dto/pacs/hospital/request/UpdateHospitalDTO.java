package com.hhx.common.dto.pacs.hospital.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/26 16:56
 */
@Data
public class UpdateHospitalDTO {
    /**
     * 医院唯一标识
     */
    @NotNull
    private Long id;

    /**
     * 医疗机构编码
     */
    private String code;

    /**
     * 医院名称
     */
    private String name;

    /**
     * 医院英文名称
     */
    private String enName;

    /**
     * 医院等级名称
     */
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
     * 登陆界面logo
     */
    private String loginLogo;

    /**
     * 主界面左上方logo
     */
    private String topLeftLogo;

    /**
     * 是否是基础医院
     */
    private Boolean isDataProvider;
}
