package com.hhx.common.utils;

/**
 * 数据库相关工具
 */
public class DB {

    private static final SnowFlake SNOW_FLAKE = new SnowFlake(1, 1);

    /**
     * 生成19位唯一长整型guid
     *
     * @return guid
     */
    public static Long generateID() {
        return SNOW_FLAKE.nextId();
    }

    /**
     * 生成32位String型uuid
     *
     * @return uuid
     */
    public static String generateUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成用户名
     *
     * @return 用户名
     */
    public static String generateUsername() {
        return "wisonic-" + java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 15);
    }
}
