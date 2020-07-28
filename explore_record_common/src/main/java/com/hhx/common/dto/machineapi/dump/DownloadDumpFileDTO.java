package com.hhx.common.dto.machineapi.dump;

import lombok.Data;

@Data
public class DownloadDumpFileDTO {

    String beginTime;
    String endTime;
    String machineId;
    String product;
    String serialNo;
    String logType;
}