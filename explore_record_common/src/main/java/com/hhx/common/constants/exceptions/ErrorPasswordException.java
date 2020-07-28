package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class ErrorPasswordException extends AbstractException {
    public ErrorPasswordException() {
        super(Error.ERROR_PASSWORD);
    }
}
