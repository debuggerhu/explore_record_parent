package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

/**
 * @Author su Lichen
 * @Date 2020/4/3 17:13
 */
public class NoPermissionsException extends AbstractException {

    public NoPermissionsException(Error error) {
        super(error);
    }
}
