package com.hhx.common.dto.wisonic.user;

import com.hhx.common.dto.wisonic.group.GroupDTO;
import com.hhx.common.dto.wisonic.machine.MachineDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/7/7 10:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WisonicUserDetailDTO extends WisonicUserDTO {
    /**
     * 角色列表
     */
    private List<String> roleIdList;

    /**
     * 设备列表
     */
    private List<MachineDTO> machineList;

    /**
     * 群组列表
     */
    private List<GroupDTO> groupList;
}
