package com.hhx.common.dto.machineapi.dump;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DumpFileStatisticsDTO {

    @NotNull
    Integer pageNumber;
    @NotNull
    Integer pageSize;
    String beginTime;
    String endTime;
    String machineId;
    String product;
    String serialNo;
    @NotBlank
    String logType;
}
