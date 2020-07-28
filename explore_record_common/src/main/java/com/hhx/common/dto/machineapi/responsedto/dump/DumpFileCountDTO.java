package com.hhx.common.dto.machineapi.responsedto.dump;

import lombok.Data;

@Data
public class DumpFileCountDTO {

    String machineId;
    Long fileCount;
    String serialNo;
}
