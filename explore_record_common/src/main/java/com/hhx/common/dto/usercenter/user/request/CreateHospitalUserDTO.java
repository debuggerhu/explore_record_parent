package com.hhx.common.dto.usercenter.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/27 15:46
 */
@Data
public class CreateHospitalUserDTO {
    /**
     * 创建用户列表
     */
    @NotNull
    private List<CreateHospitalUserInfoDTO> userInfoList;

    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;
}
