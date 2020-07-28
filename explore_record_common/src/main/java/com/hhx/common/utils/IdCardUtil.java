package com.hhx.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author su Lichen
 * @Date 2020/2/14 17:48
 */
public class IdCardUtil {
    private static final int IDCARD_LENGTH = 18;

    private static final int MAX_MONTH = 12;

    private static final int MIN_MONTH = 1;

    private static final int MIN_DAY = 1;

    private static final int MAX_DAY_OF_LUNAR_MONTH = 30;

    private static final int MAX_DAY_OF_SOLAR_MONTH = 31;

    private static final int MAX_DAY_OF_LEAP_FEBRUARY = 29;

    private static final int MAX_DAY_OF_ORDINARY_FEBRUARY = 28;

    private static final List<Integer> SOLAR_MONTH = Arrays.asList(1, 3, 5, 7, 8, 10, 12) ;

    private static final List<Integer> LUNAR_MONTH = Arrays.asList(4, 6, 9 ,11);

    private static Pattern pattern = Pattern.compile("^[-+]?[\\d]*$");

    public static Date getBirthDay(String idCard) {
        if (!isValid(idCard)) {
            return null;
        }

        String strBirthDay = idCard.substring(6, 14);

        Date birthDay = null;

        try {
            birthDay = new SimpleDateFormat("yyyyMMdd").parse(strBirthDay);
        } catch (ParseException e) {
            return null;
        }

        if (DateUtil.compare(birthDay, new Date())) {
            return null;
        }

        return birthDay;
    }

    public static boolean isValid(String idCard) {
        if (idCard.length() != IDCARD_LENGTH) {
            return false;
        }

        String year = idCard.substring(6, 10);

        String month = idCard.substring(10, 12);

        String day = idCard.substring(12, 14);

        return isValidYear(year) && isValidMonth(month) && isValidDay(year, month, day);
    }

    private static boolean isValidYear(String year) {
        if (!pattern.matcher(year).matches()) {
            return false;
        }

        return Integer.parseInt(year) <= Calendar.getInstance().get(Calendar.YEAR);
    }

    private static boolean isValidMonth(String month) {
        if (!pattern.matcher(month).matches()) {
            return false;
        }

        return Integer.parseInt(month) <= MAX_MONTH && Integer.parseInt(month) >= MIN_MONTH;
    }

    private static boolean isValidDay(String year, String month, String day) {
        if (!pattern.matcher(day).matches()) {
            return false;
        }

        int intYear = Integer.parseInt(year);
        int intMonth = Integer.parseInt(month);
        int intDay = Integer.parseInt(day);

        if (SOLAR_MONTH.contains(intMonth)) {
            return intDay >= MIN_DAY && intDay <= MAX_DAY_OF_SOLAR_MONTH;
        }

        if (LUNAR_MONTH.contains(intMonth)) {
            return intDay >= MIN_DAY && intDay <= MAX_DAY_OF_LUNAR_MONTH;
        }

        if (isLeapYear(intYear)) {
            return intDay >= MIN_DAY && intDay <= MAX_DAY_OF_LEAP_FEBRUARY;
        } else {
            return intDay >= MIN_DAY && intDay <= MAX_DAY_OF_ORDINARY_FEBRUARY;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }

        if (year % 400 == 0) {
            return true;
        }

        return false;
    }
}
