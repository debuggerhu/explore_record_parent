package com.hhx.common.dto.pacs.hospital.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/5/26 14:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutBaseDataDTO {
    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;

    /**
     * 基础数据数据源唯一标识
     */
    private Long dataProviderId;

}
