package com.hhx.common.dto.machineapi.wing;

import lombok.Data;

@Data
public class WingUploadStatisticsByDateDTO {

    private String machineId;
    private String beginDate;
    private String endDate;
}
