package com.hhx.common.utils.storage;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.IOUtils;
import com.hhx.common.config.ObjectStorageConfiguration;
import com.hhx.common.constants.objectstorage.SecurityToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author Wang Taiping
 * @date 2020/7/14 19:19
 */
@Slf4j
@Service
public class S3ObjectStorageService implements ObjectStorageService {
    @Resource
    private AmazonS3 amazonS3;
    @Resource
    private ObjectStorageConfiguration objectStorageConfiguration;
    @Resource
    private AWSSecurityTokenServiceClient tokenServiceClient;


    @Override
    public String uploadFile(File file, String bucket, String contentType, String path) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, path, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(contentType);
        putObjectRequest.setMetadata(objectMetadata);
        boolean uploadSuccess = false;
        try {
            amazonS3.putObject(putObjectRequest);
            log.info("UploadFilePath : " + path);
            uploadSuccess = true;
        } catch (AmazonServiceException ase) {
            log.info("Upload Error Message:" + ase.getMessage());
        } catch (AmazonClientException ace) {
            log.info("Upload Error Message: " + ace.getMessage());
        } catch (Exception e) {
            log.info("uploadFile Error Message: " + e.getMessage());
            log.error(e.toString(), e);
        }
        if (uploadSuccess) {
            return bucket + "/" + path;
        }
        return "";
    }

    @Override
    public SecurityToken getUploadToken(String filename) {
        AssumeRoleRequest assumeRoleRequest = new AssumeRoleRequest();
        assumeRoleRequest.setRoleArn(objectStorageConfiguration.getRoleArn());
        assumeRoleRequest.setDurationSeconds(objectStorageConfiguration.getKeyDuration());
        assumeRoleRequest.setRoleSessionName("wisonic");
        AssumeRoleResult result = tokenServiceClient.assumeRole(assumeRoleRequest);
        SecurityToken token = new SecurityToken();
        token.setDuration(objectStorageConfiguration.getKeyDuration());
        token.setSessionToken(result.getCredentials().getSessionToken());
        token.setSecretAccessKey(result.getCredentials().getSecretAccessKey());
        token.setAccessKeyId(result.getCredentials().getAccessKeyId());
        token.setEndpoint(objectStorageConfiguration.getEndpoint());
        token.setExpiration(DateUtils.formatISO8601Date(result.getCredentials().getExpiration()));
        token.setRegion(objectStorageConfiguration.getRegion());
        return token;
    }

    @Override
    public byte[] getObject(String bucketName, String key) {
        S3Object object = amazonS3.getObject(bucketName, key);

        S3ObjectInputStream s3Stream = object.getObjectContent();

        byte[] fileByte = null;
        try {
            fileByte = IOUtils.toByteArray(s3Stream);
        } catch (IOException e) {
            log.error("get objectByte error");
        } finally {
            try {
                s3Stream.close();
            } catch (IOException e) {
                log.error("s3Stream close error");
            }
        }
        return fileByte;
    }

    @Override
    public boolean copyObject(String srcBucket, String srcKey, String desBucket, String desKey) {
        try {
            amazonS3.copyObject(new CopyObjectRequest(srcBucket, srcKey, desBucket, desKey));
        } catch (SdkClientException e) {
            log.error("copy object error:", e);
            return false;
        }
        return true;
    }
}
