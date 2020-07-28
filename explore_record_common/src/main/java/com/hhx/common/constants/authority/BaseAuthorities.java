package com.hhx.common.constants.authority;

import com.hhx.common.constants.Application;

/**
 * @author 80255
 */
public interface BaseAuthorities {

    /**
     * 获取模块字段
     * @return 模块字段
     */
    BaseModule getModule();

    /**
     * 获取权限字段
     * @return 权限字段
     */
    String getAction();

    /**
     * 获取权限别名
     * @return 权限别名
     */
    String getAlias();

    /**
     * 获取权限应用
     * @return 应用名称
     */
    Application getApplication();

    /**
     * 获取权限全称
     * @return 权限全称（规则：应用名：模块名：权限名）
     */
    default String getActionName() {
        return getApplication().getRemake() + ":" + getModule().getModuleName() + ":" + getAction();
    }

    /**
     * 获取模块名称
     * @return 获取模块名称（中文别名）
     */
    default String getModuleName() {
        return getModule().getModuleAlias();
    }
}
