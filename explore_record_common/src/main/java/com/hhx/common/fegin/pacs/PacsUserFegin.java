package com.hhx.common.fegin.pacs;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.pacs.user.HospitalUserInfoDTO;
import com.hhx.common.dto.pacs.user.request.*;
import com.hhx.common.dto.usercenter.user.UserInfoDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author su Lichen
 * @Date 2020/6/4 10:01
 */
@FeignClient(value = Service.PACS, configuration = FeignConfig.class)
public interface PacsUserFegin {
    /**
     * 通过用户姓名/电话号码模糊查询医院用户列表
     * 通过用户姓名/电话号码模糊查询医院用户列表
     *
     * @param query 用户名称/电话号码
     * @param hospitalId 医院唯一标识
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @return 用户信息列表
     */
    @GetMapping("/fegin/user/list")
    ResponseEntity<ResponseData<PageInfo<HospitalUserInfoDTO>>> list(@RequestParam("query") String query, @RequestParam("hospitalId") Long hospitalId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 获取医院未关联用户列表
     * 获取医院未关联用户列表
     *
     * @param query 用户名称/电话号码
     * @param hospitalId 医院唯一标识
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @return 医院未关联用户信息列表
     */
    @GetMapping("/fegin/user/getHospitalUnAssociatedUser")
    ResponseEntity<ResponseData<PageInfo<UserInfoDTO>>> getHospitalUnAssociatedUser(@RequestParam("query") String query, @RequestParam("hospitalId") Long hospitalId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 创建医院用户
     * 创建医院用户
     *
     * @param createUserDTO 创建医院用户请求参数
     * @return 创建医院用户结果
     */
    @PostMapping("/fegin/user/create")
    ResponseEntity<ResponseData> create(@RequestBody CreateUserDTO createUserDTO);

    /**
     * 添加医院用户
     * 添加医院用户（已存在的用户中选择）
     *
     * @param addUserDTO 添加医院用户请求参数
     * @return 添加医院用户结果
     */
    @PostMapping("/fegin/user/add")
    ResponseEntity<ResponseData> add(@RequestBody AddUserDTO addUserDTO);

    /**
     * 修改医院用户信息
     * 修改医院用户信息
     *
     * @param updateUserDTO 修改医院用户请求参数
     * @return 修改医院用户结果
     */
    @PostMapping("/fegin/user/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateUserDTO updateUserDTO);

    /**
     * 禁用医院用户
     * 禁用医院用户(删除用户和医院的关联，禁用pacs用户信息)
     *
     * @param disableUserDTO 禁用医院用户请求
     * @return 禁用院用户结果
     */
    @PostMapping("/fegin/user/disable")
    ResponseEntity<ResponseData> disable(@RequestBody DisableUserDTO disableUserDTO);

    /**
     * 启用医院用户
     * 启用医院用户(删除用户和医院的关联，禁用pacs用户信息)
     *
     * @param enableUserDTO 启用医院用户请求
     * @return 启用院用户结果
     */
    @PostMapping("/fegin/user/enable")
    ResponseEntity<ResponseData> enable(@RequestBody EnableUserDTO enableUserDTO);
}
