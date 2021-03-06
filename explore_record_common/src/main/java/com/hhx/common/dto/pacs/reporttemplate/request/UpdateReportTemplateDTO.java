package com.hhx.common.dto.pacs.reporttemplate.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author su Lichen
 * @Date 2020/4/28 14:17
 */
@Data
public class UpdateReportTemplateDTO {
    /**
     * 报告模板唯一标识
     */
    @NotNull
    private Long templateId;

    /**
     * 报告模板内容
     */
    private String content;

    /**
     * 报告模板名称
     */
    @NotBlank
    private String name;

    /**
     * 报告模板描述
     */
    private String memo;

    /**
     * 报告模板类型
     */
    private Integer type;

    /**
     * 医院唯一标识
     */
    @NotNull
    private Long hospitalId;
}
