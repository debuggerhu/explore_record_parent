package com.hhx.common.dto.device.upgrade.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Machine{

    /**
     * machineId -- 设备编号
     */
    @NotEmpty
    private String id;

    /**
     * 机器当前的版本号
     */
    private String version;
}
