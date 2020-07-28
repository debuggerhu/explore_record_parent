package com.hhx.common.fegin.usercenter;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.usercenter.user.UserInfoDTO;
import com.hhx.common.dto.usercenter.user.request.AddHospitalUserDTO;
import com.hhx.common.dto.usercenter.user.request.CheckDTO;
import com.hhx.common.dto.usercenter.user.request.CreateHospitalUserDTO;
import com.hhx.common.dto.usercenter.user.request.UpdateHospitalUserDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author su Lichen
 * @Date 2020/6/3 10:24
 */
@FeignClient(value = Service.USER_CENTER, configuration = FeignConfig.class)
public interface UserCenterUserFegin {
    /**
     * 获取医院用户列表
     * 获取医院用户列表 --支持用户名称/电话号码查询
     *
     * @param query 用户名称/电话号码(为空时,获取全部用户)
     * @param hospitalId 医院唯一标识
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @return 用户信息列表
     */
    @GetMapping("/hospital-user/list")
    ResponseEntity<ResponseData<PageInfo<UserInfoDTO>>> list(@RequestParam("query") String query, @RequestParam("hospitalId") Long hospitalId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 获取医院用户信息
     * 获取医院用户信息
     *
     * @param userId 用户标识
     * @param hospitalId 医院标识
     * @return 用户信息
     */
    @GetMapping("/hospital-user/get")
    ResponseEntity<ResponseData<UserInfoDTO>> get(@RequestParam("userId") String userId, @RequestParam("hospitalId") Long hospitalId);

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
    @GetMapping("/hospital-user/getHospitalUnAssociatedUser")
    ResponseEntity<ResponseData<PageInfo<UserInfoDTO>>> getHospitalUnAssociatedUser(@RequestParam("query") String query, @RequestParam("hospitalId") Long hospitalId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 创建医院用户
     * 创建医院用户
     *
     * @param createHospitalUserDTO 创建医院用户请求参数
     * @return userIdlist
     */
    @PostMapping("/hospital-user/create")
    ResponseEntity<ResponseData<Map<String, String>>> create(@RequestBody CreateHospitalUserDTO createHospitalUserDTO);

    /**
     * 添加医院用户
     * 添加医院用户（从用户列表中导入）
     *
     * @param addHospitalUserDTO 添加医院用户请求参数
     * @return 添加医院用户结果
     */
    @PostMapping("/hospital-user/add")
    ResponseEntity<ResponseData> add(@RequestBody AddHospitalUserDTO addHospitalUserDTO);

    /**
     * 修改医院用户信息
     * 修改医院用户信息
     *
     * @param updateHospitalUserDTO 修改医院用户请求参数
     * @return 修改医院用户结果
     */
    @PostMapping("/hospital-user/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateHospitalUserDTO updateHospitalUserDTO);

    /**
     * 验证接口
     * 验证手机号：是否重复（不可重复）
     * 验证角色：是否存在以及是否和当前医院关联（需要存在，关联）
     * 验证用户：是否存在以及是否和当前医院关联（需要存在，不关联）
     *
     * @param checkDTO 检查电话号码和角色请求
     * @return 是否可用
     */
    @PostMapping("/hospital-user/check")
    ResponseEntity<ResponseData> check(@RequestBody CheckDTO checkDTO);
}
