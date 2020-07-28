package com.hhx.common.dto.wisonic.group;

import com.hhx.common.dto.wisonic.user.WisonicUserDTO;
import lombok.Data;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/7/7 17:37
 */
@Data
public class GroupDetailDTO {
    /**
     * 群组信息
     */
    private GroupDTO groupInfo;

    /**
     * 用户信息列表
     */
    private List<WisonicUserDTO> userInfoList;

    /**
     * 远程专家数量
     */
    private int expertNum;

    /**
     * 超声医生数量
     */
    private int doctorNum;

    /**
     * 管理员数量
     */
    private int managerNum;
}
