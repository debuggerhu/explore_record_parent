package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class InvalidParamException extends AbstractException {

    public InvalidParamException() {
        super(Error.PARAM_ERROR);
    }
}
