package com.hhx.common.dto.usercenter;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String principal;

    private String credentials;

    private Long hospitalId;

}
