package com.hhx.common.utils.storage;

import com.hhx.common.constants.objectstorage.SecurityToken;

import java.io.File;

/**
 * @author Wang Taiping
 * @date 2020/7/14 15:17
 */
public interface ObjectStorageService {

    byte[] getObject(String bucketName, String key);

    /**
     * 后台上传文件
     * @param file
     * @param bucket
     * @param contentType
     * @param key
     * @return bucket/key
     */
    String uploadFile(File file, String bucket, String contentType, String key);

    SecurityToken getUploadToken(String filename);

    boolean copyObject(String srcBucket, String srcKey, String desBucket, String desKey);
}
