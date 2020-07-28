package com.hhx.common.fegin.usercenter;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.usercenter.ActionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/4/23 14:15
 */
@FeignClient(value = Service.USER_CENTER, configuration = FeignConfig.class)
public interface AuthorizationFegin {
    @GetMapping("/authorization/getActions")
    List<ActionDTO> getActions(@RequestParam("appId") Long appId);
}
