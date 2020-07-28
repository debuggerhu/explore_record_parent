package com.hhx.common.dto.pacs.onlineUpdate.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author su Lichen
 * @Date 2020/4/28 15:23
 */
@Data
public class UploadClientRequestDTO {
    /**
     * 客户端版本信息
     */
    private String latest;

    /**
     * 客户端安装程序
     */
    private String pacsSetup;

    /**
     * 客户端blockmap
     */
    private String pacsBlockmap;
}
