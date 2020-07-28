package com.hhx.common.dto.usercenter;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String userId;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String region;

    private String nickname;

    private String avatar;

    private String resume;

    private List<Long> roleInfoIds;

    private List<String> roleName;

    private List<RoleDTO> roles;

    private Long hospitalId;

    private Boolean isEmployee;

    private Boolean isTemporary;

    private Boolean isRoot;

}
