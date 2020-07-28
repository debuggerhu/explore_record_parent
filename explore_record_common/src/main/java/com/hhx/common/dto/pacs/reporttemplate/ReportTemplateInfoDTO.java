package com.hhx.common.dto.pacs.reporttemplate;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/4/28 14:06
 */
@Data
public class ReportTemplateInfoDTO {
    /**
     * 报告模板唯一标识
     */
    private Long id;

    /**
     * 报告模板名称
     */
    private String name;

    /**
     * 报告模板描述
     */
    private String memo;

    /**
     * 报告模板类型
     */
    private String type;

    /**
     * 是否被禁用
     */
    private Boolean isDeleted;
}
