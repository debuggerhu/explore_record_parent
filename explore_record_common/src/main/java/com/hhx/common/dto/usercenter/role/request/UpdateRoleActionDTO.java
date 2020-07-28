package com.hhx.common.dto.usercenter.role.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/24 11:13
 */
@Data
public class UpdateRoleActionDTO {
    /**
     * 角色唯一标识
     */
    @NotNull
    private Long roleId;

    /**
     * 权限表一标识列表
     */
    private List<Long> actionIds;
}
