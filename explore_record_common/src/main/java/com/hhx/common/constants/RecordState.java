package com.hhx.common.constants;

/**
 * 数据库记录状态
 */
public enum RecordState {

    //正常状态
    NORMAL(0),
    //已删除
    DELETED(1),
    //用于查询时查询所有的参数
    SELECT_ALL(2);

    private int value;

    RecordState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
