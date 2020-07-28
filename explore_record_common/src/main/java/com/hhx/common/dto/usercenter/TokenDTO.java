package com.hhx.common.dto.usercenter;

import lombok.Data;

@Data
public class TokenDTO {

    private String access_token;

    private String token_type;

    private Long expires_in;

    private String scope;

    private String jti;
}
