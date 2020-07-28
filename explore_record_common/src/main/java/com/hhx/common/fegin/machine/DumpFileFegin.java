package com.hhx.common.fegin.machine;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.machineapi.dump.DownloadDumpFileDTO;
import com.hhx.common.dto.machineapi.dump.DumpFileDTO;
import com.hhx.common.dto.machineapi.dump.DumpFileStatisticsDTO;
import com.hhx.common.dto.machineapi.responsedto.dump.DumpFileCountDTO;
import com.hhx.common.dto.machineapi.responsedto.dump.DumpFileListDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * dump文件相关
 */
@FeignClient(value = Service.MACHINE_API, configuration = FeignConfig.class)
public interface DumpFileFegin {

    /**
     * 获取dump文件上传统计
     *
     * @param dumpFileStatisticsDTO
     * @return
     */
    @GetMapping("/rpc/dump-file/statistics")
    ResponseEntity<ResponseData<PageInfo<DumpFileCountDTO>>> getDumpFileStatistics(@SpringQueryMap DumpFileStatisticsDTO dumpFileStatisticsDTO);

    /**
     * 获取bat文件进行下载dump文件
     *
     * @param downloadDumpFileDTO
     * @return
     */
    @GetMapping("/rpc/dump-file/bat-script")
    ResponseEntity<ResponseData<String>> getBatScript(@SpringQueryMap DownloadDumpFileDTO downloadDumpFileDTO);

    /**
     * 获取dump或log文件列表信息
     *
     * @param dumpFileDTO
     * @return
     */
    @GetMapping("/rpc/dump-file/list-file")
    ResponseEntity<ResponseData<List<DumpFileListDTO>>> listDumpOrLogFile(@SpringQueryMap DumpFileDTO dumpFileDTO);
}
