package com.hhx.common.dto.usercenter;

import lombok.Data;

@Data
public class RoleDTO {

    private Long id;

    private String roleName;

    private String description;

    private Long applicationInfoId;

    private Long hospitalId;
}
