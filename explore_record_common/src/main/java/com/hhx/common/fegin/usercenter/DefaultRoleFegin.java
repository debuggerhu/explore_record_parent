package com.hhx.common.fegin.usercenter;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.usercenter.role.RoleDetailDTO;
import com.hhx.common.dto.usercenter.role.RoleInfoDTO;
import com.hhx.common.dto.usercenter.role.request.CreateDefaultRoleDTO;
import com.hhx.common.dto.usercenter.role.request.UpdateDefaultRoleActionByActionNameDTO;
import com.hhx.common.dto.usercenter.role.request.UpdateDefaultRoleActionDTO;
import com.hhx.common.dto.usercenter.role.request.UpdateDefaultRoleDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author su Lichen
 * @Date 2020/5/28 16:59
 */
@FeignClient(value = Service.USER_CENTER, configuration = FeignConfig.class)
public interface DefaultRoleFegin {

    /**
     * 获取角色列表
     * 获取角色列表
     *
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @return 角色信息列表
     */
    @GetMapping("/default-role/list")
    ResponseEntity<ResponseData<PageInfo<RoleInfoDTO>>> list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 获取角色详细信息
     * 获取角色详细信息
     *
     * @param id 角色唯一标识
     * @return 角色详细信息
     */
    @GetMapping("/default-role/detail")
    ResponseEntity<ResponseData<RoleDetailDTO>> detail(@RequestParam("id") Long id);

    /**
     * 创建角色
     * 创建角色
     *
     * @param createDefaultRoleRequest 创建角色请求参数
     * @return 角色标识
     */
    @PostMapping("/default-role/create")
    ResponseEntity<ResponseData<Long>> create(@RequestBody CreateDefaultRoleDTO createDefaultRoleRequest);

    /**
     * 修改角色基本信息
     * 修改角色(基本信息修改默认角色的基本信息)
     *
     * @param updateDefaultRoleRequest 修改角色基本信息请求参数
     * @return 修改角色结果
     */
    @PostMapping("/default-role/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateDefaultRoleDTO updateDefaultRoleRequest);

    /**
     * 修改角色权限
     * 修改角色权限
     *
     * @param updateDefaultRoleActionRequest 修改角色权限请求参数
     * @return 修改角色结果
     */
    @PostMapping("/default-role/updateAction")
    ResponseEntity<ResponseData> updateAction(@RequestBody UpdateDefaultRoleActionDTO updateDefaultRoleActionRequest);

    /**
     * 修改角色权限
     * 修改角色权限(通过权限名称修改)
     *
     * @param updateDefaultRoleActionByActionNameDTO 修改角色权限请求参数
     * @return 修改角色结果
     */
    @PostMapping("/default-role/updateActionByActionName")
    ResponseEntity<ResponseData> updateActionByActionName(@RequestBody UpdateDefaultRoleActionByActionNameDTO updateDefaultRoleActionByActionNameDTO);

    /**
     * 删除角色
     * 删除角色
     *
     * @param id 角色唯一标识
     * @return 删除角色结果
     */
    @PostMapping("/default-role/delete/{id}")
    ResponseEntity<ResponseData> delete(@PathVariable("id") Long id);
}
