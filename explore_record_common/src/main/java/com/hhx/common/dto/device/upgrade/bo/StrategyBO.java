package com.hhx.common.dto.device.upgrade.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StrategyBO {

    /**
     * 唯一id
     */
    @NotBlank
    private Integer id;

    /**
     * 版本号
     */
    @NotBlank
    private String version;

    /**
     * 版本全称
     */
    @NotBlank
    private String versionWholeName;

    /**
     * 型号
     */
    @NotBlank
    private String model;

    /**
     * 用途
     */
    @NotBlank
    private String purpose;

    /**
     * 是否删除预置数据
     */
    @NotNull
    private boolean deletePreset;

    /**
     * 备注
     */
    private String description;

    /**
     * 创建时间
     */
    @NotBlank
    private Date createTime;
}
