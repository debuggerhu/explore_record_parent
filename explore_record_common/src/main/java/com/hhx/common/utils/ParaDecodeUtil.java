package com.hhx.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Slf4j
public class ParaDecodeUtil {

    public static String chnParaDecode(String str) {
        if (StringUtils.isNotBlank(str)) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                log.info(e.toString(), e);
            }
        }
        return str;
    }
}

