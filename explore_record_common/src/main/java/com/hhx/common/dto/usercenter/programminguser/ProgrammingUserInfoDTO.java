package com.hhx.common.dto.usercenter.programminguser;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/4/27 17:11
 */
@Data
public class ProgrammingUserInfoDTO {
    /**
     * 编程用户唯一标识
     */
    private String uuid;

    /**
     * 编程用户账户名
     */
    private String username;

    /**
     * 编程用户密码
     */
    private String password;

    /**
     * 编程用户描述
     */
    private String resume;
}
