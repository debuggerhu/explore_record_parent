package com.hhx.common.dto.pacs.hospital.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/26 13:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBaseHospitalStatusDTO {
    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;

    /**
     * 是否作为基础医院
     */
    private Boolean isDataProvider;
}
