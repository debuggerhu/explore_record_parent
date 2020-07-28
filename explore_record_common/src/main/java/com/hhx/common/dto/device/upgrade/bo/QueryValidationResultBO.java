package com.hhx.common.dto.device.upgrade.bo;

import lombok.Data;

import java.util.List;

@Data
public class QueryValidationResultBO {
    /**
     * 使用中的策略
     */
    private List<StrategyBO> inUseStrategy;

    /**
     * 其他相关联的策略
     */
    private List<StrategyBO> relatedStrategies;
}
