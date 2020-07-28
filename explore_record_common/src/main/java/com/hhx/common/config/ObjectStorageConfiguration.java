package com.hhx.common.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.util.EC2MetadataUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wang Taiping
 * @date 2020/7/9 11:33
 */
@Configuration
@ComponentScan(value = "com.hhx.common.utils.storage")
@Data
@Slf4j
public class ObjectStorageConfiguration {
    private static InstanceProfileCredentialsProvider instanceProfileCredentialsProvider = null;
    @Value("${spring.profiles.active}")
    private String runTime;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${objectStorage.bucket}")
    private String bucket;

    @Value("${objectStorage.endpoint}")
    private String endpoint;

    @Value("${objectStorage.accessKey}")
    private String accessKey;

    @Value("${objectStorage.secretKey}")
    private String secretKey;

    @Value("${objectStorage.region}")
    private String region;

    @Value("${objectStorage.keyDuration}")
    private Integer keyDuration;

    @Value("${objectStorage.roleArn}")
    private String roleArn;

    @Value("${objectStorage.host}")
    private String host;

    @Value("${objectStorage.provider}")
    private String provider;

    static {
        if (EC2MetadataUtils.getInstanceId() != null) {
            instanceProfileCredentialsProvider = new InstanceProfileCredentialsProvider(true);
            log.info("Run At EC2 Instance");
        } else {
            log.info("Run At Local");
        }
    }

    @Bean
    public AmazonS3 amazonS3() {
        AmazonS3Client s3Client = new AmazonS3Client(awsCredentials());
        s3Client.setRegion(Region.getRegion(Regions.fromName(region)));
        return s3Client;
    }

    @Bean
    public AWSSecurityTokenServiceClient awsSecurityTokenServiceClient() {
        AWSSecurityTokenServiceClient awsSecurityTokenServiceClient = new AWSSecurityTokenServiceClient(awsCredentials());
        awsSecurityTokenServiceClient.setRegion(Region.getRegion(Regions.fromName(region)));
        return awsSecurityTokenServiceClient;
    }

    @Bean
    public AWSCredentials awsCredentials() {
        if (instanceProfileCredentialsProvider != null) {
            log.info("Run At EC2 Instance");
            return instanceProfileCredentialsProvider.getCredentials();
        } else {
            log.info("Run At DeBug Mode");
            return basicAWSCredentials();
        }
    }

    @Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }
}
