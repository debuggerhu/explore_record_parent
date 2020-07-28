package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

/**
 * @Author su Lichen
 * @Date 2020/3/25 14:04
 */
public class InvalidPhoneException extends AbstractException {
    public InvalidPhoneException() {
        super(Error.INVALID_PHONE_NUMBER);
    }
}
