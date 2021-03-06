package com.hhx.common.fegin.hospital;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.hospital.HospitalTypeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2019/10/31 16:38
 */
@FeignClient(value = Service.HOSPITAL, configuration = FeignConfig.class)
public interface TypeFegin {

    @GetMapping("/fegin/type/list")
    ResponseEntity<ResponseData<List<HospitalTypeDTO>>> list();
}
