package com.hhx.common.dto.device.upgrade.bo;

import com.hhx.common.dto.device.upgrade.dto.Machine;
import lombok.Data;

import java.util.List;

@Data
public class QueryVisibleMachinesBO {
    private List<Machine> machines;
}
