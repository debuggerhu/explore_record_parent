package com.hhx.common.dto.device.upgrade.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class VersionInfoBO {
    /**
     * 更新包版本号
     */
    @NotBlank
    private String version;

    /**
     * 版本全称
     */
    @NotBlank
    private String versionWholeName;

    /**
     * 机器型号
     */
    @NotBlank
    private String model;

    /**
     * 机器用途  数组元素可能有一个，也可能有多个，不会为空。
     * 解析出确切的值就是一个，解析不出确切的值则返回多个，以供参考
     */
    @NotEmpty
    private List<String> purpose;
}
