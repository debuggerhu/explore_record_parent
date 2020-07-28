package com.hhx.common.dto.machineapi.exam;

import lombok.Data;

@Data
public class UploadStatisticsDateDTO {

    private String machineId;
    private String beginDate;
    private String endDate;
}
