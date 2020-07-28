package com.hhx.common.dto.usercenter;

import lombok.Data;

@Data
public class ActionDTO {
    private Long id;

    private String actionName;

    private String actionAlias;

    private String description;

    private String moduleName;

}
