package com.hhx.common.dto.usercenter.programminguser;

import com.hhx.common.dto.usercenter.role.RoleInfoDTO;
import lombok.Data;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/30 15:37
 */
@Data
public class ProgrammingUserDetailDTO {
    /**
     * 编程用户信息
     */
    private ProgrammingUserInfoDTO programmingUserInfo;

    /**
     * 编程用户角色
     */
    private RoleInfoDTO roleInfo;

    /**
     * 已关联的医院列表
     */
    private List<Long> associatedHospitalIdList;
}
