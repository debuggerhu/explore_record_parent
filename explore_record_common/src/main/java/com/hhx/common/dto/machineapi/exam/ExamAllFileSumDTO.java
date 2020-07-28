package com.hhx.common.dto.machineapi.exam;

import lombok.Data;

@Data
public class ExamAllFileSumDTO {

    private String beginDate;
    private String endDate;
    private String machineId;
    private String uuid;
    private String serialNo;
    private String product;
    private String addr;
    private String simICCID;
    private Integer revision;
    private Boolean excludeAddr;
}