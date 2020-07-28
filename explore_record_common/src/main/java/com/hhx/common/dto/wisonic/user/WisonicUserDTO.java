package com.hhx.common.dto.wisonic.user;

import com.hhx.common.dto.usercenter.user.UserInfoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author su Lichen
 * @Date 2020/7/7 11:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WisonicUserDTO extends UserInfoDTO {
    /**
     * 电话号码所属区域
     */
    private String region;

    /**
     * 是否是公司内部成员
     */
    private Boolean isEmployee;

    /**
     * 医院
     */
    private String hospital;

    /**
     * 科室
     */
    private String department;

    /**
     * 职称
     */
    private String position;
}
