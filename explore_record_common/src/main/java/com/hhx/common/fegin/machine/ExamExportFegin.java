package com.hhx.common.fegin.machine;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.machineapi.exam.ExamAllFileSumDTO;
import com.hhx.common.dto.machineapi.exam.UploadStatisticsDTO;
import com.hhx.common.dto.machineapi.responsedto.wing.UploadStatisticsByDateInfoDTO;
import com.hhx.common.dto.machineapi.responsedto.wing.UploadStatisticsInfoDTO;
import com.hhx.common.dto.machineapi.wing.MachineIdAndDateDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 检查导出相关
 */
@FeignClient(value = Service.MACHINE_API, configuration = FeignConfig.class)
public interface ExamExportFegin {

    /**
     * 获取上传统计列表
     *
     * @param uploadStatisticsDTO 上传统计检索信息
     * @return
     */
    @GetMapping(value = "/rpc/exam/export/upload-statistics")
    ResponseEntity<ResponseData<PageInfo<UploadStatisticsInfoDTO>>> getUploadStatistics(@SpringQueryMap UploadStatisticsDTO uploadStatisticsDTO);

    /**
     * 获取exam文件上传统计时间及大小
     *
     * @param machineIdAndDateDTO 机器id和时间范围
     * @return
     */
    @GetMapping("/rpc/exam/export/upload-statistics/group-by-date")
    ResponseEntity<ResponseData<List<UploadStatisticsByDateInfoDTO>>> getUploadStatisticsGroupByDate(@SpringQueryMap MachineIdAndDateDTO machineIdAndDateDTO);

    /**
     * 导出bat文件用以下载exam文件
     *
     * @param machineIdAndDateDTO 机器id和时间范围
     * @return
     */
    @GetMapping("/rpc/exam/export/bat-script")
    ResponseEntity<ResponseData<String>> getBatScript(@SpringQueryMap MachineIdAndDateDTO machineIdAndDateDTO);

    /**
     * 获取满足检索条件的所有exam文件大小
     *
     * @param examAllFileSumDTO exam文件检索条件信息
     * @return
     */
    @GetMapping("/rpc/exam/export/all-file-sum")
    ResponseEntity<ResponseData<Long>> getAllFileSum(@SpringQueryMap ExamAllFileSumDTO examAllFileSumDTO);
}
