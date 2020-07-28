package com.hhx.common.dto.device.upgrade.bo;

import com.hhx.common.dto.device.upgrade.dto.Machine;
import com.hhx.common.dto.device.upgrade.dto.NewFeature;
import com.hhx.common.dto.device.upgrade.request.AddStrategyListRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class QueryOneStrategyBO {
    /**
     * 可见机器
     */
    private List<Machine> visibleMachineList;

    /**
     * 表格勾选的id
     */
    @NotBlank
    private Integer id;

    /**
     * 升级包版本号
     */
    @NotBlank
    private String version;

    /**
     * 作用域：0-指定机器，1-全部版本，2-指定版本
     */
    @NotNull
    private AddStrategyListRequest.Scope scope;

    /**
     * 指定版本号
     */
    private String specifiedVersion;

    /**
     * 版本全称
     */
    private String wholeVersion;

    /**
     * 默认删除预置数据,默认否
     */
    private boolean deletePreset;

    /**
     * 升级包url
     */
    @NotBlank
    private String url;

    /**
     * 备注
     */
    private String description;

    /**
     * 版本说明
     */
    private List<NewFeature> newFeatureList;
}
    