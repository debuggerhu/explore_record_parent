package com.hhx.common.fegin.machine;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.machineapi.responsedto.wing.UploadStatisticsByDateInfoDTO;
import com.hhx.common.dto.machineapi.responsedto.wing.UploadStatisticsInfoDTO;
import com.hhx.common.dto.machineapi.wing.MachineIdAndDateDTO;
import com.hhx.common.dto.machineapi.wing.WingAllFileSumDTO;
import com.hhx.common.dto.machineapi.wing.WingUploadStatisticsDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * wing导出相关
 */
@FeignClient(value = Service.MACHINE_API, configuration = FeignConfig.class)
public interface WingExportFegin {
    /**
     * 获取上传统计列表
     *
     * @param wingUploadStatisticsDTO
     * @return
     */
    @GetMapping("/rpc/wing/export/upload-statistics")
    ResponseEntity<ResponseData<PageInfo<UploadStatisticsInfoDTO>>> getUploadStatistics(@SpringQueryMap WingUploadStatisticsDTO wingUploadStatisticsDTO);

    /**
     * 获取wing文件上传统计时间及大小
     *
     * @param machineIdAndDateDTO 机器id和时间范围
     * @return
     */
    @GetMapping("/rpc/wing/export/upload-statistics/group-by-date")
    ResponseEntity<ResponseData<List<UploadStatisticsByDateInfoDTO>>> getUploadStatisticsGroupByDate(@SpringQueryMap MachineIdAndDateDTO machineIdAndDateDTO);

    /**
     * 导出bat文件用以下载wing文件
     *
     * @param machineIdAndDateDTO 机器id和时间范围
     */
    @GetMapping("/rpc/wing/export/bat-script")
    ResponseEntity<ResponseData<String>> getBatScript(@SpringQueryMap MachineIdAndDateDTO machineIdAndDateDTO);

    /**
     * 获取满足检索条件的所有exam文件大小
     *
     * @param examAllFileSumDTO
     * @return
     */
    @GetMapping("/rpc/wing/export/all-file-sum")
    ResponseEntity<ResponseData<Long>> getAllFileSum(@SpringQueryMap WingAllFileSumDTO examAllFileSumDTO);
}
