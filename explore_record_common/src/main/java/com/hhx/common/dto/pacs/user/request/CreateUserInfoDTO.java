package com.hhx.common.dto.pacs.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/14 14:41
 */
@Data
public class CreateUserInfoDTO {
    /**
     * 角色唯一标识
     */
    @NotNull
    private Long roleId;

    /**
     * 用户姓名
     */
    @NotBlank
    private String name;

    /**
     * 账户密码
     */
    @NotBlank
    private String password;

    /**
     * 电话号码
     */
    @NotBlank
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工号
     */
    private String code;

    /**
     * 备注
     */
    private String memo;

    /**
     * 签名图片
     */
    private String doctorCA;
}
