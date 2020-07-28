package com.hhx.common.fegin.pacs;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.pacs.hospital.HospitalDetailDTO;
import com.hhx.common.dto.pacs.hospital.HospitalInfoDTO;
import com.hhx.common.dto.pacs.hospital.request.CreateHospitalDTO;
import com.hhx.common.dto.pacs.hospital.request.UpdateHospitalDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author su Lichen
 * @Date 2020/5/26 14:45
 */
@FeignClient(value = Service.PACS, configuration = FeignConfig.class)
public interface PacsHospitalFegin {
    /**
     * 获取医院列表
     * 支持通过医院名称过滤
     *
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @param name 医院名称 （不填则查询所有）
     * @return 医院信息列表
     */
    @GetMapping("/fegin/hospital/list")
    ResponseEntity<ResponseData<PageInfo<HospitalInfoDTO>>> list(@RequestParam("name") String name, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 获取医院详细信息
     * 获取医院详细信息
     *
     * @param id 医院唯一标识
     * @return 医院详细信息
     */
    @GetMapping("/fegin/hospital/detail")
    ResponseEntity<ResponseData<HospitalDetailDTO>> detail(@RequestParam("id") Long id);

    /**
     * 创建医院
     * 创建医院
     *
     * @param createHospitalDTO 创建医院请求参数
     * @return 创建医院结果
     */
    @PostMapping("/fegin/hospital/create")
    ResponseEntity<ResponseData> create(@RequestBody CreateHospitalDTO createHospitalDTO);

    /**
     * 修改医院基本信息
     * 修改医院基本信息
     *
     * @param updateHospitalDTO 修改医院基本信息请求参数
     * @return 修改医院基本信息结果
     */
    @PostMapping("/fegin/hospital/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateHospitalDTO updateHospitalDTO);

    /**
     * 获取基础数据源列表
     * @return 数据源列表标识
     */
    @GetMapping("/fegin/hospital/dataProviderList")
    ResponseEntity<ResponseData<List<HospitalInfoDTO>>> dataProviderList();
}
