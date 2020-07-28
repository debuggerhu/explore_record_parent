package com.hhx.common.dto.usercenter;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ScopeUpdateDTO {

    private Long serviceInfoId;

    private List<Scope> scopes;

    @Data
    @NoArgsConstructor
    public static class Scope {

        private String scopeName;

        private String scopeAlias;
    }
}
