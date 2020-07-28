package com.hhx.common.dto.wisonic.group.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/7/7 17:37
 */
@Data
public class AddGroupUserDTO {
    /**
     * 群组标识
     */
    @NotNull
    private Long groupId;

    /**
     * 用户标识
     */
    @NotBlank
    private String userId;

    /**
     * 是否是管理员
     */
    @NotNull
    private Boolean isManager;

    /**
     * 是否是专家
     */
    @NotNull
    private Boolean isExpert;
}
