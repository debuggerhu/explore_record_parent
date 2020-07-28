package com.hhx.common.dto.machineapi.responsedto.wing;

import lombok.Data;

import java.util.Date;

@Data
public class UploadStatisticsByDateInfoDTO {

    private int uploadSum;
    private Date uploadDate;
}
