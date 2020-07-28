package com.hhx.common.fegin.usercenter;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.usercenter.role.RoleDetailDTO;
import com.hhx.common.dto.usercenter.role.RoleInfoDTO;
import com.hhx.common.dto.usercenter.role.request.CreateHospitalRoleDTO;
import com.hhx.common.dto.usercenter.role.request.DeleteHospitalRoleDTO;
import com.hhx.common.dto.usercenter.role.request.UpdateHospitalRoleActionDTO;
import com.hhx.common.dto.usercenter.role.request.UpdateHospitalRoleDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author su Lichen
 * @Date 2020/5/30 15:31
 */
@FeignClient(value = Service.USER_CENTER, configuration = FeignConfig.class)
public interface HospitalRoleFegin {
    /**
     * 获取角色列表
     * 获取角色列表
     *
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @param hospitalId 医院唯一标识
     * @return 角色信息列表
     */
    @GetMapping("/hospital-role/list")
    ResponseEntity<ResponseData<PageInfo<RoleInfoDTO>>> list(@RequestParam("hospitalId") Long hospitalId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 获取角色详细信息
     * 获取角色详细信息
     *
     * @param id 角色唯一标识
     * @return 角色详细信息
     */
    @GetMapping("/hospital-role/detail")
    ResponseEntity<ResponseData<RoleDetailDTO>> detail(@RequestParam("id") Long id);

    /**
     * 创建角色
     * 创建角色（默认为pacs非默认角色）
     *
     * @param createHospitalRoleRequest 创建角色请求参数
     * @return 创建角色结果
     */
    @PostMapping("/hospital-role/create")
    ResponseEntity<ResponseData> create(@RequestBody CreateHospitalRoleDTO createHospitalRoleRequest);

    /**
     * 修改角色基本信息
     * 修改角色(基本信息修改默认角色的基本信息)
     *
     * @param updateHospitalRoleDTO 修改角色基本信息请求参数
     * @return 修改角色结果
     */
    @PostMapping("/hospital-role/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateHospitalRoleDTO updateHospitalRoleDTO);

    /**
     * 修改角色权限
     * 修改角色权限
     *
     * @param updateHospitalRoleActionDTO 修改医院角色权限请求参数
     * @return 修改医院角色结果
     */
    @PostMapping("/hospital-role/updateAction")
    ResponseEntity<ResponseData> updateAction(@RequestBody UpdateHospitalRoleActionDTO updateHospitalRoleActionDTO);

    /**
     * 删除角色
     * 删除角色
     *
     * @param deleteHospitalRoleDTO 删除医院角色请求
     * @return 删除角色结果
     */
    @PostMapping("/hospital-role/delete")
    ResponseEntity<ResponseData> delete(@RequestBody DeleteHospitalRoleDTO deleteHospitalRoleDTO);
}
