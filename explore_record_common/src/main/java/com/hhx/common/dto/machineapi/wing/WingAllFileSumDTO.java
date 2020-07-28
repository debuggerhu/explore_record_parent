package com.hhx.common.dto.machineapi.wing;

import lombok.Data;

@Data
public class WingAllFileSumDTO {
    private String beginDate;
    private String endDate;
    private String machineId;
    private String serialNo;
    private String product;
    private String addr;
    private String simICCID;
    private Integer revision;
    private Boolean excludeAddr;
}
