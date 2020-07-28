package com.hhx.common.dto.device.upgrade.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class QueryModelAndPurposeListBO {
    /**
     * 型号
     */
    @NotEmpty
    private List<Model> models;

    /**
     * 用途
     */
    @NotEmpty
    private List<Purpose> purposes;

    @Data
    public static class Model{
        @NotBlank
        private String id;
        @NotBlank
        private String name;
    }

    @Data
    public static class Purpose{
        @NotBlank
        private String id;
        @NotBlank
        private String name;
    }
}
