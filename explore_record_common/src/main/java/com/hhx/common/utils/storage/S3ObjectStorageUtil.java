package com.hhx.common.utils.storage;

import com.hhx.common.config.ObjectStorageConfiguration;
import com.hhx.common.constants.objectstorage.SecurityToken;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wang Taiping
 * @date 2020/7/17 15:13
 */
@Component
public class S3ObjectStorageUtil extends FileUploadUtil {
    @Resource
    private S3ObjectStorageService objectStorageService;
    @Resource
    private ObjectStorageConfiguration objectStorageConfiguration;

    private static final String SEPERATOR = "/";

    /**
     * 后台上传文件
     *
     * @param file
     * @return 上传成功bucket/key 上传失败为空串
     * @see S3ObjectStorageService#uploadFile(File, String, String, String)
     * 注意contentType默认是下载类型的文件，如果是浏览器可以解析的文件建议重写{@link FileUploadUtil#configContentType()}
     */
    @Override
    public String upload(File file, String key) {
        return objectStorageService.uploadFile(file, configBucket(), configContentType(), configKey(key));
    }

    @Override
    public SecurityToken getUploadToken(String subKey) {
        SecurityToken token = objectStorageService.getUploadToken(subKey);
        String key = configSubKey(subKey);
        String url = objectStorageConfiguration.getEndpoint() + SEPERATOR + configBucket() + SEPERATOR + key;
        token.setEndpoint(objectStorageConfiguration.getEndpoint());
        token.setBucket(configBucket());
        token.setKey(key);
        token.setUrl(url);
        return token;
    }

    protected String configSubKey(String subKey) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + SEPERATOR + System.currentTimeMillis() + "-" + subKey.substring(subKey.lastIndexOf("/") + 1);
    }

    /**
     * @param key
     * @return
     * @deprecated 这个接口是为了兼容旧的业务，新的业务请重写{@link #configSubKey(String)}方法
     */
    protected String configKey(String key) {
        //可配置key(bucket 后面第一个分隔符到末尾路径)
        return configModule() + SEPERATOR + configFunction() + SEPERATOR + configSubKey(key);
    }

    protected String configBucket() {
        //默认用配置文件中的桶
        return objectStorageConfiguration.getBucket();
    }

    protected String configModule() {
        //默认用applicationName
        return objectStorageConfiguration.getApplicationName();
    }

    protected String configFunction() {
        //功能模块默认为other
        return "undefined";
    }
}