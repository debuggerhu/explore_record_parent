package com.hhx.common.fegin.hospital;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.hospital.HospitalDTO;
import com.hhx.common.dto.hospital.request.CheckUniqueValueDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2019/11/1 16:33
 */
@FeignClient(value = Service.HOSPITAL, configuration = FeignConfig.class)
public interface HospitalFegin {

    /**
     * 获取医院列表
     * @return 医院列表
     */
    @GetMapping("/fegin/hospital/list")
    List<HospitalDTO> list();

    /**
     * 获取单个医院信息
     * @param hospitalGuid 医院唯一标识
     * @return 医院信息
     */
    @GetMapping("/fegin/hospital/get")
    HospitalDTO get(@RequestParam("hospitalGuid") Long hospitalGuid);

    @PostMapping("/fegin/hospital/add")
    Long addHospital(@RequestBody HospitalDTO hospitalDTO);

    @PostMapping("/fegin/hospital/update")
    Boolean updateHospital(@RequestBody HospitalDTO hospitalDTO);

    @PostMapping("/fegin/hospital/verifyHospitalGuidList")
    Boolean verifyHospitalGuidList(@RequestBody List<Long> hospitalGuidList);

    /**
     * 禁用医院
     * @param id 医院唯一标识
     * @return 禁用结果
     */
    @PostMapping("/fegin/hospital/disable/{id}")
    ResponseEntity<ResponseData<Boolean>> disable(@PathVariable("id") Long id);

    /**
     * 启用医院
     * @param id 医院唯一标识
     * @return 启用结果
     */
    @PostMapping("/fegin/hospital/enable/{id}")
    ResponseEntity<ResponseData<Boolean>> enable(@PathVariable("id") Long id);

    /**
     * 根据名称获取医院列表（分页）
     * @param name 医院名称
     * @param pageNum 当前页
     * @param pageSize 一页大小
     * @return 医院信息列表
     */
    @GetMapping("/fegin/hospital/pageListByName")
    ResponseEntity<ResponseData<PageInfo<HospitalDTO>>> pageListByName(@RequestParam("name") String name, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 验证唯一参数
     * @param checkUniqueValueDTO 验证唯一参数请求DTO
     * @return 是否验证通过
     */
    @PostMapping("/fegin/hospital/checkUniqueValue")
    ResponseEntity<ResponseData> checkUniqueValue(@RequestBody CheckUniqueValueDTO checkUniqueValueDTO);
}
