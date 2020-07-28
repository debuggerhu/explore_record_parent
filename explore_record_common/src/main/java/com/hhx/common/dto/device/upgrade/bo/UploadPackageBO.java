package com.hhx.common.dto.device.upgrade.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UploadPackageBO {
    /**
     * 上传文件的路径
     */
    @NotBlank
    private String uploadUrl;
    /**
     * s3的桶
     */
    @NotBlank
    private String bucket;

    @NotBlank
    private String token;
}
