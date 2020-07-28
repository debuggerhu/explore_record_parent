package com.hhx.common.constants;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JwtPayload {

    private String userId;

    private String username;

    private Long hospitalId;

    private Long exp;

    private List<String> authorities;

    private List<Long> hospitalIdList;

    public JwtPayload(String userId, String username, Long hospitalId, List<String> authorities, List<Long> hospitalIdList) {
        this.userId = userId;
        this.username = username;
        this.hospitalId = hospitalId;
        this.exp = (long) Integer.MAX_VALUE;
        this.authorities = authorities;
        this.hospitalIdList = hospitalIdList;
    }
}
