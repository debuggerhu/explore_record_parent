package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class UnMarkedPositiveException extends AbstractException {
    public UnMarkedPositiveException() {
        super(Error.UNMARKED_POSITIVE);
    }
}
