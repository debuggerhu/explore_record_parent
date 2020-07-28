package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/7/7 9:44
 */
@Data
public class AddRoleUserDTO {
    /**
     * 用户标识列表
     */
    @NotNull
    private List<String> userIdList;

    /**
     * 角色标识
     */
    @NotNull
    private Long roleId;
}
