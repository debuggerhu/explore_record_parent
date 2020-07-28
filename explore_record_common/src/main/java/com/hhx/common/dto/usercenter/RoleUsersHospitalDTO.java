package com.hhx.common.dto.usercenter;

import lombok.Data;

import java.util.List;

@Data
public class RoleUsersHospitalDTO {

    private Long roleInfoId;

    private List<String> userIds;

    private Long hospitalId;

}
