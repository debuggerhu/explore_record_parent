package com.hhx.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Slf4j
public class CheckParam {

    private static final String REGEX = "^[1-9]+[0-9]*$";

    public static boolean checkDateParam(String date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (StringUtils.isBlank(date))
            return true;

        try {
            Date d = formatter.parse(date);
            return date.equals(formatter.format(d));
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }

    public static boolean checkPageParam(Integer pageNum, Integer pageSize) {
        return checkNumValidity(String.valueOf(pageNum)) || checkNumValidity(String.valueOf(pageSize)) || pageSize > 20;
    }

    private static boolean checkNumValidity(String num) {
        Pattern pattern = Pattern.compile(REGEX);
        return !pattern.matcher(num).matches();
    }
}
