package com.hhx.common.dto.usercenter;

import lombok.Data;

import java.util.List;

@Data
public class RoleActionDTO {

    private String roleName;

    private String roleAlias;

    private List<String> actionNames;

    private Long hospitalId;

    private Long applicationId;
}
