package com.hhx.common.fegin.pacs;

import com.hhx.common.config.FeignConfig;
import com.hhx.common.constants.ResponseData;
import com.hhx.common.constants.Service;
import com.hhx.common.dto.pacs.reporttemplate.ReportTemplateInfoDTO;
import com.hhx.common.dto.pacs.reporttemplate.request.DisableReportTemplateDTO;
import com.hhx.common.dto.pacs.reporttemplate.request.EnableReportTemplateDTO;
import com.hhx.common.dto.pacs.reporttemplate.request.UpdateReportTemplateDTO;
import com.hhx.common.dto.pacs.reporttemplate.request.UploadReportTemplateDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author su Lichen
 * @Date 2020/6/8 18:00
 */
@FeignClient(value = Service.PACS, configuration = FeignConfig.class)
public interface ReportTemplateFegin {
    /**
     * 获取报告模板列表
     * 获取报告模板列表(通过医院划分)
     *
     * @param hospitalId 医院唯一标识
     * @param pageNum 当前页数
     * @param pageSize 每一页的大小
     * @return 报告模板列表
     */
    @GetMapping("/fegin/report-template/list")
    ResponseEntity<ResponseData<PageInfo<ReportTemplateInfoDTO>>> list(@RequestParam("hospitalId") Long hospitalId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 上传报告模板信息
     * 上传报告模板信息
     *
     * @param uploadReportTemplateDTO 上传报告模板请求参数
     * @return 上传报告模板结果
     */
    @PostMapping("/fegin/report-template/upload")
    ResponseEntity<ResponseData> upload(@RequestBody UploadReportTemplateDTO uploadReportTemplateDTO);

    /**
     * 修改报告模板信息
     * 修改报告模板信息
     *
     * @param updateReportTemplateDTO 修改报告模板请求参数
     * @return 修改报告模板结果
     */
    @PostMapping("/fegin/report-template/update")
    ResponseEntity<ResponseData> update(@RequestBody UpdateReportTemplateDTO updateReportTemplateDTO);

    /**
     * 禁用报告模板
     * 禁用报告模板
     *
     * @param disableReportTemplateDTO 禁用报告模板请求
     * @return 禁用报告模板结果
     */
    @PostMapping("/fegin/report-template/disable")
    ResponseEntity<ResponseData> disable(@RequestBody DisableReportTemplateDTO disableReportTemplateDTO);

    /**
     * 启用告模板
     * 启用报告模板
     *
     * @param enableReportTemplateDTO 启用报告模板请求
     * @return 启用报告模板结果
     */
    @PostMapping("/fegin/report-template/enable")
    ResponseEntity<ResponseData> enable(@RequestBody EnableReportTemplateDTO enableReportTemplateDTO);
}
