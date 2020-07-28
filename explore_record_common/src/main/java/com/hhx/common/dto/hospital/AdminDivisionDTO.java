package com.hhx.common.dto.hospital;

import lombok.Data;

import java.util.List;


@Data
public class AdminDivisionDTO {
    private Long adminGuid;
    private String adminName;
    private List<AdminDivisionDTO> childrenAdmins;

    public AdminDivisionDTO() {
    }

    public AdminDivisionDTO(Long adminGuid, String adminName) {
        this.adminGuid = adminGuid;
        this.adminName = adminName;
    }

    public AdminDivisionDTO(Long adminGuid, String adminName, List<AdminDivisionDTO> childrenAdmins) {
        this.adminGuid = adminGuid;
        this.adminName = adminName;
        this.childrenAdmins = childrenAdmins;
    }
}
