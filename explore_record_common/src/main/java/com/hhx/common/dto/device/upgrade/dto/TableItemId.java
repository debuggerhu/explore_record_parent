package com.hhx.common.dto.device.upgrade.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TableItemId {
    /**
     * 表格勾选记录的id
     */
    @NotBlank
    private Integer strategyId;
}
