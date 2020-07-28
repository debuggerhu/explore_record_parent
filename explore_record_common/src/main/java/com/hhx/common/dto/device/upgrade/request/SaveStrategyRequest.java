package com.hhx.common.dto.device.upgrade.request;

import com.hhx.common.dto.device.upgrade.dto.NewFeature;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SaveStrategyRequest {
    /**
     * 表格勾选的id
     */
    @NotBlank
    private Integer id;

    /**
     * 升级包版本号
     * 来源接口 /api/bgmgr/device/upgrade/parser/version-info
     */
    @NotBlank
    private String version;

    /**
     * 作用域：0-指定机器，1-全部版本，2-指定版本
     */
    @NotNull
    private AddStrategyListRequest.Scope scope;

    /**
     * 型号    参数来源：校验更新包名称合法性的接口中返回
     * 来源接口 /api/bgmgr/device/upgrade/parser/version-info
     */
    @NotBlank
    private String model;

    /**
     * 用途    参数来源：校验更新包名称合法性的接口中返回，返回的是一个数组，数组元素可能有一个，也可能有多个。如果只有一个，参数就是那一个，如果有多个，则由用户选择。
     * 来源接口 /api/bgmgr/device/upgrade/parser/version-info
     */
    @NotBlank
    private String purpose;

    /**
     * 指定版本号
     */
    @NotNull
    private Integer specifiedVersion;

    /**
     * 版本全称
     * 来源接口 /api/bgmgr/device/upgrade/parser/version-info
     */
    private String wholeVersion;

    /**
     * 默认删除预置数据,默认否
     */
    @NotNull
    private boolean deletePreset;

    /**
     * 升级包上传成功后返回的那个url
     */
    @NotBlank
    private String url;

    /**
     * 备注
     */
    private String description;

    /**
     * 可见机器的机器编码
     */
    private List<String> visibleMachineIdList;

    /**
     * 版本说明
     */
    private List<NewFeature> newFeatureList;


}