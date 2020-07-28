package com.hhx.common.dto.usercenter.programminguser.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/21 10:09
 */
@Data
public class UpdateProgrammingRoleRequestDTO {
    /**
     * 编程用户唯一标识
     */
    @NotBlank
    private String programmingId;

    /**
     * 角色唯一标识
     */
    @NotNull
    private Long roleId;
}
