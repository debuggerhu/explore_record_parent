package com.hhx.common.dto.hospital;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HospitalDTO {

    private Long hospitalGuid;

    private String hospitalCode;

    private String hospitalName;

    private String hospitalEnName;

    private String levelName;

    private String typeName;

    private String economicName;

    private String manageName;

    private String openDate;

    private String regCapital;

    private String businessArea;

    private String orgBedCount;

    private String staffCount;

    private String staffWorkCount;

    private String staffHtCount;

    private String address;

    private String postalCode;

    private String telephone;

    private String email;

    private String url;

    private String memo;

    private Date createTime;

    private Date updateTime;

    private Long cloudRegionGuid;

    private List<Long> areaGuid;

    private List<String> areaName;

    private Integer orderNo;

    private Integer isDeleted;

    private String stationName;
}
