package com.hhx.common.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.Locale;

/**
 * @author lipeilin
 */
public class PhoneUtil {

    public static boolean isValidNumber(String phone, String region) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = getPhoneNumber(phone, region);
            return phoneUtil.isValidNumber(phoneNumber);
        } catch (NumberParseException e) {
            return false;
        }
    }

    public static boolean isValidChineseNumber(String phoneNumber) {
        return isValidNumber(phoneNumber, Locale.CHINA.getCountry());
    }

    public static Phonenumber.PhoneNumber getPhoneNumber(String phone, String region) throws NumberParseException {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        return phoneUtil.parse(phone, region);
    }

    public static String getFormatNumber(String phone, String region) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber;
        try {
            phoneNumber = getPhoneNumber(phone, region);
        } catch (NumberParseException e) {
            return null;
        }
        return phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    private PhoneUtil() {
        throw new IllegalStateException("PhoneUtil class");
    }
}
