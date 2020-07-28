package com.hhx.common.constants.objectstorage;

/**
 * @author Wang Taiping
 * @date 2020/7/18 17:15
 */
public class BucketSelector {
    public static String getWisonicWebBucket(String env) {
        String bucket;
        RunTime runTime = RunTime.valueOf(env);
        switch (runTime) {
            case prod:
                bucket = "wisonic-web-prod";
                break;
            case test:
                bucket = "wisonic-web-test";
                break;
            default:
                bucket = "wisonic-dev";
                break;
        }
        return bucket;
    }

    public static String getWisonicBucket(String env) {
        String bucket;
        RunTime runTime = RunTime.valueOf(env);
        switch (runTime) {
            case prod:
                bucket = "wisonic";
                break;
            case test:
                bucket = "wisonic-test";
                break;
            default:
                bucket = "wisonic-dev";
                break;
        }
        return bucket;
    }

    public static String getWisonicDeviceUpgrade(String env) {
        String bucket;
        RunTime runTime = RunTime.valueOf(env);
        switch (runTime) {
            case prod:
                bucket = "wisonic-device-upgrade";
                break;
            case test:
                bucket = "wisonic-device-upgrade-test";
                break;
            default:
                bucket = "wisonic-dev";
        }
        return bucket;
    }

    public static String getWisonicWingBucket(String env) {
        String bucket;
        RunTime runTime = RunTime.valueOf(env);
        switch (runTime) {
            case prod:
                bucket = "wisonic-wing";
                break;
            case test:
                bucket = "wisonic-wing-test";
                break;
            default:
                bucket = "wisonic-dev";
                break;
        }
        return bucket;
    }
}
