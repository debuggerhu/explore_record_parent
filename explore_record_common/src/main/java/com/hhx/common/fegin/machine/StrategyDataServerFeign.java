package com.hhx.common.fegin.machine;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 设备升级策略相关的数据服务转发
 */
@FeignClient(value = Service.MACHINE_API, configuration = FeignConfig.class)
public interface StrategyDataServerFeign {
    @PostMapping("/strategy/t1")
    String t1(@RequestParam("ppp") String p2p);
}
