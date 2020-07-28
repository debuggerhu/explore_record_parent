package com.hhx.common.dto.pacs.onlineUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author su Lichen
 * @Date 2020/6/24 17:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadClientDTO {
    /**
     * 上传s3的桶名
     */
    private String bucket;

    /**
     * latest文件上传的key
     */
    private String latestKey;

    /**
     * blockmap文件上传的key
     */
    private String blockmapKey;

    /**
     * setup文件上传的key
     */
    private String setupKey;
}
