package com.hhx.common.utils.storage;

import com.hhx.common.constants.objectstorage.SecurityToken;

import java.io.File;

/**
 * @author Wang Taiping
 * @date 2020/7/17 14:50
 */
public abstract class FileUploadUtil {

    abstract public String upload(File file,String key);

    abstract public SecurityToken getUploadToken(String filename);

    protected String configContentType() {
        return "application/octet-stream";
    }

}
