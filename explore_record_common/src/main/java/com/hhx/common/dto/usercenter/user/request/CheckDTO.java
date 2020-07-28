package com.hhx.common.dto.usercenter.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/6/2 16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckDTO {
    /**
     * 电话号码列表
     */
    private List<String> phoneList;

    /**
     * 角色标识列表
     */
    private List<Long> roleList;

    /**
     * 用户标识列表
     */
    private List<String> userIdList;

    /**
     * 医院标识
     */
    @NotNull
    private Long hospitalId;
}
