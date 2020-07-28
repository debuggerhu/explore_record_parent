package com.hhx.common.constants;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

@Data
public class Age {

    private int year;

    private int month;

    private int day;

    private int hour;

    private int minute;

    @Override
    public String toString() {
        if (this.year >= 7) {
            return String.valueOf(this.year).concat("岁");
        }

        if (this.year >= 1) {
            return this.month == 0 ? String.valueOf(this.year).concat("岁") : String.valueOf(this.year).concat("岁").concat(String.valueOf(this.month)).concat("月");
        }

        if (this.month >= 1) {
            return this.day == 0 ? String.valueOf(this.month).concat("月") : String.valueOf(this.month).concat("月").concat(String.valueOf(this.day)).concat("天");
        }

        if (this.day >= 1) {
            return this.hour == 0 ? String.valueOf(this.day).concat("天"):  String.valueOf(this.day).concat("天").concat(String.valueOf(this.hour)).concat("小时");
        }

        if (this.hour >= 1) {
            return this.minute == 0 ? String.valueOf(this.hour).concat("小时") : String.valueOf(this.hour).concat("小时").concat(String.valueOf(this.minute)).concat("分钟");
        }

        if (this.minute >= 1) {
            return String.valueOf(this.minute).concat("分钟");
        }

        return "";
    }

    public static String jsonToString(String jsonAge) {
        if (StringUtils.isEmpty(jsonAge)) {
            return "";
        }

        Age age = JSONObject.parseObject(jsonAge).toJavaObject(Age.class);
        return age.toString();
    }

    public static Age jsonToAge(String jsonAge) {
        if (StringUtils.isEmpty(jsonAge)) {
            return new Age();
        }

        return JSONObject.parseObject(jsonAge).toJavaObject(Age.class);
    }

    public static String ageToJson(Age age) {
        if (ObjectUtils.isEmpty(age)) {
            return "";
        }

        return JSONObject.toJSONString(age);
    }
}
