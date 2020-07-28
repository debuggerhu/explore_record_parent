package com.hhx.common.dto.wisonic.group.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/7/7 17:37
 */
@Data
public class UpdateGroupDTO {
    /**
     * 群组标识
     */
    @NotNull
    private Long id;

    /**
     * 群组名称
     */
    @NotBlank
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
