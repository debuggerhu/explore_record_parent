package com.hhx.common.dto.usercenter.programminguser.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/5/21 10:09
 */
@Data
public class UpdateProgrammingHospitalRequestDTO {
    /**
     * 编程用户唯一标识
     */
    @NotBlank
    private String programmingId;

    /**
     * 医院标识列表
     */
    @NotNull
    private List<Long> hospitalIds;
}
