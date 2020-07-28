package com.hhx.common.dto.pacs.reporttemplate.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/4/28 14:17
 */
@Data
public class EnableReportTemplateDTO {
    /**
     * 报告模板唯一标识
     */
    @NotNull
    private Long templateId;

    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;
}
