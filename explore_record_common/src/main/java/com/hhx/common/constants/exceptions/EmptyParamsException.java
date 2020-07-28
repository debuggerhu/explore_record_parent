package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class EmptyParamsException extends AbstractException {
    public EmptyParamsException() {
        super(Error.EMPTY_PARAMS_ERROR);
    }
}
