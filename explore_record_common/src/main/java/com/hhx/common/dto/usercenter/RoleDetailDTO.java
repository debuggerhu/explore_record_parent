package com.hhx.common.dto.usercenter;

import lombok.Data;

import java.util.List;

@Data
public class RoleDetailDTO {

    private Long id;

    private String roleName;

    private String description;

    private List<RoleUserHospitalDTO> users;

    private List<Long> actionIds;

}
