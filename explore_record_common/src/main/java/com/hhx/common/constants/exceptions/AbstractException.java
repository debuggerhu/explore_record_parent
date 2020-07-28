package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public abstract class AbstractException extends Exception {

    private Error error;

    AbstractException(Error error) {
        super(error.name());
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
