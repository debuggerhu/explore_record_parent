package com.hhx.common.dto.machineapi.exam;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UploadStatisticsDTO {

    //当前页数
    @NotNull
    private Integer pageNumber;
    //页记录数
    @NotNull
    private Integer pageSize;
    //开始日期
    private String beginDate;
    //结束日期
    private String endDate;
    //机器id
    private String machineId;
    //uuid 用以关联查询机器id
    private String uuid;
    //序列号
    private String serialNo;
    //产品类型
    private String product;
    //地址
    private String addr;
    //sim卡号
    private String simICCID;
    //版本号
    private Integer revision;
    //是否为排除地址进行检索
    private Boolean excludeAddr;
}
