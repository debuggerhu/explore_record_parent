package com.hhx.common.dto.usercenter.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/23 9:57
 */
@Data
public class CreateWisonicUserDTO {
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
     * 电话号码所属区域
     */
    @NotBlank
    private String region;

    /**
     * 是否是公司内部成员
     */
    @NotNull
    private Boolean isEmployee;

    /**
     * 角色列表
     */
    @NotNull
    private List<Long> roleIdList;
}
