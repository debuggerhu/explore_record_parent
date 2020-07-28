package com.hhx.common.dto.usercenter.role;

import com.hhx.common.dto.usercenter.ActionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/24 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDetailDTO {
    /**
     * 角色基本信息
     */
    private RoleInfoDTO roleInfo;

    /**
     * 角色拥有权限信息
     */
    private List<ActionDTO> actionList;

    /**
     * 角色用户列表
     * 用于华声云用户组显示用户列表
     */
    private List<String> userList;
}
