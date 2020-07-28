package com.hhx.common.dto.wisonic.group;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/7/7 11:03
 */
@Data
public class GroupDTO {
    /**
     * 群组标识
     */
    private Long id;

    /**
     * 群组名称
     */
    private String name;

    /**
     * 组织名称
     */
    private String company;

    /**
     * 部门名称
     */
    private String department;

}
