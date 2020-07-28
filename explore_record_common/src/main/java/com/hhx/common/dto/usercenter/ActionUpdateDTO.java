package com.hhx.common.dto.usercenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionUpdateDTO {

    private Long serviceInfoId;

    private List<Action> actions;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Action {

        private String actionName;

        private String actionAlias;

        private String moduleName;
    }
}
