package com.hhx.common.dto.machineapi.responsedto.wing;

import lombok.Data;

@Data
public class UploadStatisticsInfoDTO {

    private String machineId;
    private Long uploadSum;
    private String simICCID;
    private String addr;
    private String revision;
    private String serialNo;
    private String product;
    private String purpose;
}