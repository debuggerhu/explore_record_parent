package com.hhx.common.constants.objectstorage;

import lombok.Data;

/**
 * @author Wang Taiping
 * @date 2020/6/29 09:44
 */
@Data
public class SecurityToken {
    private String accessKeyId;
    private String secretAccessKey;
    private String sessionToken;
    private String expiration;
    private String region;
    private int duration;
    private String endpoint;
    private String bucket;
    private String key;
    private String url;
}
