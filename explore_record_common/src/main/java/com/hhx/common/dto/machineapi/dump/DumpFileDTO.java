package com.hhx.common.dto.machineapi.dump;

import lombok.Data;

@Data
public class DumpFileDTO {

    String beginTime;
    String endTime;
    String machineId;
    String logType;
}
