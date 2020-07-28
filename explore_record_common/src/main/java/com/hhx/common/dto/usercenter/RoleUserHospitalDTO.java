package com.hhx.common.dto.usercenter;

import lombok.Data;

@Data
public class RoleUserHospitalDTO {

    private Long roleInfoId;

    private Long newRoleInfoId;

    private String userId;

    private Long hospitalId;

    private String name;
}
