package com.hhx.common.dto.usercenter;

import lombok.Data;

@Data
public class UserPasswordDTO {
    private String userId;
    private String oldPassword;
    private String password;
}
