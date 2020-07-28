package com.hhx.common.dto.usercenter;

import lombok.Data;

@Data
public class UserHospitalDTO {

    private Long id;

    private String userId;

    private String username;

    private String name;

    private String phone;

    private Long hospitalId;

    private String hospitalName;

    private Boolean isPrimary;

    private Boolean isAdmin;
}
