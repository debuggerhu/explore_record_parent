package com.hhx.common.fegin.usercenter;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.usercenter.role.RoleDetailDTO;
import com.hhx.common.dto.usercenter.role.RoleInfoDTO;
import com.hhx.common.dto.usercenter.role.request.*;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Author su Lichen
 * @Date 2020/4/24 9:19
 */
@FeignClient(value = Service.USER_CENTER, configuration = FeignConfig.class)
public interface UserCenterRoleFegin {
    /**
     * 获取角色列表
     * 获取华声云角色列表
     *
     * @return 角色信息列表
     */
    @GetMapping("/role/list")
    ResponseEntity<ResponseData<PageInfo<RoleInfoDTO>>> list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 获取角色详细信息
     * 获取角色详细信息
     *
     * @param id 角色唯一标识
     * @return 角色详细信息
     */
    @GetMapping("/role/detail")
    ResponseEntity<ResponseData<RoleDetailDTO>> detail(@RequestParam("id") Long id);

    /**
     * 创建角色
     * 创建角色
     *
     * @param createRoleDTO 创建角色请求参数
     * @return 创建角色标识
     */
    @PostMapping("/role/create")
    ResponseEntity<ResponseData<Long>> create(@RequestBody CreateRoleDTO createRoleDTO);

    /**
     * 修改角色基本信息
     * 修改角色基本信息修改
     *
     * @param updateRoleDTO 修改角色基本信息请求参数
     * @return 修改角色结果
     */
    @PostMapping("/role/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateRoleDTO updateRoleDTO);

    /**
     * 修改角色权限
     * 修改角色权限
     *
     * @param updateRoleActionDTO 修改角色权限请求参数
     * @return 修改角色结果
     */
    @PostMapping("/role/updateAction")
    ResponseEntity<ResponseData> updateAction(@RequestBody UpdateRoleActionDTO updateRoleActionDTO);

    /**
     * 删除角色
     * 删除角色(未关联医院的角色才可以删除)
     *
     * @param id 角色唯一标识
     * @return 删除角色结果
     */
    @PostMapping("/role/delete/{id}")
    ResponseEntity<ResponseData> delete(@PathVariable("id") Long id);

    /**
     * 添加角色用户
     * 添加角色用户
     *
     * @param addUsersRequest 添加角色用户请求
     * @return 添加角色用户结果
     */
    @PostMapping("/role/addUsers")
    ResponseEntity<ResponseData> addUsers(@RequestBody AddRoleUserDTO addUsersRequest);

    /**
     * 删除角色用户
     * 删除角色用户
     *
     * @param deleteUserRequest 删除角色用户请求
     * @return 删除角色用户结果
     */
    @PostMapping("/role/deleteUser")
    ResponseEntity<ResponseData> deleteUser(@RequestBody DeleteRoleUserDTO deleteUserRequest);
}
