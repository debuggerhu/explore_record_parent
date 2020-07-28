package com.hhx.common.fegin.usercenter;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author su Lichen
 * @Date 2020/5/29 16:32
 */
@FeignClient(value = Service.USER_CENTER, configuration = FeignConfig.class)
public interface UserCenterHospitalFegin {

    /**
     * 为医疗机构添加默认角色
     * 为医疗机构添加默认角色
     *
     * @param hospitalId 医疗机构标识
     * @return 添加结果
     */
    @PostMapping("/hospital/addDefaultRole/{hospitalId}")
    ResponseEntity<ResponseData> addDefaultRole(@PathVariable("hospitalId") Long hospitalId);
}
