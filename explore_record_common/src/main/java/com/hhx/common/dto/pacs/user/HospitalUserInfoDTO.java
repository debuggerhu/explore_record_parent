package com.hhx.common.dto.pacs.user;

import lombok.Data;

/**
 * @Author su Lichen
 * @Date 2020/4/23 14:30
 */
@Data
public class HospitalUserInfoDTO {
    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 用户姓名拼音
     */
    private String spellCode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工号
     */
    private String code;

    /**
     * 签名图片
     */
    private String doctorCA;

    /**
     * 备注
     */
    private String memo;

    /**
     * 是否禁用
     */
    private Boolean isDeleted;

    /**
     * 角色标识
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;
}
