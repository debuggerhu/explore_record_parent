package com.hhx.common.utils;

import com.hhx.common.constants.Age;
import org.springframework.util.ObjectUtils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 时间比较函数
     * @param date1 参数1
     * @param date2 参数2
     * @return 当date1 大于等于 date2时，返回true，否则返回false
     */
    public static boolean compare(Date date1, Date date2) {
        return date1.getTime() >= date2.getTime();
    }

    public static Date calculateBirthday(Age age) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -age.getYear());
        calendar.add(Calendar.MONTH, -age.getMonth());
        calendar.add(Calendar.DATE, -age.getDay());
        calendar.add(Calendar.HOUR, -age.getHour());
        calendar.add(Calendar.MINUTE, -age.getMinute());
        return calendar.getTime();
    }

    public static Age calculateAge(Date birthday) {
        if (ObjectUtils.isEmpty(birthday)) {
            return new Age();
        }

        return calculateAge(birthday, new Date());
    }

    public static Age calculateAge(Date birthday, Date calculateDate) {
        if (ObjectUtils.isEmpty(birthday)) {
            return new Age();
        }

        if (ObjectUtils.isEmpty(calculateDate)) {
            return new Age();
        }

        if (compare(birthday, calculateDate)) {
            return new Age();
        }

        Calendar now = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthday);
        now.setTime(calculateDate);

        int year = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) - birth.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY) - birth.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE) - birth.get(Calendar.MINUTE);

        return correctAge(year, month, day, hour, minute, now, birth);
    }

    private static Age correctAge(int year, int month, int day, int hour, int minute, Calendar now, Calendar birth) {
        if (year >= 7) {
            return year(year, month, day, hour, minute, now, birth);
        }

        if (year >= 1) {
            return yearMonth(year, month, day, hour, minute, now, birth);
        }

        if (month >= 1) {
            return monthDay(month, day, hour, minute, now, birth);
        }

        if (day >= 1) {
            return dayHour(day, hour, minute, now, birth);
        }

        if (hour >= 1) {
            return hourMinute(hour, minute);
        }

        return minute(minute);
    }

    private static Age year(int year, int month, int day, int hour, int minute, Calendar now, Calendar birth) {
        if (year == 7 && month < 0) {
            year--;
            month = 12 + month;
            return yearMonth(year, month, day, hour, minute, now, birth);
        }

        Age age = new Age();
        age.setYear(year);

        return age;
    }

    private static Age yearMonth(int year, int month, int day, int hour, int minute, Calendar now, Calendar birth) {
        if (year == 1 && month < 0) {
            month = 12 + month;
            return monthDay(month, day, hour, minute, now, birth);
        }

        if (year == 1 && month == 0 && day < 0) {
            month = 12 + month;
            return monthDay(month, day, hour, minute, now, birth);
        }

        if (month < 0) {
            year--;
            month = 12 + month;
        }

        Age age = new Age();
        age.setYear(year);
        age.setMonth(month);

        return age;
    }

    private static Age monthDay(int month, int day, int hour, int minute, Calendar now, Calendar birth) {
        if (month == 1 && day < 0) {
            day = birth.getActualMaximum(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH) + now.get(Calendar.DAY_OF_MONTH);
            return dayHour(day, hour, minute, now, birth);
        }

        if (month == 1 && day == 0 && hour < 0) {
            day = birth.getActualMaximum(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH) + now.get(Calendar.DAY_OF_MONTH);
            return dayHour(day, hour, minute, now, birth);
        }

        if (day < 0) {
            month--;
            day = birth.getActualMaximum(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH) + now.get(Calendar.DAY_OF_MONTH);
        }

        Age age = new Age();
        age.setMonth(month);
        age.setDay(day);

        return age;
    }

    private static Age dayHour(int day, int hour, int minute, Calendar now, Calendar birth) {
        if (day == 1 && hour < 0) {
            hour = 24 + hour;
            return hourMinute(hour, minute);
        }

        if (day == 1 && hour == 0 && minute < 0) {
            hour = 24 + hour;
            return hourMinute(hour, minute);
        }

        if (hour < 0 ) {
            day--;
            hour = 24 + hour;
        }

        Age age = new Age();
        age.setDay(day);
        age.setHour(hour);

        return age;
    }

    private static Age hourMinute(int hour, int minute) {
        if (hour == 1 && minute < 0) {
            return minute(minute);
        }

        if (minute < 0) {
            hour--;
            minute = 60 + minute;
        }

        Age age = new Age();
        age.setHour(hour);
        age.setMinute(minute);

        return age;
    }

    private static Age minute(int minute) {
        if (minute < 0) {
            minute = 60 + minute;
        }

        Age age = new Age();
        age.setMinute(minute);

        return age;
    }

}
