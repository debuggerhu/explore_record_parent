package com.hhx.common.dto.wisonic.machine;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/7/7 11:02
 */
@Data
public class MachineDTO {
    /**
     * 机器mac地址
     */
    private String id;

    /**
     * 机器名称
     */
    private String name;
}
