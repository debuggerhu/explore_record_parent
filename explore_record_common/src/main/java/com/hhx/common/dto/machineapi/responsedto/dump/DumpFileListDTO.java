package com.hhx.common.dto.machineapi.responsedto.dump;

import lombok.Data;

import java.util.Date;

@Data
public class DumpFileListDTO {

    private String key;
    private Date lastModifyTime;
    private String endpoint;
    private String bucket;

}
