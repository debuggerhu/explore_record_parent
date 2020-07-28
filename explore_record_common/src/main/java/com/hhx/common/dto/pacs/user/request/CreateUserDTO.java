package com.hhx.common.dto.pacs.user.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/27 15:46
 */
@Data
public class CreateUserDTO {
    /**
     * 创建用户列表
     */
    @NotNull
    private List<CreateUserInfoDTO> userInfoList;

    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;
}
