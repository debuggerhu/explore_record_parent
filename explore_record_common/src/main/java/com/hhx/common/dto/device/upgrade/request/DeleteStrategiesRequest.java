package com.hhx.common.dto.device.upgrade.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class DeleteStrategiesRequest {
    /**
     * 表格勾选记录的id 列表
     */
    @NotEmpty
    private List<Integer> idList;
}
