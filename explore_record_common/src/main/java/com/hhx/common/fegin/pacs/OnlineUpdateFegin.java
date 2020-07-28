package com.hhx.common.fegin.pacs;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.pacs.onlineUpdate.UploadClientDTO;
import com.hhx.common.dto.pacs.onlineUpdate.request.UploadClientRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author su Lichen
 * @Date 2020/6/24 14:59
 */
@FeignClient(value = Service.PACS, configuration = FeignConfig.class)
public interface OnlineUpdateFegin {
    /**
     * 获取当前客户端安装包信息
     * 获取当前客户端安装包信息
     *
     * @return 当前客户端安装包信息
     */
    @GetMapping("/fegin/online-update/get")
    ResponseEntity<ResponseData<String>> get();

    /**
     * 获取上传s3信息
     * 获取上传s3信息
     *
     * @return 是否获取成功
     */
    @GetMapping("/fegin/online-update/getS3Upload")
    ResponseEntity<ResponseData<UploadClientDTO>> getS3Upload();

    /**
     * 上传新的客户端安装包
     * 上传新的客户端安装包（覆盖旧的）
     *
     * @return 是否上传成功
     */
    @PostMapping("/fegin/online-update/upload")
    ResponseEntity<ResponseData> upload(@RequestBody UploadClientRequestDTO uploadClientRequestDTO);

    /**
     * 获取最新客户端版本信息
     * 获取最新客户端版本信息
     *
     * @return 最新客户端版本信息
     */
    @GetMapping("/fegin/online-update/latest")
    ResponseEntity<ResponseData<byte[]>> getLatest();

    /**
     * 获取最新客户端安装程序
     * 获取最新客户端安装程序
     *
     * @return 最新客户端安装程序
     */
    @GetMapping("/fegin/online-update/pacs-setup")
    ResponseEntity<ResponseData<byte[]>> getPacsSetup();

    /**
     * 获取最新客户端blockmap
     * 获取最新客户端blockmap
     *
     * @return 最新客户端blockmap
     */
    @GetMapping("/fegin/online-update/pacs-setup-blockmap")
    ResponseEntity<ResponseData<byte[]>> getPacsBlockmap();
}
