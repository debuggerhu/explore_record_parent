package com.hhx.common.dto.pacs.hospital;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/4/23 15:40
 */
@Data
public class HospitalInfoDTO {
    /**
     * 医院唯一标识
     */
    private Long id;

    /**
     * 医院名称
     */
    private String name;

    /**
     * 医疗机构代码
     */
    private String code;

    /**
     * 医院等级名称
     */
    private String levelName;

    /**
     * 是否是基础医院
     */
    private Boolean isDataProvider;

    /**
     * 是否被禁用，被禁用医院无法进行编辑和详细信息查看
     * 1为禁用，0为未禁用
     */
    private Integer isDeleted;
}
