package com.hhx.common.utils;

import com.hhx.common.constants.Error;
import com.hhx.common.constants.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

/**
 * @Author su Lichen
 * @Date 2020/5/20 15:37
 */
public class FeginUtil {

    public static ResponseData checkResponse(Object object) {
        ResponseEntity<ResponseData> responseEntity = convert(object);
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            return ResponseData.error(responseEntity.getStatusCode().value(), responseEntity.getStatusCode().getReasonPhrase());
        }

        if (ObjectUtils.isEmpty(responseEntity.getBody())) {
            return ResponseData.error(Error.UNKNOWN_ERROR);
        }

        if (!responseEntity.getBody().getSuccess()) {
            return ResponseData.error(responseEntity.getBody().getStatus(), responseEntity.getBody().getMessage());
        }

        return ResponseData.success();
    }

    private static ResponseEntity<ResponseData> convert(Object object) {
        return (ResponseEntity<ResponseData>) object;
    }
}
