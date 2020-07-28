package com.hhx.common.dto.machineapi.wing;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WingUploadStatisticsDTO {

    @NotNull
    private Integer pageNumber;
    @NotNull
    private Integer pageSize;
    private String beginDate;
    private String endDate;
    private String machineId;
    private String serialNo;
    private String product;
    private String addr;
    private String simICCID;
    private Integer revision;
    private boolean excludeAddr;
}
