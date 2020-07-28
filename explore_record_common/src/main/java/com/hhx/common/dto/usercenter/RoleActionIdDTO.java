package com.hhx.common.dto.usercenter;

import lombok.Data;

import java.util.List;

@Data
public class RoleActionIdDTO {

    private Long roleInfoId;

    private List<Long> actionInfoIds;
}
