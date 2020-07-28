package com.hhx.common.dto.usercenter.role.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/24 11:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDefaultRoleActionByActionNameDTO {
    /**
     * 角色唯一标识
     */
    @NonNull
    private Long id;

    /**
     * 权限表一标识列表
     */
    private List<String> actionNameList;
}
