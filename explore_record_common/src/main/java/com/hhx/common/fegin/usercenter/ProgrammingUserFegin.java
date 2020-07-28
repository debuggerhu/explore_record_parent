package com.hhx.common.fegin.usercenter;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.usercenter.programminguser.ProgrammingUserDetailDTO;
import com.hhx.common.dto.usercenter.programminguser.ProgrammingUserInfoDTO;
import com.hhx.common.dto.usercenter.programminguser.request.CreateProgrammingUserRequestDTO;
import com.hhx.common.dto.usercenter.programminguser.request.UpdateProgrammingHospitalRequestDTO;
import com.hhx.common.dto.usercenter.programminguser.request.UpdateProgrammingRoleRequestDTO;
import com.hhx.common.dto.usercenter.programminguser.request.UpdateProgrammingUserRequestDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author su Lichen
 * @Date 2020/5/20 15:13
 */
@FeignClient(value = Service.USER_CENTER, configuration = FeignConfig.class)
public interface ProgrammingUserFegin {
    /**
     * 获取编程用户列表
     * 获取全部编程用户列表
     *
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @return 编程用户信息列表
     */
    @GetMapping("/programming-user/list")
    ResponseEntity<ResponseData<PageInfo<ProgrammingUserInfoDTO>>> list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 获取编程用户详细信息
     * 获取编程用户详细信息
     *
     * @param id 编程用户唯一标识
     * @return 编程用户详细信息
     */
    @GetMapping("/programming-user/detail")
    ResponseEntity<ResponseData<ProgrammingUserDetailDTO>> detail(@RequestParam("id") String id);

    /**
     * 创建编程用户
     * 创建编程用户
     *
     * @param createProgrammingUserRequestDTO 创建编程用户请求参数
     * @return 创建的编程用户信息回显
     */
    @PostMapping("/programming-user/create")
    ResponseEntity<ResponseData<ProgrammingUserInfoDTO>> create(@RequestBody CreateProgrammingUserRequestDTO createProgrammingUserRequestDTO);

    /**
     * 修改编程用户信息
     * 修改编程用户信息
     *
     * @param updateProgrammingUserRequestDTO 修改编程用户请求参数
     * @return 修改编程用户结果
     */
    @PostMapping("/programming-user/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateProgrammingUserRequestDTO updateProgrammingUserRequestDTO);

    /**
     * 修改编程用户密码
     * 修改编程用户密码（密码后端自动生成）
     *
     * @param id 编程用户唯一标识
     * @return 编程用户新密码
     */
    @PostMapping("/programming-user/updatePassword/{id}")
    ResponseEntity<ResponseData<String>> updatePassword(@PathVariable("id") String id);

    /**
     * 修改编程用户角色
     * 修改编程用户角色
     *
     * @param updateProgrammingRoleRequestDTO 修改编程用户角色请求参数
     * @return 修改结果
     */
    @PostMapping("/programming-user/updateRole")
    ResponseEntity<ResponseData> updateRole(@RequestBody UpdateProgrammingRoleRequestDTO updateProgrammingRoleRequestDTO);

    /**
     * 修改编程用户医院
     * 修改编程用户医院
     *
     * @param updateProgrammingHospitalRequestDTO 修改编程用户医院请求参数
     * @return 修改编程用户医院结果
     */
    @PostMapping("/programming-user/updateHospital")
    ResponseEntity<ResponseData> updateHospital(@RequestBody UpdateProgrammingHospitalRequestDTO updateProgrammingHospitalRequestDTO);

    /**
     * 删除编程用户
     * 删除编程用户
     *
     * @param id 编程用户唯一标识
     * @return 删除编程用户结果
     */
    @PostMapping("/programming-user/delete/{id}")
    ResponseEntity<ResponseData> delete(@PathVariable("id") String id);
}
